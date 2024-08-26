import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import josue.hernandez.parcialandroidho100221.R
import josue.hernandez.parcialandroidho100221.models.Article

class NewsAdapter(private val articles: List<Article>) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val article = articles[position]
        holder.bind(article)
    }

    override fun getItemCount(): Int = articles.size

    inner class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.newsTitleTextView)
        private val sourceTextView: TextView = itemView.findViewById(R.id.newsSourceTextView)
        private val imageView: ImageView = itemView.findViewById(R.id.newsImageView)

        fun bind(article: Article) {
            titleTextView.text = article.title
            sourceTextView.text = article.source?.name ?: "Unknown Source"

            // Si el artículo tiene una imagen, la cargamos con Glide
            if (!article.urlToImage.isNullOrEmpty()) {
                imageView.visibility = View.VISIBLE
                Glide.with(itemView.context)
                    .load(article.urlToImage)
                    .into(imageView)
            } else {
                imageView.visibility = View.GONE
            }
        }
    }
}

