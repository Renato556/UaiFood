package br.com.cotemig.renato.uaifood.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.TextView
import br.com.cotemig.renato.uaifood.R
import br.com.cotemig.renato.uaifood.models.Account
import br.com.cotemig.renato.uaifood.services.RetrofitInitializer
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var btn_login = findViewById<Button>(R.id.btnLogin)
        btn_login.setOnClickListener{
            login()
        }

        var textForgot = findViewById<TextView>(R.id.textForgot);
        var textRegister = findViewById<TextView>(R.id.textNew);

        textForgot.setOnClickListener {
            getForgotScreen()
        }

        textRegister.setOnClickListener {
            getRegisterScreen()
        }
    }

    fun getForgotScreen(){
        var intent = Intent(this, ForgotActivity::class.java)
        startActivity(intent)
    }

    fun getRegisterScreen(){
        var intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)

    }

    fun login(){

        var account = Account()

        var s = RetrofitInitializer().serviceAccount()
        var login = findViewById<EditText>(R.id.editEmail)
        var password = findViewById<EditText>(R.id.editPassword)

        account.email = login.text.toString()
        account.password = password.text.toString()

        var call = s.auth(account)

        call.enqueue(object : retrofit2.Callback<Account>{
            override fun onResponse(call: Call<Account>, response: Response<Account>) {

                if(response.code() == 200){
                    response.body()?.let {
                        showLogin(it)
                    }
                }else{
                    Toast.makeText(
                    this@MainActivity, "Usuário não encontrado", Toast.LENGTH_LONG).show()

                }

            }

            override fun onFailure(call: Call<Account>, t: Throwable) {
                Toast.makeText(this@MainActivity, "ops", Toast.LENGTH_LONG).show()

            }
        })

    }

    fun showLogin(account: Account){
        var intent = Intent(this, Tela1Activity::class.java)
        intent.putExtra("token", account.token)
        startActivity(intent)
    }

}