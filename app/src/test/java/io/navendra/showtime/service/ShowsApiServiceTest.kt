package io.navendra.showtime.service

import io.navendra.showtime.data.model.ShowResponse
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.MockitoAnnotations
import kotlin.test.assertNotNull
import org.hamcrest.CoreMatchers.instanceOf


@RunWith(JUnit4::class)
class ShowsApiServiceTest{

    lateinit var showsApiService: ShowsApiService

    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
        this.showsApiService = ApiFactory.showsApiService
    }

    @Test
    fun `api fetch result is notNull`(){
        val resultPopular = runBlocking { showsApiService.getPopularShows().await() }
        val resultUpcoming = runBlocking { showsApiService.getUpcomingShows().await() }
        val resultNowPlaying = runBlocking { showsApiService.getNowPlayingShows().await() }
        val resultTopRated = runBlocking { showsApiService.getTopRatedShows().await() }

        assertNotNull(resultPopular,"Popular Api result is null")
        assertNotNull(resultUpcoming,"Upcoming Api results is null")
        assertNotNull(resultNowPlaying,"Now Playing Api results is null")
        assertNotNull(resultTopRated,"Top Rated Api results is null")

    }

    @Test
    fun `api fetch returns ShowResponse`(){

        val resultPopular = runBlocking { showsApiService.getPopularShows().await().body() }
        val resultUpcoming = runBlocking { showsApiService.getUpcomingShows().await().body() }
        val resultNowPlaying = runBlocking { showsApiService.getNowPlayingShows().await().body() }
        val resultTopRated = runBlocking { showsApiService.getTopRatedShows().await().body() }

        assertThat("Popular Api result is not of type ShowResponse",
                resultPopular, instanceOf(ShowResponse::class.java))
        assertThat("Upcoming Api result is not of type ShowResponse",
                resultUpcoming, instanceOf(ShowResponse::class.java))
        assertThat("Now Playing Api result is not of type ShowResponse",
                resultNowPlaying, instanceOf(ShowResponse::class.java))
        assertThat("Top Rated Api result is not of type ShowResponse",
                resultTopRated, instanceOf(ShowResponse::class.java))

    }

}