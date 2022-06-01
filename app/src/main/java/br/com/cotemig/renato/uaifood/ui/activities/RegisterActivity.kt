package br.com.cotemig.renato.uaifood.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import br.com.cotemig.renato.uaifood.R

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        var arrowBack = findViewById<ImageButton>(R.id.backLogin)
        var possuiConta = findViewById<TextView>(R.id.textPossuiConta)

        arrowBack.setOnClickListener {
            arrowBackLogin();
        }

        possuiConta.setOnClickListener {
            possuiContaClick()
        }
    }

    fun arrowBackLogin(){
        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun possuiContaClick(){
        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}