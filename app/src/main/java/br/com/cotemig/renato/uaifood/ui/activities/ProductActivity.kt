package br.com.cotemig.renato.uaifood.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import br.com.cotemig.renato.uaifood.R
import br.com.cotemig.renato.uaifood.models.Product
import br.com.cotemig.renato.uaifood.services.RetrofitInitializer
import br.com.cotemig.renato.uaifood.ui.adapters.ProductAdapter
import coil.load
import retrofit2.Call
import retrofit2.Response

class ProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

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
        call.enqueue(object : retrofit2.Callback<List<Product>>{
            override fun onResponse(
                call: Call<List<Product>>,
                response: Response<List<Product>>
            ) {
                response.body()?.let {
                    showListProduto(it)
                }
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                Toast.makeText(this@ProductActivity, "Ocorreu um erro, tente novamente", Toast.LENGTH_LONG).show()
            }
        })
    }

    fun loadProduto(product: Product) {
        var intent = Intent(this, ProductDetailActivity::class.java)
        intent.putExtra("nomeProduto", product.nomePrato)
        intent.putExtra("descProduto", product.descricaoPrato)
        intent.putExtra("precoProduto", product.precoPrato)
        startActivity(intent)
    }

    fun showListProduto(list : List<Product>) {
        var produto = findViewById<ListView>(R.id.list_item)
        produto.adapter = ProductAdapter(this, list)

        produto.setOnItemClickListener { parent, view, position, id ->
            loadProduto(list[position])
        }
    }

    fun arrowBackEstabelecimentos() {
        finish()
    }

}