package com.example.projektgrupowy.model.APIconnection

import com.example.projektgrupowy.model.Player
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiRequest {

    @GET("Players")
    fun getAllPlayers(): Call<List<Player>>

    @POST("4")
    fun addPlayer(@Body player: Player):Call<Player>
}