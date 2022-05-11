package udg.cuvalles.examenandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import udg.cuvalles.examenandroid.adaptador.AdaptadorJuegos
import udg.cuvalles.examenandroid.modelo.Juego

class MainActivity : AppCompatActivity() {
    lateinit var btnIntegrantes: Button
    lateinit var listaPersonajes:ArrayList<Juego>
    lateinit var adapter: AdaptadorJuegos
    lateinit var myRecycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnIntegrantes = findViewById(R.id.btnIntegrantes)

        btnIntegrantes.setOnClickListener {
            val intentIntegrantes= Intent(this,Integrantes::class.java)
            startActivity(intentIntegrantes)
        }
        listaPersonajes = ArrayList()
        adapter = AdaptadorJuegos(listaPersonajes)

        myRecycler=findViewById(R.id.recyclerView)
        myRecycler.adapter = adapter
        getPersonajes()

        myRecycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    fun getPersonajes(){
        val queue = Volley.newRequestQueue(this)
        val url = "https://api.magicthegathering.io/v1/cards"

        val objectRequest = JsonObjectRequest(
            Request.Method.GET,url,null,
            Response.Listener{ respuesta ->

                val personajesJson = respuesta.getJSONArray("cards")
                for(indice in 0..personajesJson.length()-1){
                    val personajeIndJson = personajesJson.getJSONObject(indice)
                    val personaje = Juego(personajeIndJson.getString("name"),
                        personajeIndJson.getString("imageUrl"),
                        personajeIndJson.getString("manaCost"),
                        personajeIndJson.getString("type"),
                        personajeIndJson.getString("rarity"),
                        personajeIndJson.getString("power"),
                        personajeIndJson.getString("toughness"))
                    listaPersonajes.add(personaje)
                }
                adapter.notifyDataSetChanged()
            },
            Response.ErrorListener{
                Log.e("PersonajesAPI","Error")
            }
        )
        queue.add(objectRequest)
    }
}