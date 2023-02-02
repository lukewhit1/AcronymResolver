package com.example.acronymresolver

import com.example.acronymresolver.di.NetworkModule
import com.example.acronymresolver.repository.Repository
import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class NetworkCallTest {
    private lateinit var repository: Repository
    @Before
    fun setUp() {
        repository = Repository(NetworkModule.provideNetworkCall(NetworkModule.provideRetrofit()))
    }
    @Test
    fun getAcronym() {
        runBlocking {
            val response = repository.getAcronym("ab")
            print(response)
            assertEquals(response[0].sf, "AB")
        }
    }
    @Test
    fun getLongForm() {
        runBlocking {
            val response = repository.getLongForm("antibody")
            assertEquals(response[0].sf, "AB")
        }
    }

}