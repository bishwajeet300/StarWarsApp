package com.bishwajeet.starwarsapp.view.fragmentStarship


import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bishwajeet.starwarsapp.R
import com.bishwajeet.starwarsapp.StarWarsApp
import kotlinx.android.synthetic.main.fragment_starship_detail.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class StarshipDetailFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<StarshipDetailViewModel> {
        viewModelFactory
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)

        (requireActivity().application as StarWarsApp).applicationComponent.StarshipDetailComponent.starshipDetailComponent.create()
            .inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


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