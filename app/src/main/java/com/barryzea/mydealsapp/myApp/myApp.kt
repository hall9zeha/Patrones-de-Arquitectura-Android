package com.barryzea.mydealsapp.myApp

import android.app.Application
import android.content.Context


class myApp: Application() {
    companion object{
         lateinit var context:Context
    }

    override fun onCreate() {
        super.onCreate()
            context=applicationContext
    }
}