package br.com.cotemig.renato.uaifood.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import br.com.cotemig.renato.uaifood.R
import br.com.cotemig.renato.uaifood.models.Produto
import br.com.cotemig.renato.uaifood.services.RetrofitInitializer
import br.com.cotemig.renato.uaifood.ui.adapters.ProdutoAdapter
import coil.load
import retrofit2.Call
import retrofit2.Response

class DetalheProdutoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe_produto)

        var nomeProduto = findViewById<TextView>(R.id.nome_produto_detalhe)
        var descProduto = findViewById<TextView>(R.id.desc_produto_detalhe)
        var precoProduto = findViewById<TextView>(R.id.valor_produto_detalhe)

        nomeProduto.text = intent.getStringExtra("nomeProduto").toString()

        //getProduto(nomeProduto)

        descProduto.text = intent.getStringExtra("descProduto").toString()
        precoProduto.text = intent.getStringExtra("precoProduto").toString()

        adicionaRemove()
    }

    fun adicionaRemove(){
        var btnMais = findViewById<Button>(R.id.btn_mais)
        var btnMenos = findViewById<Button>(R.id.btn_menos)
        var txtQtd = findViewById<TextView>(R.id.txt_qtd).toString()

        btnMais.setOnClickListener {
            var txtNovaQtd = findViewById<TextView>(R.id.txt_qtd)
            txtNovaQtd.text = (txtQtd.toInt() + 1).toString();
        }

        btnMenos.setOnClickListener {
            var txtNovaQtd = findViewById<TextView>(R.id.txt_qtd)
            if(txtQtd.toInt() >= 0){
                txtNovaQtd.text = (txtQtd.toInt() + 1).toString();
            }
        }
    }

//    fun getProduto(nomePrato: Produto){
//        var s = RetrofitInitializer().serviceUaiFood()
//        var call = s.getPrato(nomePrato)
//        call.enqueue(object : retrofit2.Callback<List<Produto>>{
//            override fun onResponse(
//                call: Call<List<Produto>>,
//                response: Response<List<Produto>>
//            ) {
//                response.body()?.let {
//                    showProduto(it)
//                }
//            }
//
//            override fun onFailure(call: Call<List<Produto>>, t: Throwable) {
//                Toast.makeText(this@ProdutoActivity, "Ocorreu um erro, tente novamente", Toast.LENGTH_LONG).show()
//            }
//        })
//    }
//
//    fun showProduto(produto : Produto) {
//        var produto = findViewById<ListView>(R.id.list_item)
//        produto.adapter = ProdutoAdapter(this, list)
//
//        produto.setOnItemClickListener { parent, view, position, id ->
//            loadProduto(list[position])
//        }
//    }
}