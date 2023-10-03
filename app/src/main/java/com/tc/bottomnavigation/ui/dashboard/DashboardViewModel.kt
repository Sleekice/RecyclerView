package com.tc.bottomnavigation.ui.dashboard

import android.media.Image
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tc.bottomnavigation.R

class DashboardViewModel : ViewModel() {

    fun getNames(): List<String> {
        return listOf(
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

    fun getDescription(): List<String> {
        return listOf(
            "The front end developer who job is to do the UI",
            "This person does the fancy stuff",
            "This is the quality assurance guy",
            "The guy that organizes everything in the company",
            "The guy who handles all the issues development wise",
            "The guy who brings the development problems to us",
            "The backend designer / developer",
            "This guy also works in as a QA",
            "This guy approves all the code of the office",
            "This guy gives feedback to the developer in the office",

            )
    }


    fun getImages(): List<Int> {
        return listOf(
            R.drawable.baseline_self_improvement_24,
            R.drawable.baseline_thumb_up_24,
            R.drawable.baseline_tips_and_updates_24,
            R.drawable.baseline_touch_app_24,
            R.drawable.baseline_train_24,
            R.drawable.baseline_translate_24,
            R.drawable.baseline_tune_24,
            R.drawable.baseline_turned_in_24,
            R.drawable.baseline_type_specimen_24,
            R.drawable.baseline_watch_later_24
            )
    }
    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }

    val text: LiveData<String> = _text
}