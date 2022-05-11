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
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import udg.cuvalles.examenandroid.adaptador.AdaptadorJuegos
import udg.cuvalles.examenandroid.modelo.Juego

class MainActivity : AppCompatActivity() {
    lateinit var btnIntegrantes: Button
    lateinit var listaJuegos:ArrayList<Juego>
    lateinit var adapter: AdaptadorJuegos
    lateinit var miRecycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnIntegrantes = findViewById(R.id.btnIntegrantes)

        btnIntegrantes.setOnClickListener {
            val intentIntegrantes= Intent(this,Integrantes::class.java)
            startActivity(intentIntegrantes)
        }
        listaJuegos = ArrayList()
        adapter = AdaptadorJuegos(listaJuegos)

        miRecycler=findViewById(R.id.recyclerView)
        miRecycler.adapter = adapter
        getJuegos()

        miRecycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    fun getJuegos(){
        val queue = Volley.newRequestQueue(this)
        val url = "https://www.mmobomb.com/api1/games"

        val objectRequest = JsonArrayRequest(Request.Method.GET,url,null,
            Response.Listener{ respuesta ->
                for(indice in 0..respuesta.length()-1){
                    val juegosJson = respuesta.getJSONObject(indice)
                    val juego = Juego(juegosJson.getString("title"),
                        juegosJson.getString("thumbnail"),
                        juegosJson.getString("genre"),
                        juegosJson.getString("platform"),
                        juegosJson.getString("publisher"))
                    listaJuegos.add(juego)
                }
                adapter.notifyDataSetChanged()
            },
            Response.ErrorListener{
                Log.e("JuegosAPI","Error")
            }
        )
        queue.add(objectRequest)
    }
}