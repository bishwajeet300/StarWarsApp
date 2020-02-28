package com.bishwajeet.starwarsapp.view.fragmentStarship


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bishwajeet.starwarsapp.R
import kotlinx.android.synthetic.main.fragment_starship.*

/**
 * A simple [Fragment] subclass.
 */
class StarshipFragment : Fragment() {

    private lateinit var viewModel: StarshipViewModel
    private lateinit var viewModelFactory: StarshipViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.i("StarshipFragment", "Called ViewModelProviders.of")

        viewModelFactory = StarshipViewModelFactory()

        viewModel = ViewModelProvider(this, viewModelFactory).get(StarshipViewModel::class.java)

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_starship, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnToStarshipDetail.setOnClickListener {
            val num = StarshipFragmentDirections.toStarshipDetails("Yellow")
            findNavController().navigate(num)
        }
    }
}
