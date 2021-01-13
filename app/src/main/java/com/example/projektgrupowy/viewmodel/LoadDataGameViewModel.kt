package com.example.projektgrupowy.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.projektgrupowy.model.APIconnection.ApiRequest
import com.example.projektgrupowy.model.APIconnection.PlayerRemoteRepository
import com.example.projektgrupowy.model.APIconnection.PlayerRemoteService
import com.example.projektgrupowy.model.Player
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Response

class LoadDataGameViewModel(application: Application): AndroidViewModel(application)  {
    var myResponse:MutableLiveData<Response<Player>> = MutableLiveData()

    fun addPlayer(id: Long,
                  playerName: String,
                  numberOfRabbit: Int,
                  numberOfPig: Int,
                  numberOfSheep: Int,
                  numberOfCow: Int,
                  numberOfHorse: Int,
                  numberOfDog: Int,
                  numberOfBigDog: Int){
        GlobalScope.launch(Dispatchers.IO) {

           var call =  PlayerRemoteService.api.addPlayer(Player(
                id,
                playerName,
                numberOfRabbit,
                numberOfPig,
                numberOfSheep,
                numberOfCow,
                numberOfHorse,
                numberOfDog,
                numberOfBigDog))
            var response = call.execute()




        }

    }

}