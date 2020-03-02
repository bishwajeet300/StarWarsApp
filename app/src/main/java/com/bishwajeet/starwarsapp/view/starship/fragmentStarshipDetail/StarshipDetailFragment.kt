package com.bishwajeet.starwarsapp.view.starship.fragmentStarshipDetail

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bishwajeet.starwarsapp.R
import com.bishwajeet.starwarsapp.StarWarsApp
import com.bishwajeet.starwarsapp.util.IAdapterItemListener
import kotlinx.android.synthetic.main.fragment_starship_detail.view.*
import kotlinx.android.synthetic.main.fragment_starship_detail.view.empty_layout
import kotlinx.android.synthetic.main.fragment_starship_detail.view.included_empty_layout
import kotlinx.android.synthetic.main.fragment_starship_detail.view.tvName
import javax.inject.Inject

class StarshipDetailFragment : Fragment(), IAdapterItemListener<String> {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<StarshipDetailViewModel> {
        viewModelFactory
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)

        (requireActivity().application as StarWarsApp).applicationComponent.starshipDetailComponent()
            .create()
            .inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = inflater.inflate(R.layout.fragment_starship_detail, container, false)
        val adapter = StarshipPilotAdapter(this)

        viewModel.response.observe(viewLifecycleOwner, Observer {
            it.let {

                if(it.pilots.isNullOrEmpty()) {
                    binding.rvPilots.visibility = View.GONE
                    binding.empty_layout.visibility = View.VISIBLE
                    binding.included_empty_layout.tvName.text = getString(R.string.no_pilots)
                } else {
                    binding.rvPilots.visibility = View.VISIBLE
                    binding.empty_layout.visibility = View.GONE
                    adapter.data = it.pilots as MutableList<String>
                }

                binding.tvName.text = it.name
            }
        })

        binding.rvPilots.adapter = adapter


        return binding
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.getString("STARSHIP_ID")?.let { viewModel.getStarshipDetails(it) }
    }


    override fun onClick(t: String) {
        val navStarshipDetailFragmentDirections =
            StarshipDetailFragmentDirections.starshipDetailToPilot(t)
        findNavController().navigate(navStarshipDetailFragmentDirections)
    }
}