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
import com.bishwajeet.starwarsapp.di.StarWarsViewModelFactory
import kotlinx.android.synthetic.main.fragment_starship.*
import javax.inject.Inject

class StarshipFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<StarshipViewModel> {
        viewModelFactory
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)

        (requireActivity().application as StarWarsApp).applicationComponent.StarshipComponent.starshipComponent.create()
            .inject(this)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.i("StarshipFragment", "Called ViewModelProviders.of")

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
