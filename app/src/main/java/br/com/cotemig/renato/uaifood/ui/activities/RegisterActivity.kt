package br.com.cotemig.renato.uaifood.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import br.com.cotemig.renato.uaifood.models.Account
import br.com.cotemig.renato.uaifood.R
import br.com.cotemig.renato.uaifood.services.RetrofitInitializer
import retrofit2.Call
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        var arrowBack = findViewById<ImageButton>(R.id.backLogin)
        var possuiConta = findViewById<TextView>(R.id.textPossuiConta)
        var btnRegister = findViewById<Button>(R.id.btnRegister)

        arrowBack.setOnClickListener {
            arrowBackLogin()
        }

        btnRegister.setOnClickListener{
            registerClick()
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

    fun registerClick(){
        var name = findViewById<EditText>(R.id.editName)
        var email = findViewById<EditText>(R.id.editEmail)
        var password = findViewById<EditText>(R.id.editPassword)

        var account = Account()

        account.name = name.text.toString()
        account.password = password.text.toString()
        account.email = email.text.toString()


        var s = RetrofitInitializer().serviceAccount()
        var call = s.create(account)

        call.enqueue(object : retrofit2.Callback<Account> {
            override fun onResponse(call: Call<Account>, response: Response<Account>) {
                if (response.code() == 200) {
                    Toast.makeText(this@RegisterActivity, "Conta criada com sucesso!!", Toast.LENGTH_LONG).show()
                    showLogin()
                }
            }

            override fun onFailure(call: Call<Account>, t: Throwable) {
                Toast.makeText(this@RegisterActivity, "Informações incorretas, verifique os campos novamente =(", Toast.LENGTH_LONG).show()
            }
        })

    }


    fun showLogin(){
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