package com.tc.bottomnavigation.ui.notifications

import android.os.Build.VERSION_CODES.M
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tc.bottomnavigation.data.ApiDetails
import com.tc.bottomnavigation.ui.notifications.data.CatFact
import com.tc.bottomnavigation.ui.notifications.data.CatFactItemModel
import com.tc.bottomnavigation.ui.notifications.data.CatImage
import com.tc.bottomnavigation.ui.notifications.data.CatImageItemModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class NotificationsViewModel : ViewModel() {

    private val _counter = MutableLiveData<Int>()
    val counter: LiveData<Int> = _counter

    private val _catFacts = MutableLiveData<ArrayList<CatFactItemModel>>()
    val catFact: LiveData<ArrayList<CatFactItemModel>> = _catFacts

    private val _catImage = MutableLiveData<ArrayList<CatImageItemModel>>()
    val catImage: LiveData<ArrayList<CatImageItemModel>> = _catImage



    private var counterValue: Int = 0

    fun updateCount() {
        // does it smartly whenever the resources are available
        _counter.postValue(counterValue++)

        // does it forcefully doesn't care about the resources
        // _counter.value = counterValue++
    }

    fun getCount(): Int {
        return counterValue
    }


    fun getCatFacts() {
        GlobalScope.launch {
            val result = ApiDetails.service.getCatFacts()
            if (result.isSuccessful) {
                _catFacts.postValue(result.body())
            } else {
                _catFacts.postValue(CatFact())
            }
        }
    }


    fun getCatImage(){
        GlobalScope.launch {
            val result = ApiDetails.service.getCatImage()

            if(result.isSuccessful) {
                _catImage.postValue(result.body())
            }else{
                _catImage.postValue(CatImage())
            }
        }
    }

    }

