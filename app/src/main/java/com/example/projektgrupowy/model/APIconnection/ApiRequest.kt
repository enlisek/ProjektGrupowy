package com.example.projektgrupowy.model.APIconnection

import com.example.projektgrupowy.model.Player
import com.example.projektgrupowy.model.PlayerWithoutId
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface ApiRequest {

    @GET("Players")
    fun getAllPlayers(): Call<List<Player>>

    @POST("Players")
    fun addPlayer(@Body player: PlayerWithoutId):Call<Player>


}