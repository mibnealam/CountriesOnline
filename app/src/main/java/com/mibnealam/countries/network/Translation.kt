package com.mibnealam.countries.network

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Translation (
    val de : String?,
    val es : String?,
    val fr : String?,
    val ja : String?,
    val it : String?,
    val br : String?,
    val pt : String?,
    val nl : String?,
    val hr : String?,
    val fa : String?
) : Parcelable