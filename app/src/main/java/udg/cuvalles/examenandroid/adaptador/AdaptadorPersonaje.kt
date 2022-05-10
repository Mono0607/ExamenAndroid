package udg.cuvalles.examenandroid.adaptador

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import udg.cuvalles.examenandroid.R
import udg.cuvalles.examenandroid.modelo.Personajes

class AdaptadorPersonaje(val listaPersonajes: ArrayList<Personajes>): RecyclerView.Adapter<AdaptadorPersonaje.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.vista_individual,parent,false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        Picasso.get().load(listaPersonajes[position].imagen).into(holder.ivPersonaje)
        holder.tvNombre.text = listaPersonajes[position].nombre
        holder.tvCoste.text = listaPersonajes[position].coste
        holder.tvTipo.text = listaPersonajes[position].tipo
        holder.tvRareza.text = listaPersonajes[position].rareza
        holder.tvPoder.text = listaPersonajes[position].poder
        holder.tvDefensa.text = listaPersonajes[position].defensa
    }

    override fun getItemCount(): Int {
        return  listaPersonajes.size
    }
    class ViewHolder(vista: View): RecyclerView.ViewHolder(vista){
        val ivPersonaje: ImageView
        val tvNombre: TextView
        val tvCoste: TextView
        val tvTipo: TextView
        val tvRareza: TextView
        val tvPoder: TextView
        val tvDefensa: TextView

        init {
            tvNombre = vista.findViewById(R.id.tvNombre)
            ivPersonaje= vista.findViewById(R.id.ivPersonaje)
            tvCoste= vista.findViewById(R.id.tvCoste)
            tvTipo= vista.findViewById(R.id.tvTipo)
            tvRareza= vista.findViewById(R.id.tvRareza)
            tvPoder= vista.findViewById(R.id.tvPoder)
            tvDefensa= vista.findViewById(R.id.tvDefensa)
        }
    }
}