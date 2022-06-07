package br.com.cotemig.renato.uaifood.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import br.com.cotemig.renato.uaifood.R
import br.com.cotemig.renato.uaifood.models.Estabelecimento
import br.com.cotemig.renato.uaifood.models.Produto
import br.com.cotemig.renato.uaifood.services.RetrofitInitializer
import br.com.cotemig.renato.uaifood.ui.adapters.ProdutoAdapter
import coil.load
import retrofit2.Call
import retrofit2.Response

class ProdutoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produto)

        var id = intent.getStringExtra("id").toString()
        var nomeEstabelecimento = findViewById<TextView>(R.id.nome_restaurante)
        var imagemEstabelecimento = findViewById<ImageView>(R.id.img_estabelecimento)

        nomeEstabelecimento.text = intent.getStringExtra("nomeEstabelecimento").toString()
        imagemEstabelecimento.load(intent.getStringExtra("imagemEstabelecimento"))

        getProduto(id)

        var arrowBack = findViewById<ImageButton>(R.id.backProdutos)
        arrowBack.setOnClickListener {
            arrowBackEstabelecimentos()
        }
    }

    fun getProduto(id : String){
        var s = RetrofitInitializer().serviceUaiFood()
        var call = s.getPratos(id)
        call.enqueue(object : retrofit2.Callback<List<Produto>>{
            override fun onResponse(
                call: Call<List<Produto>>,
                response: Response<List<Produto>>
            ) {
                response.body()?.let {
                    showListProduto(it)
                }
            }

            override fun onFailure(call: Call<List<Produto>>, t: Throwable) {
                Toast.makeText(this@ProdutoActivity, "Ocorreu um erro, tente novamente", Toast.LENGTH_LONG).show()
            }
        })
    }

    fun loadProduto(produto: Produto) {
        var intent = Intent(this, DetalheProdutoActivity::class.java)
        intent.putExtra("nomeProduto", produto.nomePrato)
        intent.putExtra("descProduto", produto.descricaoPrato)
        intent.putExtra("precoProduto", produto.precoPrato)
        startActivity(intent)
    }

    fun showListProduto(list : List<Produto>) {
        var produto = findViewById<ListView>(R.id.list_item)
        produto.adapter = ProdutoAdapter(this, list)

        produto.setOnItemClickListener { parent, view, position, id ->
            loadProduto(list[position])
        }
    }

    fun arrowBackEstabelecimentos() {
        finish()
    }

}