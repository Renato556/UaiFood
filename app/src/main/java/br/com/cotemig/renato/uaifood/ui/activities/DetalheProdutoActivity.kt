package br.com.cotemig.renato.uaifood.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import br.com.cotemig.renato.uaifood.R
import br.com.cotemig.renato.uaifood.app.AppUaiFood
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
        descProduto.text = intent.getStringExtra("descProduto").toString()
        precoProduto.text = intent.getStringExtra("precoProduto").toString()

        var btnAdicionar = findViewById<Button>(R.id.btn_adicionar)
        btnAdicionar.setOnClickListener {
            adicionarCarrinho()
        }

        var arrowBack = findViewById<ImageButton>(R.id.backProdutos)
        arrowBack.setOnClickListener {
            backProdutos()
        }
    }

    fun adicionarCarrinho(){
        var p = Produto()
        p.nomePrato = intent.getStringExtra("nomeProduto").toString()
        p.descricaoPrato = intent.getStringExtra("descProduto").toString()
        p.precoPrato = intent.getStringExtra("precoProduto").toString()

        Toast.makeText(
            this@DetalheProdutoActivity,
            "Adicionado ao carrinho!",
            Toast.LENGTH_SHORT
        ).show()

        AppUaiFood.list.add(p)
    }

    fun backProdutos() {
        finish()
    }
}