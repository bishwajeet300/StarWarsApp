package com.bishwajeet.starwarsapp.model.repository

import com.bishwajeet.starwarsapp.model.local.dao.PilotDAO
import com.bishwajeet.starwarsapp.model.remote.INetworkInterface
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class PilotRepository @Inject constructor(
    private val pilotDAO: PilotDAO,
    private val iNetworkInterface: INetworkInterface) {


}