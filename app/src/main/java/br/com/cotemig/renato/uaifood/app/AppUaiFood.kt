package br.com.cotemig.renato.uaifood.app

import android.app.Application
import br.com.cotemig.renato.uaifood.models.Produto

class AppUaiFood : Application() {

    companion object {

        var list = ArrayList<Produto>()

    }

}