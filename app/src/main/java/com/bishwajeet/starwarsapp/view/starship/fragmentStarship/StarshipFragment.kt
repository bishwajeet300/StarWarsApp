package com.bishwajeet.starwarsapp.view.starship.fragmentStarship


import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bishwajeet.starwarsapp.R
import com.bishwajeet.starwarsapp.StarWarsApp
import com.bishwajeet.starwarsapp.model.entity.Starship
import com.bishwajeet.starwarsapp.util.IAdapterItemListener
import kotlinx.android.synthetic.main.fragment_starship.view.*
import javax.inject.Inject

class StarshipFragment : Fragment(), IAdapterItemListener<Starship> {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<StarshipViewModel> {
        viewModelFactory
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)

        (requireActivity().application as StarWarsApp).applicationComponent.starshipComponent()
            .create()
            .inject(this)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = inflater.inflate(R.layout.fragment_starship, container, false)
        val adapter = StarshipAdapter(this)

        viewModel.response.observe(viewLifecycleOwner, Observer {
            it.let {
                adapter.data = it
            }
        })

        binding.tvTheme.text = viewModel.getCurrentTheme()
        binding.rvStarships.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val linearLayoutManager = recyclerView.layoutManager as LinearLayoutManager

                Log.d(
                    "onScrolled",
                    linearLayoutManager.findLastCompletelyVisibleItemPosition().toString().plus(", ").plus(
                        adapter.itemCount
                    )
                )

                if (linearLayoutManager.findLastCompletelyVisibleItemPosition() >= (adapter.itemCount) - 6) {
                    viewModel.nextPage()
                }
            }
        })
        binding.rvStarships.adapter = adapter


        return binding
    }


    override fun onClick(t: Starship) {
        val navStarshipFragmentDirections =
            StarshipFragmentDirections.toStarshipDetails(t.url)
        findNavController().navigate(navStarshipFragmentDirections)
    }
}
