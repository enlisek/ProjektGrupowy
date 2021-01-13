package com.example.projektgrupowy.model.APIconnection



import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL="https://192.168.0.104:5001/api/Players/"
object PlayerRemoteService
{
    private val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }


    val api: ApiRequest by lazy{
        retrofit
            .create(ApiRequest::class.java)
    }
}