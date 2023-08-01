package com.example.moviesampleclean.util.exception

import org.json.JSONObject
import retrofit2.HttpException
import timber.log.Timber

class MovieExceptionMapper {


    companion object {
        fun map(throwable: Throwable): MovieException {
            if (throwable is HttpException){
                try {
                    val errorJsonObject= JSONObject(throwable.response()?.errorBody()!!.string())
                    val errorMessage=errorJsonObject.getString("message")

                    return if(throwable.code()==401){
                        MovieException(MovieException.Type.AUTH,serverMessage = errorMessage)
                    } else if(throwable.code()==404){
                        MovieException(MovieException.Type.SIMPLE,serverMessage = errorMessage)
                    } else
                        MovieException(MovieException.Type.SIMPLE,serverMessage = errorMessage)
                }
                catch (exception:Exception){
                    Timber.e(exception.toString())
                }
            }
            return MovieException(MovieException.Type.SIMPLE, serverMessage = throwable.message?:"Unknown error")
        }

    }

}