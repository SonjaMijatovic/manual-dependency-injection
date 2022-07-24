package com.example.manualdependencyinjection.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.manualdependencyinjection.repository.NumberRepository
import com.example.manualdependencyinjection.viewmodel.MainViewModel

class MainContainer(private val numberRepository: NumberRepository) {

    fun getMainViewModelFactory(): ViewModelProvider.Factory {
        return object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return MainViewModel(numberRepository) as T
            }
        }
    }
}