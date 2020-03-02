package com.bishwajeet.starwarsapp.view.pilot.fragmentPilot

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bishwajeet.starwarsapp.model.entity.Pilot
import com.bishwajeet.starwarsapp.model.source.preferences.IPreferencesContract
import com.bishwajeet.starwarsapp.model.source.remote.APIService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import javax.inject.Inject

class PilotViewModel @Inject constructor(
    private val apiService: APIService,
    private val preferences: IPreferencesContract
) : ViewModel() {


    private val viewModelJob = SupervisorJob()
    private val viewModelScope = CoroutineScope(viewModelJob + Dispatchers.Main)
    private val _response = MutableLiveData<List<Pilot>>()
    private var page = 1
    private var list = mutableListOf<Pilot>()
    private var _eventNetworkError = MutableLiveData<Boolean>(false)

    val eventNetworkError: LiveData<Boolean>
        get() = _eventNetworkError

    val response: MutableLiveData<List<Pilot>>
        get() = _response


    init {
        getPilots(page)
    }


    private fun getPilots(page: Int) {
        viewModelScope.launch {
            val pilotListDeferred = apiService.getPilotList(page)
            try {
                val pilotResponse = pilotListDeferred.await()
                list.addAll(pilotResponse.results)
                _response.value = list
                _eventNetworkError.value = false

            } catch (exception: Exception) {
                _eventNetworkError.value = true
            }
        }
    }


    fun nextPage() {
        page = page.plus(1)
        getPilots(page)
    }


    fun getCurrentTheme(): String? {
        return preferences.getTheme()
    }


    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}