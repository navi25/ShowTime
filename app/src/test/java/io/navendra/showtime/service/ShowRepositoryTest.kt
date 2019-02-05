package io.navendra.showtime.service

import com.nhaarman.mockitokotlin2.internal.createInstance
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.navendra.showtime.data.model.ParentShowList
import io.navendra.showtime.service.ApiFactory
import io.navendra.showtime.service.ShowRepository
import io.navendra.showtime.service.ShowsApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.Matcher
import org.hamcrest.CoreMatchers.`is` as Is
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.ArgumentMatcher
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import kotlin.test.assertNotNull
import kotlin.test.assertNull


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
    fun test_nullableFetch_all_individual_Shows_is_notNull(){
        val resultPopular = runBlocking { showRepository.nullableShows(ShowRepository.ShowType.POPULAR) }
        val resultUpcoming = runBlocking { showRepository.nullableShows(ShowRepository.ShowType.UPCOMING) }
        val resultNowPlaying = runBlocking { showRepository.nullableShows(ShowRepository.ShowType.NOW_PLAYING) }
        val resultTopRated = runBlocking { showRepository.nullableShows(ShowRepository.ShowType.TOP_RATED) }

        assertNotNull(resultPopular,"Nullable Popular Api result is null")
        assertNotNull(resultUpcoming,"Nullable Upcoming Api results is null")
        assertNotNull(resultNowPlaying,"Nullable Now Playing Api results is null")
        assertNotNull(resultTopRated,"Nullable Top Rated Api results is null")

    }

    @Test
    fun `fetchAllShows() returns not null `(){
        val result = runBlocking { showRepository.fetchAllShows() }

        assertNotNull(result,"Returned Result of allShows is null")
    }


    @Test
    fun `fetchAllShows() returns MutableList of ParentShowList`(){
        val result = runBlocking { showRepository.fetchAllShows() }

        assertThat("Result is not MutableList of ParentShowList",result,
                instanceOf(mutableListOf<ParentShowList>()::class.java))

    }

}