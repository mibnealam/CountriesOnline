package com.mibnealam.countries

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.load
import coil.transform.CircleCropTransformation
import com.mibnealam.countries.countrylist.CountryAdapter
import com.mibnealam.countries.countrylist.CountryApiStatus
import com.mibnealam.countries.network.Country
import java.util.*


@BindingAdapter("listData")
    fun bindRecyclerView(recyclerView: RecyclerView, data: List<Country>?) {
        val adapter = recyclerView.adapter as CountryAdapter
        adapter.submitList(data)
    }

@BindingAdapter(value = ["imageUrl", "isRound"], requireAll = false)
fun bindImage(imgView: ImageView, imgUrl: String?, isRound: Boolean = false) {
    val imageLoader = ImageLoader.Builder(imgView.context)
        .componentRegistry {
            add(SvgDecoder(imgView.context))
        }
        .build()
    imgView.load(imgUrl, imageLoader) {
        error(R.drawable.ic_broken_image)
        placeholder(R.drawable.loading_animation)
        if (isRound) transformations(CircleCropTransformation())
    }
}

@BindingAdapter("population")
fun bindPopulation(textView: TextView, population: Long?) {
    textView.text = String.format(Locale.getDefault(), "%,d", population)
}

@BindingAdapter("countryApiStatus")
fun bindStatus(statusImageView: ImageView, status: CountryApiStatus?) {
    when (status) {
        CountryApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        CountryApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        CountryApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
    }
}
