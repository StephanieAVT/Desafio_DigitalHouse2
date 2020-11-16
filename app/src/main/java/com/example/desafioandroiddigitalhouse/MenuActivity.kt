package com.example.desafioandroiddigitalhouse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MenuActivity : AppCompatActivity(),PratoAdapter.OnPratoClickListener {

    var listaPratos = getPratos()
    var adapter = PratoAdapter(listaPratos, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        findViewById<ImageButton>(R.id.ibArrowBack).setOnClickListener {
            backHome()
        }


        val extras = intent.extras
        var foto = extras?.getInt("imagem")
        var nome = extras?.getString("nome")

        findViewById<TextView>(R.id.tvNomeRestaurante).text = nome
        if (foto != null) {
            findViewById<ImageView>(R.id.ivRestaurante).setImageResource(foto)
        }

        findViewById<RecyclerView>(R.id.rvPratos).adapter = adapter
        findViewById<RecyclerView>(R.id.rvPratos).layoutManager = GridLayoutManager(this, 2)
        findViewById<RecyclerView>(R.id.rvPratos).setHasFixedSize(true)


    }


    fun getPratos(): ArrayList<Prato> {
        val p1 = Prato("Salada com Molho de Gengibre", R.drawable.image2_home_restaurant)
        val p2 =Prato("Salada com Molho de Gengibre", R.drawable.image2_home_restaurant)
        val p3 = Prato("Salada com Molho de Gengibre", R.drawable.image2_home_restaurant)
        val p4 = Prato("Salada com Molho de Gengibre", R.drawable.image2_home_restaurant)
        val p5 = Prato("Salada com Molho de Gengibre", R.drawable.image2_home_restaurant)
        val p6 = Prato("Salada com Molho de Gengibre", R.drawable.image2_home_restaurant)

        return arrayListOf(p1, p2, p3, p4, p5, p6)
    }



   fun backHome(){
       var intent = Intent(this,HomeActivity::class.java)
       startActivity(intent)
   }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun pratoClick(position: Int) {
        var intent = Intent(this, MenuDetailsActivity::class.java)
        var prato: Prato = listaPratos.get(position)
        intent.putExtra("imagem", prato.foto)
       intent.putExtra("nome", prato.nome)
        startActivity(intent)
    }
}


