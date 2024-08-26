
Memoria actualizada
Aquí tienes la documentación redactada en tercera persona:

Cómo Se Desarrolló la App de Noticias en Android
1. Iniciando con Android Studio
El proceso comenzó en Android Studio, donde se creó un nuevo proyecto utilizando la opción "Empty Activity" para empezar desde cero. Se le asignó un nombre al proyecto, se seleccionó Kotlin como lenguaje, y se configuró el SDK mínimo en 24 para garantizar la compatibilidad con la mayoría de los dispositivos.

Después de la creación del proyecto, se dirigió al archivo build.gradle.kts del módulo app para agregar las dependencias necesarias. Se utilizó un archivo libs.versions.toml para manejar las versiones y dependencias de una manera más organizada.

2. Agregando Dependencias
En el archivo build.gradle.kts, se añadieron las dependencias necesarias para hacer que la app funcione correctamente:

implementation(libs.androidx.core.ktx)
implementation(libs.androidx.appcompat)
implementation(libs.material)
implementation(libs.androidx.activity)
implementation(libs.androidx.constraintlayout)
implementation(libs.retrofit)
implementation(libs.gsonConverter)
implementation(libs.coroutinesAndroid)
implementation("com.github.bumptech.glide:glide:4.15.1")
kapt("com.github.bumptech.glide:compiler:4.15.1")
Estas dependencias permiten manejar las peticiones a la API, trabajar con JSON, manejar hilos con Coroutines y cargar imágenes con Glide.

3. Activando ViewBinding
Para simplificar el trabajo con las vistas, se activó viewBinding en la configuración de Android:

android {
    ...
    viewBinding.enable = true
}
Esto facilita el acceso a las vistas desde el código, eliminando la necesidad de utilizar findViewById en cada vista.

4. Diseño de la Interfaz
En activity_main.xml, se diseñó la interfaz principal utilizando un RecyclerView para mostrar la lista de noticias. Luego, se creó un archivo adicional llamado item_news.xml para definir cómo se verá cada noticia en la lista.

En item_news.xml, se incluyeron un TextView para el título, otro para la fuente, y un ImageView para mostrar la imagen de la noticia, si está disponible.

5. Creación del Modelo de Datos
En el paquete models, se crearon las clases Article y Source para representar la estructura de cada noticia y su fuente, respectivamente.

6. Configuración de Retrofit
En el paquete network, se configuró Retrofit para realizar las peticiones a la API de NewsAPI. Se creó una clase ApiClient para manejar la URL base y un ApiService donde se definieron los métodos para hacer las peticiones:

interface ApiService {
    @GET("top-headlines")
    fun getTopHeadlines(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String
    ): Call<NewsResponse>
}
También se configuró ApiClient para gestionar la instancia de Retrofit:

object ApiClient {
    private const val BASE_URL = "https://newsapi.org/v2/"

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}
7. Creación del Adaptador del RecyclerView
Luego, se creó el adaptador NewsAdapter en el paquete adapters para conectar los datos de cada artículo con las vistas en item_news.xml. Dentro de la clase NewsViewHolder, se agregó el método bind para cargar los datos y las imágenes con Glide:

fun bind(article: Article) {
    titleTextView.text = article.title
    sourceTextView.text = article.source?.name ?: "Unknown Source"

    if (!article.urlToImage.isNullOrEmpty()) {
        imageView.visibility = View.VISIBLE
        Glide.with(itemView.context)
            .load(article.urlToImage)
            .into(imageView)
    } else {
        imageView.visibility = View.GONE
    }
}
8. Obteniendo las Noticias
En MainActivity, se hizo la petición a la API y se manejó la respuesta para llenar el RecyclerView con las noticias. Se inicializó apiService utilizando ApiClient y luego se realizó la solicitud:

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val apiService = ApiClient.apiService // Inicialización de apiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fetchNews() // Llamada para obtener las noticias
    }

    private fun fetchNews() {
        val call = apiService.getTopHeadlines("us", BuildConfig.NEWS_API_KEY)
        call.enqueue(object : Callback<NewsResponse> {
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                if (response.isSuccessful) {
                    val articles = response.body()?.articles ?: emptyList()
                    binding.recyclerView.adapter = NewsAdapter(articles)
                } else {
                    Log.e("MainActivity", "Error in response: ${response.errorBody()?.string()}")
                }
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                Log.e("MainActivity", "Failed to fetch news", t)
            }
        })
    }
}
9. Permisos de Internet
Para que la app pueda acceder a internet, se añadió el permiso correspondiente en el AndroidManifest.xml:

<uses-permission android:name="android.permission.INTERNET" />
10. Actualización Automática de Noticias
Para mantener la app actualizada, se añadió un Handler en MainActivity que realiza una nueva solicitud a la API cada minuto y actualiza las noticias:

private val handler = Handler(Looper.getMainLooper())
private val updateInterval: Long = 60000 // 1 minuto en milisegundos

private val updateRunnable = object : Runnable {
    override fun run() {
        fetchNews() // Llamada para actualizar las noticias
        handler.postDelayed(this, updateInterval)
    }
}

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    handler.post(updateRunnable) // Iniciar el ciclo de actualización automática
}

override fun onDestroy() {
    super.onDestroy()
    handler.removeCallbacks(updateRunnable) // Detener el ciclo de actualización cuando se destruye la actividad
}

11. Conclusión
Con todo lo anterior, se logró crear una app sencilla pero funcional que muestra las noticias más recientes utilizando la API de NewsAPI. Utilizando Kotlin, Retrofit, y Glide, se manejaron las peticiones, la carga de imágenes y la actualización automática de los datos.
