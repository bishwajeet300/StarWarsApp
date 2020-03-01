package com.bishwajeet.starwarsapp.model.source.remote

import androidx.lifecycle.LiveData
import com.bishwajeet.starwarsapp.model.entity.Pilot
import com.bishwajeet.starwarsapp.model.entity.Starship
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface INetworkInterface {


    @GET("/starships")
    @Headers("User-Agent: star-wars-app")
    fun getStarshipList(@Query(value = "page") page: Int): LiveData<MutableList<Starship>>


    @GET("/starships/{id}/")
    @Headers("User-Agent: star-wars-app")
    fun getStarship(@Path("id") starship_id: Int): LiveData<Starship>


    @GET("/people")
    @Headers("User-Agent: star-wars-app")
    fun getPilotList(@Query(value = "page") page: Int): LiveData<MutableList<Pilot>>


    @GET("/people/{id}/")
    @Headers("User-Agent: star-wars-app")
    fun getPilot(@Path("id") pilot_id: Int): LiveData<Pilot>


    companion object Factory {

        private const val BASE_URL = "http://swapi.co/api"

        fun create(): INetworkInterface {

            val moshi = Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()

            val retrofit = retrofit2.Retrofit.Builder()
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .baseUrl(BASE_URL)
                .build()

            return retrofit.create(INetworkInterface::class.java)
        }
    }
}