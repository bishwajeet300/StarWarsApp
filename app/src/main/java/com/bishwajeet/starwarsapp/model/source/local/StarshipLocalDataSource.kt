package com.bishwajeet.starwarsapp.model.source.local

import androidx.lifecycle.LiveData
import com.bishwajeet.starwarsapp.model.entity.Starship
import com.bishwajeet.starwarsapp.model.source.dataSource.StarshipDataSource
import com.bishwajeet.starwarsapp.model.source.local.dao.StarshipDAO

class StarshipLocalDataSource internal constructor(
    private val starshipDAO: StarshipDAO
) : StarshipDataSource {


    override suspend fun getStarshipList(page: Int): LiveData<MutableList<Starship>> {
        return starshipDAO.getStarshipList(page)
    }


    override suspend fun getStarship(starship_id: Int): LiveData<Starship> {
        return starshipDAO.getStarship(starship_id)
    }
}