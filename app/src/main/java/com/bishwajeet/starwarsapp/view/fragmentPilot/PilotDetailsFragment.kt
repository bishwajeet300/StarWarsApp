package com.bishwajeet.starwarsapp.view.fragmentPilot


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bishwajeet.starwarsapp.R
import kotlinx.android.synthetic.main.fragment_pilot_details.*

/**
 * A simple [Fragment] subclass.
 */
class PilotDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pilot_details, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnToStarshipDetail.setOnClickListener {
            val navDirections = PilotDetailsFragmentDirections.pilotDetailToStarship("blue")
            findNavController().navigate(navDirections)
        }
    }
}
