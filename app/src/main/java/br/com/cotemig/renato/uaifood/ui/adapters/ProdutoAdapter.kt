package br.com.cotemig.renato.uaifood.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import br.com.cotemig.renato.uaifood.R
import br.com.cotemig.renato.uaifood.models.Produto
import coil.load

class ProdutoAdapter(var context: Context, var list: List<Produto>) : BaseAdapter() {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(p0: Int): Any {
        return ""
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var view = LayoutInflater.from(context).inflate(R.layout.item_list_produtos, null)

        var nomePrato = view.findViewById<TextView>(R.id.nome_produto)
        nomePrato.text = list[p0].nomePrato

        var descricaoPrato = view.findViewById<TextView>(R.id.descricao_produto)
        descricaoPrato.text = list[p0].descricaoPrato

        var precoPrato = view.findViewById<TextView>(R.id.valor_produto)
        precoPrato.text = list[p0].precoPrato

        return view
    }
}