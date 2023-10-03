package com.tc.bottomnavigation.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.ArrayList

class HomeViewModel : ViewModel() {
    fun getUserList(): ArrayList<String> {
        return arrayListOf(
            "Peter",
            "Tiewah",
            "Abdullahi",
            "Munye",
            "Samuel",
            "Bissett",
            "Jermaine",
            "Tucker",
            "Mukarrim",
            "Adam",
        )
    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text
}