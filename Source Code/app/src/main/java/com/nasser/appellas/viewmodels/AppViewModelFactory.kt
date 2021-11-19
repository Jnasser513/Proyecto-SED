package com.nasser.appellas.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nasser.appellas.repository.AppRepository

class AppViewModelFactory(private val repository: AppRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(AppViewModel::class.java)){
            return AppViewModel(repository) as T
        }
        throw Exception("unknown view model class")
    }
}