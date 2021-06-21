package com.rsschool.quiz

import android.app.Application
import android.content.res.Resources

class App: Application() {

    var resourcesApp: Resources? = null

    override fun onCreate() {
        super.onCreate()
        resourcesApp = applicationContext.resources
    }
}