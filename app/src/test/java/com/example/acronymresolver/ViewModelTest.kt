@file:OptIn(ExperimentalCoroutinesApi::class)

package com.example.acronymresolver

import com.example.acronymresolver.di.NetworkModule
import com.example.acronymresolver.repository.Repository
import com.example.acronymresolver.viewmodel.AcronymViewModel
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.Before
import org.junit.Test


class ViewModelTest{

    private lateinit var repository: Repository
    private lateinit var viewModel: AcronymViewModel


    @Before
    fun setUp() {
        repository = Repository(NetworkModule.provideNetworkCall(NetworkModule.provideRetrofit()))
        viewModel = AcronymViewModel(repository)
    }


    @Test
    fun testViewModel() = runTest {
        val testDispatcher = UnconfinedTestDispatcher(testScheduler)
        Dispatchers.setMain(testDispatcher)

        try {
            viewModel.searchAcronym("ab")
            advanceUntilIdle()
            print(viewModel.lDisplayList.value)
            viewModel.lDisplayList.value?.let {
                assertEquals(it[0].acronyms, "AB")
            }
        } finally {
            Dispatchers.resetMain()
        }

    }
}