package com.example.jsonfromnetpractice

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL

class DataViewModel(application: Application) :AndroidViewModel(application){
    private val _dataListLive = MutableLiveData<List<Data>>()
    val dataListLive : LiveData<List<Data>>
        get()=_dataListLive

    fun fetchData(){
        val dataUrl = "https://datacenter.taichung.gov.tw/Swagger/OpenData/44ff471a-8bda-429d-b5ba-29eace7b05ed?limit=20"
        Thread{
            val connection = URL(dataUrl).openConnection()
            val inputStream = connection.getInputStream()
            val bufferReader = BufferedReader(InputStreamReader(inputStream))
            var line = bufferReader.readLine()
            val json = StringBuffer()
            while (line != null){
                json.append(line)
                line = bufferReader.readLine()
            }
            val dataArrayList = Gson().fromJson(json.toString(),Array<Data>::class.java).toList()
            _dataListLive.postValue(dataArrayList)
        }.start()
    }
}
