package com.bishwajeet.starwarsapp.model.repository

import com.bishwajeet.starwarsapp.model.local.dao.StarshipDAO
import com.bishwajeet.starwarsapp.model.remote.INetworkInterface
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StarshipRepository @Inject constructor(
                        private val starshipDAO: StarshipDAO,
                        private val iNetworkInterface: INetworkInterface) {

    val starships = iNetworkInterface.getAllStarships(1)
}