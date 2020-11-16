package com.example.desafioandroiddigitalhouse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class MenuDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_menu)
        findViewById<ImageButton>(R.id.ibArrowBack).setOnClickListener {
            backHome()
        }

        val extras = intent.extras
        var foto = extras?.getInt("imagem")
        var nome = extras?.getString("nome")

        if (foto != null) {
            findViewById<ImageView>(R.id.ivRestaurante).setImageResource(foto)
        }
        findViewById<TextView>(R.id.tvNomePrato).text = nome


    }
    fun backHome(){
        var intent = Intent(this,MenuActivity::class.java)
        startActivity(intent)
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}