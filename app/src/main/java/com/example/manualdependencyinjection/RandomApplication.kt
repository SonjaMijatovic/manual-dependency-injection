package com.example.manualdependencyinjection

import android.app.Application
import com.example.manualdependencyinjection.di.ApplicationContainer

class RandomApplication : Application() {

    val applicationContainer = ApplicationContainer()
}