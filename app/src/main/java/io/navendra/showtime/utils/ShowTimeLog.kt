package io.navendra.showtime.utils

import android.util.Log
import kotlinx.coroutines.Deferred

object ShowTimeLog{

    private fun tag() : String{
        val stackTrace = Throwable().stackTrace
        val fileName = stackTrace[2].fileName
        val methodName = stackTrace[2].methodName
        val lineNumber = stackTrace[2].lineNumber

         return "$fileName::$methodName, Line - $lineNumber"
    }


    fun d(blockMessage :  ()->String){
        val message = blockMessage.invoke()
        Log.d(tag(),message)
    }

    fun e(blockMessage :  ()->String){
        val message = blockMessage.invoke()
        Log.e(tag(),message)
    }

    fun i(blockMessage :  ()->String){
        val message = blockMessage.invoke()
        Log.i(tag(),message)
    }

    fun w(blockMessage :  ()->String){
        val message = blockMessage.invoke()
        Log.w(tag(),message)
    }

    fun v(blockMessage :  ()->String) : Int{
        val message = blockMessage.invoke()
        return Log.v(tag(),message)
    }

    fun wtf(blockMessage :  ()->String): Int{
        val message = blockMessage.invoke()
        return Log.wtf(tag(),message)
    }




}