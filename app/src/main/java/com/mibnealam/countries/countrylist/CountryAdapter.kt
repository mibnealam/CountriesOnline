package com.mibnealam.countries.countrylist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mibnealam.countries.databinding.ItemCountryBinding
import com.mibnealam.countries.network.Country

class CountryAdapter( private val onClickListener: OnClickListener) : ListAdapter<Country, CountryAdapter.CountryViewHolder>(DiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {

        return CountryViewHolder(ItemCountryBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(country)
        }
        holder.bind(country)
    }
    companion object DiffCallback : DiffUtil.ItemCallback<Country>() {
        override fun areItemsTheSame(oldItem: Country, newItem: Country): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Country, newItem: Country): Boolean {
            return oldItem.numericCode == newItem.numericCode
        }
    }

    class CountryViewHolder(private var binding: ItemCountryBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(country: Country) {
            binding.country = country
            binding.executePendingBindings()
        }
    }

    class OnClickListener(val clickListener: (country: Country) -> Unit) {
        fun onClick(country: Country) = clickListener(country)
    }

}
