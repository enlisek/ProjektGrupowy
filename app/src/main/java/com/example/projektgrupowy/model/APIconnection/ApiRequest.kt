package com.example.projektgrupowy.model.APIconnection

import com.example.projektgrupowy.model.Player
import com.example.projektgrupowy.model.PlayerWithoutId
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface ApiRequest {

    @GET("Players")
    fun getAllPlayers(): Call<List<Player>>

    @POST("Players")
    fun addPlayer(@Body player: PlayerWithoutId):Call<Player>

    @PUT("Players/{id}")
    fun updatePlayer(@Path("id") id:Long, @Body player: Player):Call<Player>
}