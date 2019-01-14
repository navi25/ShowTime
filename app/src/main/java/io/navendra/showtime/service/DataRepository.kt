package io.navendra.showtime.service

import android.util.Log
import io.navendra.showtime.utils.ShowTimeLog
import retrofit2.Response

open class DataRepository{

    suspend fun <T : Any> safeApiCall(call: suspend () -> Response<Result<T>>, errorMessage: String): T? {

        var data : T? = null

        try {

            val response = call.invoke()



            if(response.isSuccessful){

                val result = response.body()

                when(result){
                    is Result.Success ->
                        data = result.data
                    is Result.Error ->
                        ShowTimeLog.d{ "$errorMessage & Exception - ${result.exception}" }

                }
            }
        }catch (e: Exception){
            ShowTimeLog.d{ "$errorMessage & Exception - $e" }
        }

        return data

    }



}