package com.example.projektgrupowy.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class MainViewModel(application: Application): AndroidViewModel(application)  {
    var list : List<Int> = listOf(0,0,0,0,0,0,0)
}