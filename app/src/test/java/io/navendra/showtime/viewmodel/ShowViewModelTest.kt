package io.navendra.showtime.viewmodel

import com.nhaarman.mockitokotlin2.mock
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

@RunWith(JUnit4::class)
class ShowViewModelTest{

    lateinit var showViewModel: ShowViewModel

    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
        this.showViewModel = ShowViewModel()
    }


    @Test
    fun test_fetchAllShows(){
//
//        Mockito.`when`(showViewModel.fetchAllShows())
//
//        val observer = mock<>()
    }
}