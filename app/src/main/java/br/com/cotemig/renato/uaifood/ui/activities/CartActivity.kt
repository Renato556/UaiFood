package br.com.cotemig.renato.uaifood.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ListView
import android.widget.Toast
import br.com.cotemig.renato.uaifood.R
import br.com.cotemig.renato.uaifood.app.AppUaiFood
import br.com.cotemig.renato.uaifood.models.Produto
import br.com.cotemig.renato.uaifood.ui.adapters.CartAdapter

class CartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        getCart(AppUaiFood.list)

        var arrowBack = findViewById<ImageButton>(R.id.backEstabelecimentos)
        arrowBack.setOnClickListener {
            backEstabelecimentos()
        }

        var btnLimpar = findViewById<Button>(R.id.btn_limpar)
        btnLimpar.setOnClickListener {
            clearCart()
        }

        var btnFinalizar = findViewById<Button>(R.id.btn_finalizar)
        btnFinalizar.setOnClickListener {
            finalizarPedido()
        }
    }

    fun getCart(list: List<Produto>) {
        var produto = findViewById<ListView>(R.id.list_cart)
        produto.adapter = CartAdapter(this, list)
    }

    fun backEstabelecimentos() {
        finish()
    }

    fun clearCart() {
        AppUaiFood.list.clear()
        Toast.makeText(
            this@CartActivity,
            "Carrinho limpo",
            Toast.LENGTH_SHORT
        ).show()
        backEstabelecimentos()
    }

    fun finalizarPedido() {
        var intent = Intent(this, OrderActivity::class.java)
        startActivity(intent)
        clearCart()
        finish()
    }
}