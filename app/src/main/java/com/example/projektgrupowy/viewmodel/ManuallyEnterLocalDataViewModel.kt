package com.example.projektgrupowy.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.projektgrupowy.model.APIconnection.PlayerRemoteService
import com.example.projektgrupowy.model.LocalDatabase
import com.example.projektgrupowy.model.Player
import com.example.projektgrupowy.model.repo.PlayerLocalRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ManuallyEnterLocalDataViewModel(application: Application) : AndroidViewModel(application) {
    private val playerLocalRepository: PlayerLocalRepository =
            PlayerLocalRepository(LocalDatabase.getDatabase(application).playerDao())


    fun saveLocalPlayer
         (numberOfRabbit: Int,
         numberOfPig: Int,
         numberOfSheep: Int,
         numberOfCow: Int,
         numberOfHorse: Int,
         numberOfDog: Int,
         numberOfBigDog: Int)
    {
        viewModelScope.launch { playerLocalRepository.addPlayerLocal(numberOfRabbit,numberOfPig,
                numberOfSheep,
                numberOfCow,
                numberOfHorse,
                numberOfDog,
                numberOfBigDog)
        }
    }

}