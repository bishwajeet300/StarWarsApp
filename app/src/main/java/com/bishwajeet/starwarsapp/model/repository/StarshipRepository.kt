package com.bishwajeet.starwarsapp.model.repository

import com.bishwajeet.starwarsapp.model.local.dao.StarshipDAO
import com.bishwajeet.starwarsapp.model.remote.INetworkInterface

class StarshipRepository(private val starshipDAO: StarshipDAO,
                        private val iNetworkInterface: INetworkInterface) {

    val starships = iNetworkInterface.getAllStarships(1)
}