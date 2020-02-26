package com.bishwajeet.starwarsapp.model.remote

import com.bishwajeet.starwarsapp.model.local.entity.Pilot
import com.bishwajeet.starwarsapp.model.local.entity.Starship
import retrofit2.Call
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface INetworkInterface {

    @GET("/people")
    @Headers("User-Agent: star-wars-app")
    fun getAllPilots(@Query(value = "page") page: Int): Call<MutableList<Pilot>>


    @GET("/starships")
    @Headers("User-Agent: star-wars-app")
    fun getAllStarships(@Query(value = "page") page: Int): Call<MutableList<Starship>>


    @GET("/people/{id}/")
    @Headers("User-Agent: star-wars-app")
    fun getPilot(@Path("id") id: Int): Call<String>


    @GET("/starships/{id}/")
    @Headers("User-Agent: star-wars-app")
    fun getStarship(@Path("io") page: Int): Call<Starship>


    companion object Factory {

        private const val BASE_URL = "http://swapi.co/api"

        fun create(): INetworkInterface {
            val retrofit = retrofit2.Retrofit.Builder()
                .addConverterFactory(MoshiConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()

            return retrofit.create(INetworkInterface::class.java)
        }
    }
}