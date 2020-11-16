package com.example.desafioandroiddigitalhouse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        findViewById<Button>(R.id.btnRegister).setOnClickListener{
            changeRegister()
        }

        findViewById<Button>(R.id.btnLogin).setOnClickListener {
            changeHome()
        }


    }

    fun changeRegister(){
        var intent = Intent(this,RegisterActivity::class.java)
        startActivity(intent)
    }

    fun changeHome(){
        var intent = Intent(this,HomeActivity::class.java)
        startActivity(intent)
    }
}