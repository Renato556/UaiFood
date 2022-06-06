package br.com.cotemig.renato.uaifood.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import br.com.cotemig.renato.uaifood.R
import br.com.cotemig.renato.uaifood.models.Estabelecimento
import coil.load
import coil.transform.RoundedCornersTransformation

class EstabelecimentoAdapter(var context : Context, var list: List<Estabelecimento>) : BaseAdapter() {

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
        var view = LayoutInflater.from(context).inflate(R.layout.item_list_estabelecimento, null)

        var imagem = view.findViewById<ImageView>(R.id.imagem_estabelecimento)
        imagem.load(list[p0].imagem){transformations(RoundedCornersTransformation((100).toFloat()))}

        var nome = view.findViewById<TextView>(R.id.nome_estabelecimento)
        nome.text = list[p0].nome

        var descricao = view.findViewById<TextView>(R.id.descricao_estabelecimento)
        descricao.text = list[p0].descricao

        return view
    }
}