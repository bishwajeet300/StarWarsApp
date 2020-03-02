package com.bishwajeet.starwarsapp.view.starship.fragmentStarship

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bishwajeet.starwarsapp.model.entity.Starship
import com.bishwajeet.starwarsapp.model.source.preferences.IPreferencesContract
import com.bishwajeet.starwarsapp.model.source.remote.APIService
import com.bishwajeet.starwarsapp.util.ThemeManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import javax.inject.Inject

class StarshipViewModel @Inject constructor(
    private val apiService: APIService,
    private val preferences: IPreferencesContract
) : ViewModel() {

    private val viewModelJob = SupervisorJob()
    private val viewModelScope = CoroutineScope(viewModelJob + Dispatchers.Main)
    private val _response = MutableLiveData<List<Starship>>()
    private var page = 1
    private var list = mutableListOf<Starship>()
    private var _eventNetworkError = MutableLiveData<Boolean>(false)

    val eventNetworkError: LiveData<Boolean>
        get() = _eventNetworkError

    val response: MutableLiveData<List<Starship>>
        get() = _response


    init {
        ThemeManager.applyTheme(preferences.getTheme())

        getStarships(page)
        nextPage()
    }


    private fun getStarships(page: Int) {
        viewModelScope.launch {
            Log.i("getStarships", page.toString())
            val starshipListDeferred = apiService.getStarshipList(page)
            try {
                val starshipResponse = starshipListDeferred.await()
                list.addAll(starshipResponse.results)
                _response.value = list
                _eventNetworkError.value = false

            } catch (exception: Exception) {
                _eventNetworkError.value = true
            }
        }
    }


    fun nextPage() {
        page = page.plus(1)
        getStarships(page)
    }


    fun getCurrentTheme(): String? {
        return preferences.getTheme()
    }


    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}