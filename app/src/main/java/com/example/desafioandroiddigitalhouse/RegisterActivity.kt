package com.example.desafioandroiddigitalhouse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        findViewById<Button>(R.id.btnRegisterRegister).setOnClickListener {
            changeHome()
        }

    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

     fun changeHome() {
         var intent = Intent(this,HomeActivity::class.java)
         startActivity(intent)

    }

}