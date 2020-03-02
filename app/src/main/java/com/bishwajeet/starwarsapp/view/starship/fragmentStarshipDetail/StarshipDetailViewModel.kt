package com.bishwajeet.starwarsapp.view.starship.fragmentStarshipDetail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bishwajeet.starwarsapp.model.entity.Starship
import com.bishwajeet.starwarsapp.model.source.remote.APIService
import com.bishwajeet.starwarsapp.util.Utils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import javax.inject.Inject

class StarshipDetailViewModel @Inject constructor(
    private val apiService: APIService
) : ViewModel() {

    private val viewModelJob = SupervisorJob()
    private val viewModelScope = CoroutineScope(viewModelJob + Dispatchers.Main)
    private val _response = MutableLiveData<Starship>()
    private var _eventNetworkError = MutableLiveData<Boolean>(false)

    val eventNetworkError: LiveData<Boolean>
        get() = _eventNetworkError


    val response: LiveData<Starship>
        get() = _response


    fun getStarshipDetails(starship_id: String) {
        viewModelScope.launch {
            val starshipListDeferred = apiService.getStarship(Utils().getIdFromString(starship_id))
            try {
                val starshipList = starshipListDeferred.await()
                _response.value = starshipList
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