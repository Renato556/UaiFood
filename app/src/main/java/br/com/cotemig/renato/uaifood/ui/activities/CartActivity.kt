package br.com.cotemig.renato.uaifood.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ListView
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
    }

    fun getCart(list: List<Produto>) {
        var produto = findViewById<ListView>(R.id.list_cart)
        produto.adapter = CartAdapter(this, list)
    }

    fun backEstabelecimentos() {
        finish()
    }
}