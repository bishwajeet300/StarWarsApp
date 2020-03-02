package com.bishwajeet.starwarsapp.model.source.remote

import androidx.lifecycle.LiveData
import com.bishwajeet.starwarsapp.model.entity.Pilot
import com.bishwajeet.starwarsapp.model.entity.PilotResponse
import com.bishwajeet.starwarsapp.model.entity.Starship
import com.bishwajeet.starwarsapp.model.entity.StarshipResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query


private const val BASE_URL = "https://swapi.co/api/"

/**
 * Build the Moshi object that Retrofit will be using, making sure to add the Kotlin adapter for
 * full Kotlin compatibility.
 */
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

/**
 * Use the Retrofit builder to build a retrofit object using a Moshi converter with our Moshi
 * object.
 */
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()


interface APIService {

    @GET("starships")
    @Headers("User-Agent: star-wars-app")
    fun getStarshipList(@Query(value = "page") page: Int): Deferred<StarshipResponse>


    @GET("starships/{id}/")
    @Headers("User-Agent: star-wars-app")
    fun getStarship(@Path("id") starship_id: Int): Deferred<Starship>


    @GET("people")
    @Headers("User-Agent: star-wars-app")
    fun getPilotList(@Query(value = "page") page: Int): Deferred<PilotResponse>


    @GET("people/{id}/")
    @Headers("User-Agent: star-wars-app")
    fun getPilot(@Path("id") pilot_id: Int): Deferred<Pilot>
}


/**
 * A public Api object that exposes the lazy-initialized Retrofit service
 */
object StarWarsAPI {
    val retrofitService: APIService by lazy { retrofit.create(APIService::class.java) }
}