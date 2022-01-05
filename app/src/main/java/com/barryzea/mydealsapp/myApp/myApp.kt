package com.barryzea.mydealsapp.myApp

import android.app.Application
import android.content.Context


class myApp: Application() {
    companion object{
         var context:Context?=null
    }

    override fun onCreate() {
        super.onCreate()
        context?.let{
            context=this
        }
    }
}