package io.navendra.showtime.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Job

open class BaseViewModel : ViewModel(){

    val parentJob = Job()

    fun cancelParentJob() = parentJob.cancel()

}