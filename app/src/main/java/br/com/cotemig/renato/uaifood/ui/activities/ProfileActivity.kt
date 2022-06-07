package br.com.cotemig.renato.uaifood.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import br.com.cotemig.renato.uaifood.R
import br.com.cotemig.renato.uaifood.models.Account
import br.com.cotemig.renato.uaifood.services.RetrofitInitializer
import retrofit2.Call
import retrofit2.Response

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        setDados()

        var arrowBack = findViewById<ImageButton>(R.id.backEstabelecimentos)

        arrowBack.setOnClickListener {
            getEstabelecimentos()
        }

        var btnLogout = findViewById<Button>(R.id.btnLogout)

        btnLogout.setOnClickListener {
            logout()
        }
    }

    fun setDados() {
        var name = findViewById<TextView>(R.id.nome_salvo)
        name.text = intent.getStringExtra("name")

        var email = findViewById<TextView>(R.id.email_salvo)
        email.text = intent.getStringExtra("email")
    }

    fun getEstabelecimentos() {
        var intent = Intent(this, HomeActivity::class.java)
        intent.putExtra("name", this.intent.getStringExtra("name"))
        intent.putExtra("email", this.intent.getStringExtra("email"))
        startActivity(intent)
        finish()
    }

    fun logout() {
        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}