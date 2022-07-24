package com.example.manualdependencyinjection.di

import com.example.manualdependencyinjection.repository.NumberRepositoryImpl
import java.util.*

class ApplicationContainer {

    val numberRepository = NumberRepositoryImpl(Random())
}