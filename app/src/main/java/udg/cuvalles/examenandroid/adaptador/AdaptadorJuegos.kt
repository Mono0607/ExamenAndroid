package udg.cuvalles.examenandroid.adaptador

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import udg.cuvalles.examenandroid.R
import udg.cuvalles.examenandroid.modelo.Juego

class AdaptadorJuegos(val listaJuegos: ArrayList<Juego>): RecyclerView.Adapter<AdaptadorJuegos.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.vista_individual,parent,false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        Picasso.get().load(listaJuegos[position].imagen).into(holder.ivImagen)
        holder.tvNombre.text = listaJuegos[position].nombre
        holder.tvGenero.text = listaJuegos[position].genero
        holder.tvPlataforma.text = listaJuegos[position].plataforma
        holder.tvPublicador.text = listaJuegos[position].publicador
    }
    override fun getItemCount(): Int {
        return  listaJuegos.size
    }
    class ViewHolder(vista: View): RecyclerView.ViewHolder(vista){
        val ivImagen: ImageView
        val tvNombre: TextView
        val tvGenero: TextView
        val tvPlataforma: TextView
        val tvPublicador: TextView

        init {
            tvNombre = vista.findViewById(R.id.tvTitulo)
            ivImagen= vista.findViewById(R.id.ivImagen)
            tvGenero= vista.findViewById(R.id.tvGenero)
            tvPlataforma= vista.findViewById(R.id.tvPlataforma)
            tvPublicador= vista.findViewById(R.id.tvPublicador)
        }
    }
}

