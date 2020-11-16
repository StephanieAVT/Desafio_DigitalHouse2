package com.example.desafioandroiddigitalhouse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.desafioandroiddigitalhouse.R.*

class HomeActivity : AppCompatActivity(),RestauranteAdapter.OnRestauranteClickListener {


    var listaRestaurantes = getRestaurantes()
    var adapter = RestauranteAdapter(listaRestaurantes, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_home)


        findViewById<RecyclerView>(R.id.rvHome).adapter = adapter
        findViewById<RecyclerView>(R.id.rvHome).layoutManager = LinearLayoutManager(this)
        findViewById<RecyclerView>(R.id.rvHome).setHasFixedSize(true)
    }
    fun getRestaurantes(): ArrayList<Restaurante> {
        val r1 = Restaurante("Tony Roma's", "Av. Lavandisca, 717 - Indianópolis, São Paulo", "Fecha às 22:00", R.drawable.image1_home_restaurant)
        val r2 = Restaurante("Aoyama - Moema", "Alameda dos Arapanés, 532 - Moema", "Fecha às 00:00", R.drawable.image2_home_restaurant)
        val r3 = Restaurante("Outback - Moema", "Av. Moaci, 187, 187 - Moema, São Paulo", "Fecha às 00:00", R.drawable.image3_home_restaurant)
        val r4 = Restaurante("Sí Señor!", "Alameda Jauaperi, 626 - Moema", "Fecha às 01:00", R.drawable.image4_home_restaurant)

        return arrayListOf(r1, r2, r3, r4)
    }

    override fun restauranteClick(position: Int) {
        var intent = Intent(this, MenuActivity::class.java)
        var restaurante: Restaurante = listaRestaurantes.get(position)

        intent.putExtra("imagem", restaurante.foto)
        intent.putExtra("nome", restaurante.nome)

        startActivity(intent)
    }
    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }


    }
