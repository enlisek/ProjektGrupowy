package com.example.projektgrupowy.model

import com.google.gson.annotations.SerializedName

data class Player(
        var id: Long,
        val playerName: String,
        var numberOfRabbit: Int,
        var numberOfPig: Int,
        var numberOfSheep: Int,
        var numberOfCow: Int,
        var numberOfHorse: Int,
        var numberOfDog: Int,
        var numberOfBigDog: Int


)

//){
//    var numberOfRabbit
//        get() = playerWithoutId.numberOfRabbit
//        set(value) {
//            playerWithoutId.numberOfRabbit=value
//        }
//    var numberOfPig
//        get() = playerWithoutId.numberOfPig
//        set(value) {
//            playerWithoutId.numberOfPig=value
//        }
//    var numberOfSheep
//        get() = playerWithoutId.numberOfSheep
//        set(value) {
//            playerWithoutId.numberOfSheep=value
//        }
//    var numberOfCow
//        get() = playerWithoutId.numberOfCow
//        set(value) {
//            playerWithoutId.numberOfCow=value
//        }
//    var numberOfHorse
//        get() = playerWithoutId.numberOfHorse
//        set(value) {
//            playerWithoutId.numberOfHorse=value
//        }
//    var numberOfDog
//        get() = playerWithoutId.numberOfDog
//        set(value) {
//            playerWithoutId.numberOfDog=value
//        }
//    var numberOfBigDog
//        get() = playerWithoutId.numberOfBigDog
//        set(value) {
//            playerWithoutId.numberOfBigDog=value
//        }
//}

//{"id":1,"playerName":"RomanJestSuper","numberOfRabbit": 3,"numberOfPig": 3,"numberOfSheep": 3,"numberOfCow": 3,"numberOfHorse": 3,"numberOfDog": 3,"numberOfBigDog": 3}