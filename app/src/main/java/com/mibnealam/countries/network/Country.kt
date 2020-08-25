package com.mibnealam.countries.network

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Country(
    val name : String,
    val topLevelDomain : List<String>,
    val alpha2Code : String,
    val alpha3Code : String,
    val callingCodes : List<String>,
    val capital : String,
    val altSpellings : List<String>,
    val region : String,
    val subRegion : String?,
    val population : Long,
    val latlng : List<Double>,
    val demonym : String,
    val area : Double?,
    val gini : Double?,
    val timezones : List<String>,
    val borders : List<String?>,
    val nativeName : String,
    val numericCode : String?,
    val currencies : List<Currency>,
    val languages : List<Language>,
    val translations : Translation,
    val flag : String,
    val regionalBlocs : List<RegionalBloc>,
    val cioc : String?
) : Parcelable