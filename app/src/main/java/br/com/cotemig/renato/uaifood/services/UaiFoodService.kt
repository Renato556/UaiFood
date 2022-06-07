package br.com.cotemig.renato.uaifood.services

import br.com.cotemig.renato.uaifood.models.Estabelecimento
import br.com.cotemig.renato.uaifood.models.Produto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface UaiFoodService {
    @GET("lista_restaurantes/lista_restaurantes.txt")
    fun getRestaurantes(): Call<List<Estabelecimento>>

    @GET("restaurantes/{id}.txt")
    fun getPratos(@Path("id") id: String): Call<List<Produto>>
}