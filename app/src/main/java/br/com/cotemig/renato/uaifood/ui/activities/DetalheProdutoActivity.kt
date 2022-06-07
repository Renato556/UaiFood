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
        descProduto.text = intent.getStringExtra("descProduto").toString()
        precoProduto.text = intent.getStringExtra("precoProduto").toString()

        adicionaRemove()
    }

    fun adicionaRemove(){
        var btnMais = findViewById<Button>(R.id.btn_mais)
        var btnMenos = findViewById<Button>(R.id.btn_menos)
        var txtQtd = findViewById<TextView>(R.id.txt_qtd)

        btnMais.setOnClickListener {
            var txtNovaQtd = findViewById<TextView>(R.id.txt_qtd)
            txtNovaQtd.text = (txtQtd.text.toString().toInt() + 1).toString();
        }

        btnMenos.setOnClickListener {
            var txtNovaQtd = findViewById<TextView>(R.id.txt_qtd)
            if(txtQtd.text.toString().toInt() > 1){
                txtNovaQtd.text = (txtQtd.text.toString().toInt() - 1).toString();
            }
        }
    }
}