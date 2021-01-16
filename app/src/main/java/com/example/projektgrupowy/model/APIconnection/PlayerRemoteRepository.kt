package com.example.projektgrupowy.model.APIconnection

import androidx.lifecycle.LiveData
import com.example.projektgrupowy.model.Player
import com.example.projektgrupowy.model.PlayerWithoutId
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.awaitResponse

class PlayerRemoteRepository() {


    suspend fun getAll(): List<Player> {
        val data = PlayerRemoteService.api.getAllPlayers().awaitResponse()
        if (data.isSuccessful)
            return data.body()!!
        return listOf()
    }

    suspend fun addPlayer(player: PlayerWithoutId): Call<Player> {
        return PlayerRemoteService.api.addPlayer(player)
    }
    suspend fun updatePlayer(player:Player):Call<Player>{
        return PlayerRemoteService.api.updatePlayer(player.id,player)
    }

}

