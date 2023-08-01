package com.example.moviesampleclean.util.exception

import androidx.annotation.StringRes

class MovieException (val type: Type, @StringRes val userFriendlyMessage:Int=0, val serverMessage:String?=null):Throwable() {

    enum class Type{
        SIMPLE,DIALOG,AUTH
    }
}