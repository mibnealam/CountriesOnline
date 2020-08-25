package com.mibnealam.countries.countrylist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.mibnealam.countries.databinding.FragmentCountriesBinding

class CountriesFragment : Fragment() {

    private val viewModel: CountriesViewModel by lazy {
        ViewModelProvider(this).get(
            CountriesViewModel::class.java
        )
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentCountriesBinding.inflate(inflater)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        binding.countriesList.adapter = CountryAdapter(CountryAdapter.OnClickListener { viewModel.displayCountryDetails(it) })

        viewModel.navigateToSelectedCountry.observe(viewLifecycleOwner, Observer {
            if (null != it) {
                this.findNavController().navigate((CountriesFragmentDirections.actionShowDetail(it)))
                viewModel.displayCountryDetailsComplete()
            }
        })

        return binding.root
    }
}