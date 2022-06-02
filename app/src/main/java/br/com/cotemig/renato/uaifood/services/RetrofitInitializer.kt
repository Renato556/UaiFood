package br.com.cotemig.renato.uaifood.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitInitializer {

    private val URL = "https://api.falaai.app/v1/"
    private val API_UAIFOOD = "https://raw.githubusercontent.com/Renato556/api_uaifood/main/"


    private val retrofit =
        Retrofit.Builder().baseUrl(URL)
            .addConverterFactory(
                GsonConverterFactory
                .create()).build()

    private val retrofitUaiFood =
        Retrofit.Builder().baseUrl(API_UAIFOOD)
            .addConverterFactory(
                GsonConverterFactory
                .create()).build()


    fun serviceAccount(): ServiceAccount {
        return retrofit.create(ServiceAccount::class.java)
    }

    fun serviceEstabelecimentos(): ServiceUaiFood{
        return retrofitUaiFood.create(ServiceUaiFood::class.java)
    }

}

