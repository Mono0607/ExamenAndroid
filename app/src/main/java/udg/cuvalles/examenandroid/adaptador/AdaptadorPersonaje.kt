package udg.cuvalles.examenandroid.adaptador

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import udg.cuvalles.examenandroid.R
import udg.cuvalles.examenandroid.modelo.Personaje

class AdaptadorPersonaje(val listaPersonajes: ArrayList<Personaje>): RecyclerView.Adapter<AdaptadorPersonaje.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.vista_individual,parent,false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        Picasso.get().load(listaPersonajes[position].imagen).into(holder.ivPersonaje)
        holder.tvNombre.text = listaPersonajes[position].nombre
        holder.tvHobby.text = listaPersonajes[position].hobby
        holder.tvPersonalidad.text = listaPersonajes[position].personalidad
        holder.tvCumple.text = listaPersonajes[position].cumple
        holder.tvEspecie.text = listaPersonajes[position].especie
        holder.tvGenero.text = listaPersonajes[position].genero
    }
    override fun getItemCount(): Int {
        return  listaPersonajes.size
    }
    class ViewHolder(vista: View): RecyclerView.ViewHolder(vista){
        val ivPersonaje: ImageView
        val tvNombre: TextView
        val tvHobby: TextView
        val tvPersonalidad: TextView
        val tvCumple: TextView
        val tvEspecie: TextView
        val tvGenero: TextView

        init {
            tvNombre = vista.findViewById(R.id.tvNombre)
            ivPersonaje= vista.findViewById(R.id.ivPersonaje)
            tvHobby= vista.findViewById(R.id.tvHobby)
            tvPersonalidad= vista.findViewById(R.id.tvPersonalidad)
            tvCumple= vista.findViewById(R.id.tvCumple)
            tvEspecie= vista.findViewById(R.id.tvEspecie)
            tvGenero= vista.findViewById(R.id.tvGenero)
        }
    }
}