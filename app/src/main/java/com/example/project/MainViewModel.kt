package com.example.project

import android.util.Log
import androidx.databinding.Bindable
import java.text.SimpleDateFormat
import java.util.Calendar

class MainViewModel : BaseViewModel(), DateChosen {
  fun onClick() {
    Log.d("mytag", "onclick")
  }

  override fun onDateChosen(calendar: Calendar) {
    date = calendar
    notifyPropertyChanged(BR.dateString)
  }

  @get:Bindable var date: Calendar? = null
    set(value) {
      if (field != value) {
        field = value
        notifyPropertyChanged(BR.date)
      }
    }

  @Bindable
  fun getDateString(): String = date?.let { calendar ->
    val formal = SimpleDateFormat("dd.MM.yyyy")
    formal.format(date?.time)
  } ?: ""

}


