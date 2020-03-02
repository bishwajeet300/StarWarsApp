package com.bishwajeet.starwarsapp.util

class Utils {

    fun getIdFromString(url: String): Int {
        val urlParts = url.reversed().split("/")
        return urlParts[1].reversed().toInt()
    }
}