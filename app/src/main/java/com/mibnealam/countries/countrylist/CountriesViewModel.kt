package com.mibnealam.countries.countrylist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mibnealam.countries.network.Country
import com.mibnealam.countries.network.CountryApi
import kotlinx.coroutines.launch

enum class CountryApiStatus { LOADING, ERROR, DONE }


class CountriesViewModel : ViewModel() {

    private val _status = MutableLiveData<CountryApiStatus>()
    val status: LiveData<CountryApiStatus>
        get() = _status

    private val _countries = MutableLiveData<List<Country>>()
    val countries: LiveData<List<Country>>
        get() = _countries

    private val _navigateToSelectedCountry = MutableLiveData<Country>()
    val navigateToSelectedCountry: LiveData<Country>
        get() = _navigateToSelectedCountry

    init {
        getCountries()
    }

    private fun getCountries() {
        _status.value = CountryApiStatus.LOADING
        viewModelScope.launch {
            try {
                _countries.value = CountryApi.retrofitService.getCountries()
                _status.value = CountryApiStatus.DONE
            } catch (e: Exception) {
                _status.value = CountryApiStatus.ERROR
                _countries.value = ArrayList()

            }
        }
    }

    fun displayCountryDetails(country: Country) {
        _navigateToSelectedCountry.value = country
    }

    fun displayCountryDetailsComplete() {
        _navigateToSelectedCountry.value = null
    }
}