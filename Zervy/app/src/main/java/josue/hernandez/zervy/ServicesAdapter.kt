package josue.hernandez.zervy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ServicesAdapter(private val servicesList: List<Service>) :
    RecyclerView.Adapter<ServicesAdapter.ServiceViewHolder>() {

    // ViewHolder interno que contiene las vistas del item (card de cada servicio)
    class ServiceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val serviceImage: ImageView = itemView.findViewById(R.id.serviceImage)
        val serviceTitle: TextView = itemView.findViewById(R.id.serviceTitle)
    }

    // Inflamos la vista de cada item del RecyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_service, parent, false)
        return ServiceViewHolder(view)
    }

    // Vinculamos los datos de la lista con las vistas (imagen y título)
    override fun onBindViewHolder(holder: ServiceViewHolder, position: Int) {
        val service = servicesList[position]
        holder.serviceTitle.text = service.title
        holder.serviceImage.setImageResource(service.imageResId)
    }

    // Tamaño de la lista
    override fun getItemCount(): Int {
        return servicesList.size
    }
}
