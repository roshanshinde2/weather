package com.ow.openweather.app.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeScreenViewModel : ViewModel() {

var screenHeading: String? = "Home Screen"
var message: String? = ""
private val toastMessageLiveData = MutableLiveData<String>()

fun getToastMessageLiveData() : LiveData<String> {
    return toastMessageLiveData;
}

fun fetchWeatherInfo(){
    if(toastMessageLiveData.value == "hello from Priyal")
        toastMessageLiveData.value = "hello from Poonam"
    else
        toastMessageLiveData.value = "hello from Priyal"
}



}
