package com.bishwajeet.starwarsapp.view.fragmentStarship


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bishwajeet.starwarsapp.R
import kotlinx.android.synthetic.main.fragment_starship_detail.*

/**
 * A simple [Fragment] subclass.
 */
class StarshipDetailFragment : Fragment() {


    private lateinit var viewModel: StarshipDetailViewModel
    private lateinit var viewModelFactory: StarshipDetailViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        viewModelFactory = StarshipDetailViewModelFactory(arguments?.getString("STARSHIP_ID", "")!!)

        viewModel = ViewModelProvider(this, viewModelFactory).get(StarshipDetailViewModel::class.java)

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_starship_detail, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.getString("STARSHIP_ID")

        btnToPilotDetail.text = arguments?.getString("STARSHIP_ID")

        btnToPilotDetail.setOnClickListener {
            val navStarshipDetailFragmentDirections =
                StarshipDetailFragmentDirections.starshipDetailToPilot(btnToPilotDetail.text.toString())
            findNavController().navigate(navStarshipDetailFragmentDirections)
        }
    }
}