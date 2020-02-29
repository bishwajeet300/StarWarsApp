package com.bishwajeet.starwarsapp.view.fragmentPilot


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bishwajeet.starwarsapp.R
import kotlinx.android.synthetic.main.fragment_pilot.*

/**
 * A simple [Fragment] subclass.
 */
class PilotFragment : Fragment() {

    private lateinit var viewModel: PilotViewModel
    private lateinit var viewModelFactory: PilotViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModelFactory = PilotViewModelFactory()

        viewModel = ViewModelProvider(this, viewModelFactory).get(PilotViewModel::class)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pilot, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnToPilotDetail.setOnClickListener {
            val navPilotFragmentDirections = PilotFragmentDirections.toPilotDetails("Green")
            findNavController().navigate(navPilotFragmentDirections)
        }
    }
}
