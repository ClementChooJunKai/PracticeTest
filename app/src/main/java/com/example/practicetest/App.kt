package com.example.practicetest


import android.app.Application
import kotlinx.coroutines.GlobalScope

class App : Application(){

    val Dao by lazy {PracDatabase.getDatabase(this, GlobalScope).pracDao()}


    val repository by lazy { Repo(Dao)}
}