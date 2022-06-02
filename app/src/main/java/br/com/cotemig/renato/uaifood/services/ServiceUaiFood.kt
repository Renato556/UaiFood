package br.com.cotemig.renato.uaifood.services

import br.com.cotemig.renato.uaifood.models.Estabelecimento
import retrofit2.Call
import retrofit2.http.GET

interface ServiceUaiFood {
    @GET("lista_restaurantes/lista_restaurantes.txt")
    fun getRestaurantes() : Call<List<Estabelecimento>>
}