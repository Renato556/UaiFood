package br.com.cotemig.renato.uaifood.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import br.com.cotemig.renato.uaifood.R
import br.com.cotemig.renato.uaifood.models.Estabelecimento
import br.com.cotemig.renato.uaifood.services.RetrofitInitializer
import br.com.cotemig.renato.uaifood.ui.adapters.UaiFoodAdapter
import retrofit2.Call
import retrofit2.Response

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        getEstabelecimentos()
    }

    fun getEstabelecimentos(){
        var s = RetrofitInitializer().serviceEstabelecimentos()
        var call = s.getRestaurantes()

        call.enqueue(object : retrofit2.Callback<List<Estabelecimento>>{
            override fun onResponse(
                call: Call<List<Estabelecimento>>,
                response: Response<List<Estabelecimento>>
            ) {
                response.body()?.let {
                    showListEstabelecimentos(it)
                }
            }

            override fun onFailure(call: Call<List<Estabelecimento>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    fun showListEstabelecimentos(list: List<Estabelecimento>){
        var estabelecimento = findViewById<ListView>(R.id.list_Estabelecimentos)
        estabelecimento.adapter = UaiFoodAdapter(this, list)
    }
}