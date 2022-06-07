package br.com.cotemig.renato.uaifood.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import br.com.cotemig.renato.uaifood.R
import br.com.cotemig.renato.uaifood.app.AppUaiFood
import br.com.cotemig.renato.uaifood.ui.adapters.CartAdapter

class CartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        getCart()
    }

    fun getCart(){
        var produto = findViewById<ListView>(R.id.list_item)
        println(AppUaiFood.list[0].nomePrato)
        produto.adapter = CartAdapter(this, AppUaiFood.list)
    }
}