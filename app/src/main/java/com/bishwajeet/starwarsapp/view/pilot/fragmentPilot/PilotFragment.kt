package com.bishwajeet.starwarsapp.view.pilot.fragmentPilot


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
import com.bishwajeet.starwarsapp.model.entity.Pilot
import com.bishwajeet.starwarsapp.util.IAdapterItemListener
import kotlinx.android.synthetic.main.fragment_pilot.view.*
import kotlinx.android.synthetic.main.fragment_pilot.view.tvTheme
import kotlinx.android.synthetic.main.fragment_starship.view.*
import javax.inject.Inject

class PilotFragment : Fragment(), IAdapterItemListener<Pilot> {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<PilotViewModel> {
        viewModelFactory
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)

        (requireActivity().application as StarWarsApp).applicationComponent.pilotComponent()
            .create()
            .inject(this)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = inflater.inflate(R.layout.fragment_pilot, container, false)
        val adapter = PilotAdapter(this)

        viewModel.response.observe(viewLifecycleOwner, Observer {
            it.let {
                adapter.data = it
            }
        })

        binding.tvTheme.text = viewModel.getCurrentTheme()
        binding.rvPilots.addOnScrollListener(object : RecyclerView.OnScrollListener() {
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
        binding.rvPilots.adapter = adapter


        return binding
    }


    override fun onClick(t: Pilot) {
        val navPilotFragmentDirections =
            PilotFragmentDirections.toPilotDetails(t.url)
        findNavController().navigate(navPilotFragmentDirections)
    }
}
