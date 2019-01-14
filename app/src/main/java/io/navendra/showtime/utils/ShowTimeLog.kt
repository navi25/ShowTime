package io.navendra.showtime.utils

import android.util.Log

object ShowTimeLog{

    private val tag = {
        val stackTrace = Throwable().stackTrace
        val fileName = stackTrace[1].fileName
        val lineNumber = stackTrace[1].lineNumber

          "$fileName - $lineNumber"
    }


    fun d(blockMessage :  ()->String){
        val stackTrace = Throwable().stackTrace
        val fileName = stackTrace[1].fileName
        val lineNumber = stackTrace[1].lineNumber

        val tag= "$fileName - $lineNumber"
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