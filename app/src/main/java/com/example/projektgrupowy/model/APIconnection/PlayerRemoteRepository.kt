package com.example.projektgrupowy.model.APIconnection

import com.example.projektgrupowy.model.Player
import retrofit2.Call
import retrofit2.Response
import retrofit2.awaitResponse

class PlayerRemoteRepository(val apiRequest: ApiRequest) {

    suspend fun  getAll():List<Player>{
        val data = apiRequest.getAllPlayers().awaitResponse()
        if (data.isSuccessful)
            return data.body()!!
        return listOf()
    }

    suspend fun addPlayer(player: Player): Call<Player> {
        return apiRequest.addPlayer(player)
    }

}

