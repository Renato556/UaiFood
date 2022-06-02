package br.com.cotemig.renato.uaifood.services

import br.com.cotemig.renato.uaifood.models.Account
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ServiceAccount {

    @POST("account/auth")
    fun auth(@Body account: Account): Call<Account>

    @POST("account")
    fun create(@Body account: Account): Call<Account>

    @POST("account/forgot")
    fun forgot(@Body account: Account): Call<Account>

}