package br.com.cotemig.renato.uaifood.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import br.com.cotemig.renato.uaifood.R
import br.com.cotemig.renato.uaifood.models.Account
import br.com.cotemig.renato.uaifood.services.RetrofitInitializer
import retrofit2.Call
import retrofit2.Response

class ForgotActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot)

        var arrowBack = findViewById<ImageButton>(R.id.backLogin)
        arrowBack.setOnClickListener {
            arrowBackLogin();
        }

        var btnRedefinir = findViewById<Button>(R.id.btnForgot)
        btnRedefinir.setOnClickListener {
            forgotClick()
        }
    }

    fun arrowBackLogin(){
        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun forgotClick(){
        var email = findViewById<EditText>(R.id.editEmail)

        var account = Account()

        account.email = email.text.toString()

        var s = RetrofitInitializer().serviceAccount()
        var call = s.forgot(account)

        call.enqueue(object : retrofit2.Callback<Account> {
            override fun onResponse(call: Call<Account>, response: Response<Account>) {
                if (response.code() == 204) {
                    Toast.makeText(this@ForgotActivity, "Email de recuperação enviado", Toast.LENGTH_LONG).show()
                    arrowBackLogin()
                } else {
                    Toast.makeText(this@ForgotActivity, "Erro ao recuperar senha", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<Account>, t: Throwable) {
                Toast.makeText(this@ForgotActivity, "Ocorreu um erro, tente novamente", Toast.LENGTH_LONG).show()
            }
        })
    }
}