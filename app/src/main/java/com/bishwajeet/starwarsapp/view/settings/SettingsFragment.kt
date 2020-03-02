package com.bishwajeet.starwarsapp.view.settings


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bishwajeet.starwarsapp.R
import com.bishwajeet.starwarsapp.StarWarsApp
import kotlinx.android.synthetic.main.fragment_settings.view.*
import javax.inject.Inject


/**
 * A simple [Fragment] subclass.
 */
class SettingsFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<SettingsViewModel> {
        viewModelFactory
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)

        (requireActivity().application as StarWarsApp).applicationComponent.settingsComponent()
            .create()
            .inject(this)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = inflater.inflate(
            R.layout.fragment_settings,
            container,
            false
        )

        binding.tvCurrentTheme.text = viewModel.getCurrentTheme()

        binding.llThemes.setOnClickListener {
            openDialog()
        }

        return binding
    }


    private fun setTheme(mode: Int) {
        AppCompatDelegate.setDefaultNightMode(mode)
    }


    private fun openDialog() {

        val names = arrayOf(
            getString(R.string.light_theme_name),
            getString(R.string.dark_theme_name),
            getString(R.string.follow_system_name)
        )

        val alertDialog = AlertDialog.Builder(requireContext())
        val rowList = layoutInflater.inflate(R.layout.dialog_theme_picker, null)

        val listView: ListView = rowList.findViewById(R.id.listView)
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, names)
        listView.adapter = adapter
        adapter.notifyDataSetChanged()
        alertDialog.setView(rowList)
        val dialog = alertDialog.create()
        listView.setOnItemClickListener { _, _, position, _ ->
            val element = adapter.getItem(position)
            if (element != null) {
                viewModel.saveTheme(element)
            }
            when (element) {
                getString(R.string.light_theme_name) -> setTheme(AppCompatDelegate.MODE_NIGHT_NO)
                getString(R.string.dark_theme_name) -> setTheme(AppCompatDelegate.MODE_NIGHT_YES)
                getString(R.string.follow_system_name) -> setTheme(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
            }
            dialog.dismiss()

            findNavController().navigateUp()
        }


        dialog.show()
    }
}
