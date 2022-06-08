package br.com.cotemig.renato.uaifood.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import br.com.cotemig.renato.uaifood.R

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        var arrowBack = findViewById<ImageButton>(R.id.backEstabelecimentos)
        arrowBack.setOnClickListener {
            finish()
        }
    }
}