package com.mibnealam.countries.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mibnealam.countries.network.Country

class DetailViewModel( country: Country, app: Application) : AndroidViewModel(app) {

    private val _selectedCountry = MutableLiveData<Country>()

    val selectedCountry: LiveData<Country>
        get() = _selectedCountry

    init {
        _selectedCountry.value = country
    }
}