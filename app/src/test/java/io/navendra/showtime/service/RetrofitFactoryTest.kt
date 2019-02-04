package io.navendra.showtime.service

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.navendra.showtime.AppConstants
import io.navendra.showtime.utils.ShowTimeLog
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import retrofit2.Retrofit

@RunWith(JUnit4::class)
class RetrofitFactoryTest {

    private val mockRetrofitFactory = mock<RetrofitFactory>()

    @Mock
    private lateinit var log : ShowTimeLog

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

    }

    val retrofit = Retrofit.Builder()
            .baseUrl(AppConstants.Network.TMDB_BASE_URL)
            .build()

    @Test
    fun test_RetrofitBuilder(){

        whenever(mockRetrofitFactory.retrofit()).thenReturn(retrofit)

        assertEquals(AppConstants.Network.TMDB_BASE_URL, mockRetrofitFactory.retrofit().baseUrl().toString())
    }

    @After
    fun tearDown() {

    }
}