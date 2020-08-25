package com.mibnealam.countries.detail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mibnealam.countries.network.Country

class DetailViewModelFactory(private val country: Country, private val application: Application) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(country, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}