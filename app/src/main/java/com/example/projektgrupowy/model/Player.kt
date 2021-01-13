package com.example.projektgrupowy.model

import com.google.gson.annotations.SerializedName

data class Player(
    val id: Long,
    val playerName: String,
    val numberOfRabbit: Int,
    val numberOfPig: Int,
    val numberOfSheep: Int,
    val numberOfCow: Int,
    val numberOfHorse: Int,
    val numberOfDog: Int,
    val numberOfBigDog: Int
)

//{"id":1,"playerName":"RomanJestSuper","numberOfRabbit": 3,"numberOfPig": 3,"numberOfSheep": 3,"numberOfCow": 3,"numberOfHorse": 3,"numberOfDog": 3,"numberOfBigDog": 3}