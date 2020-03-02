package com.bishwajeet.starwarsapp.util

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class UtilsTest {


    @Test
    fun testGetIdFromString() {
        //Given
        val input = mutableListOf("https://swapi.co/api/starships/10/",
            "https://swapi.co/api/starships/9/",
            "https://swapi.co/api/pilot/134/",
            "https://swapi.co/api/pilot/5/")

        val output = mutableListOf(10, 9, 134, 5)

        for(testInput: String in input) {
            Assert.assertEquals(Utils().getIdFromString(testInput), output[input.indexOf(testInput)])
        }
    }
}