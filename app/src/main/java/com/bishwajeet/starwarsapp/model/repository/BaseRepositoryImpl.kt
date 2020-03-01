package com.bishwajeet.starwarsapp.model.repository

import androidx.lifecycle.LiveData
import com.bishwajeet.starwarsapp.model.entity.Starship
import com.bishwajeet.starwarsapp.model.entity.StarshipWithPilots
import com.bishwajeet.starwarsapp.model.source.dataSource.StarshipDataSource
import com.bishwajeet.starwarsapp.model.source.local.StarshipLocalDataSource
import com.bishwajeet.starwarsapp.model.source.remote.INetworkInterface
import javax.inject.Inject

class BaseRepositoryImpl @Inject constructor(
    @StarshipLocalDataSource private val starshipLocalDataSource: StarshipDataSource,
    @ private val starshipRemoteDataSource: StarshipDataSource
): StarshipRepository {

    override suspend fun getStarshipList(): LiveData<MutableList<Starship>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getStarshipsWithPilot(): LiveData<MutableList<StarshipWithPilots>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getStarship(starship_id: String): LiveData<StarshipWithPilots> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}