package br.com.cotemig.renato.uaifood.services

import br.com.cotemig.renato.uaifood.models.Restaurant
import br.com.cotemig.renato.uaifood.models.Product
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface UaiFoodService {
    @GET("lista_restaurantes/lista_restaurantes.txt")
    fun getRestaurantes(): Call<List<Restaurant>>

    @GET("restaurantes/{id}.txt")
    fun getPratos(@Path("id") id: String): Call<List<Product>>
}