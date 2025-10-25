package com.ramazan.app.retrofit

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.HttpURLConnection

object RetrofitService {
    private const val URL_MOCKAPI:String = "https://твой_токен_здесь.mockapi.io/"
    var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(URL_MOCKAPI)
        //сериализация происходит за счет установки фабрики (в данном случае за сериализацию отвечате Gson)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun checkInternetConnection():Boolean {
        try{
            return runBlocking {
                CoroutineScope(Dispatchers.IO).async {
                    val responseCode = retrofit.create(TaskServerInterface::class.java).checkInternetConnection().execute().code()
                    if (responseCode == HttpURLConnection.HTTP_OK) {
                        Log.e("InternetConnection", "Internet connection is available")
                        true
                    } else {
                        Log.e("InternetConnection", "Internet connection is not available")
                        false
                    }
                }.await()

            }
        } catch (ex : Exception) {
            Log.e("InternetConnection", ex.toString())
            Log.d("InternetConnection", "No internet connection")
            return false
        }
    }
}