package com.bishwajeet.starwarsapp.view.pilot.fragmentPilotDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bishwajeet.starwarsapp.model.entity.Pilot
import com.bishwajeet.starwarsapp.model.source.remote.APIService
import com.bishwajeet.starwarsapp.util.Utils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import javax.inject.Inject

class PilotDetailsViewModel @Inject constructor(
    private val apiService: APIService
) : ViewModel() {

    private val viewModelJob = SupervisorJob()
    private val viewModelScope = CoroutineScope(viewModelJob + Dispatchers.Main)
    private val _response = MutableLiveData<Pilot>()
    private var _eventNetworkError = MutableLiveData<Boolean>(false)

    val eventNetworkError: LiveData<Boolean>
        get() = _eventNetworkError


    val response: LiveData<Pilot>
        get() = _response


    fun getPilotDetail(pilot_id: String) {
        viewModelScope.launch {
            val pilotDeferred = apiService.getPilot(Utils().getIdFromString(pilot_id))
            try {
                val pilot = pilotDeferred.await()
                _response.value = pilot
                _eventNetworkError.value = false

            } catch (exception: Exception) {
                _eventNetworkError.value = true
            }
        }
    }


    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}