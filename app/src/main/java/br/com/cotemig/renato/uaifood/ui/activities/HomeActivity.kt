package br.com.cotemig.renato.uaifood.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import br.com.cotemig.renato.uaifood.R
import br.com.cotemig.renato.uaifood.models.Estabelecimento
import br.com.cotemig.renato.uaifood.services.RetrofitInitializer
import br.com.cotemig.renato.uaifood.ui.adapters.EstabelecimentoAdapter
import retrofit2.Call
import retrofit2.Response

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        getEstabelecimentos()
    }

    fun getEstabelecimentos(){
        var s = RetrofitInitializer().serviceUaiFood()
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
                Toast.makeText(this@HomeActivity, "Ocorreu um erro, tente novamente", Toast.LENGTH_LONG).show()
            }
        })
    }

    fun showListEstabelecimentos(list: List<Estabelecimento>){
        var estabelecimento = findViewById<ListView>(R.id.list_Estabelecimentos)
        estabelecimento.adapter = EstabelecimentoAdapter(this, list)

        estabelecimento.setOnItemClickListener { parent, view, position, id ->
            showProdutos(list[position])
        }
    }

    fun showProdutos(estabelecimento: Estabelecimento) {
        var intent = Intent(this, ProdutoActivity::class.java)
        intent.putExtra("id", estabelecimento.id)
        intent.putExtra("nomeEstabelecimento", estabelecimento.nome)
        intent.putExtra("imagemEstabelecimento", estabelecimento.imagem)
        startActivity(intent)
    }
}