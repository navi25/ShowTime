package io.navendra.showtime.data

import io.navendra.showtime.service.ShowRepository
import io.navendra.showtime.service.ShowsApiService
import kotlinx.coroutines.CoroutineScope
import org.junit.Before
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.MockitoAnnotations

@RunWith(JUnit4::class)
class ShowRepositoryTest{

    @Mock
    lateinit var showsApiService: ShowsApiService

    @Mock
    lateinit var scope: CoroutineScope

    lateinit var showRepository: ShowRepository

    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
        showRepository = ShowRepository(this.showsApiService,this.scope)
    }
}