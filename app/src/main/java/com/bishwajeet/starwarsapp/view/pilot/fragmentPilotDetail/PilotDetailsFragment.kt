package com.bishwajeet.starwarsapp.view.pilot.fragmentPilotDetail


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
import kotlinx.android.synthetic.main.fragment_pilot_details.view.*
import javax.inject.Inject

class PilotDetailsFragment : Fragment(), IAdapterItemListener<String> {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<PilotDetailsViewModel> {
        viewModelFactory
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)

        (requireActivity().application as StarWarsApp).applicationComponent.pilotDetailComponent()
            .create()
            .inject(this)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = inflater.inflate(R.layout.fragment_pilot_details, container, false)
        val adapter = PilotStarshipAdapter(this)

        viewModel.response.observe(viewLifecycleOwner, Observer {
            it.let {

                if(it.starships.isNullOrEmpty()) {
                    binding.rvStarships.visibility = View.GONE
                    binding.empty_layout.visibility = View.VISIBLE
                    binding.included_empty_layout.tvName.text = getString(R.string.no_starships)
                } else {
                    binding.rvStarships.visibility = View.VISIBLE
                    binding.empty_layout.visibility = View.GONE
                    adapter.data = it.starships as MutableList<String>
                }

                binding.tvName.text = it.name
            }
        })

        binding.rvStarships.adapter = adapter

        return binding
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.getString("PILOT_ID")?.let { viewModel.getPilotDetail(it) }
    }


    override fun onClick(t: String) {
        val navDirections =
            PilotDetailsFragmentDirections.pilotDetailToStarship(t)
        findNavController().navigate(navDirections)
    }
}
