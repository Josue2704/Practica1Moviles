package josue.hernandez.parcialandroidho100221.models

data class NewsResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>
)

data class Article(
    val title: String,
    val description: String,
    val source: Source?,  // Asegúrate de que `Source` sea la clase correcta
    val url: String,
    val urlToImage: String
)

data class Source(
    val name: String
)