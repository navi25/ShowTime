package io.navendra.showtime.data

import io.navendra.showtime.service.ApiFactory
import io.navendra.showtime.service.ShowRepository
import io.navendra.showtime.service.ShowsApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import kotlin.test.assertNotNull

@RunWith(JUnit4::class)
class ShowRepositoryTest{


    lateinit var showsApiService: ShowsApiService

    @Mock
    lateinit var scope: CoroutineScope

    lateinit var showRepository: ShowRepository

    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
        this.showsApiService = ApiFactory.showsApiService
        showRepository = ShowRepository(this.showsApiService,this.scope)
    }

    @Test
    fun test_nullableFetch_PopularShows_is_notNull(){
        val result = runBlocking { showRepository.nullableShows(ShowRepository.ShowType.POPULAR) }

        assertNotNull(result)
    }

    @Test
    fun test_nullableFetch_UpcomingShows_is_notNull(){
        val result = runBlocking { showRepository.nullableShows(ShowRepository.ShowType.UPCOMING) }

        assertNotNull(result)
    }

    @Test
    fun test_nullableFetch_NowPlayingShows_is_notNull(){
        val result = runBlocking { showRepository.nullableShows(ShowRepository.ShowType.NOW_PLAYING) }

        assertNotNull(result)
    }

    @Test
    fun test_nullableFetch_TopRatedShows_is_notNull(){
        val result = runBlocking { showRepository.nullableShows(ShowRepository.ShowType.TOP_RATED) }

        assertNotNull(result)
    }


}