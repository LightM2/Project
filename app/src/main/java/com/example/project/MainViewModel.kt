package com.example.project

import android.util.Log
import androidx.databinding.Bindable
import java.text.SimpleDateFormat
import java.util.Calendar

class MainViewModel : BaseViewModel(), DateChosen {
  fun onClick() {
    Log.d("mytag", "onclick")
  }

  fun onClickNextBtn() {
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

  @get:Bindable var errorDocument: String? = null
    set(value) {
      if (field != value) {
        field = value
        notifyPropertyChanged(BR.errorDocument)
      }
    }

  @get:Bindable
  var document: String = ""
    set(value) {
      if (field != value) {
        field = value
        Log.d("myteg", "Passport Data Title $value")
        if (!isValidationDocument(value)) {
          errorDocument = "Error"
        } else errorDocument = null
      }
    }

  @get:Bindable var errorPlaceDocument: String? = null
    set(value) {
      if (field != value) {
        field = value
        notifyPropertyChanged(BR.errorPlaceDocument)
      }
    }

  @get:Bindable
  var placeDocument: String = ""
    set(value) {
      if (field != value) {
        field = value
        Log.d("myteg", "Passport Data Title $value")
        if (!isValidationDocument(value)) {
          errorPlaceDocument = "Как в паспорте"
        } else errorPlaceDocument = null
      }
    }

  @get:Bindable var errorSeries: String? = null
    set(value) {
      if (field != value) {
        field = value
        notifyPropertyChanged(BR.errorSeries)
      }
    }

  @get:Bindable
  var series: String = ""
    set(value) {
      if (field != value) {
        field = value
        Log.d("myteg", "Passport Data Title $value")
        if (!isValidationSeries(value)) {
          errorSeries = "Error"
        } else errorSeries = null
      }
    }

  @get:Bindable var errorNumber: String? = null
    set(value) {
      if (field != value) {
        field = value
        notifyPropertyChanged(BR.errorSeries)
      }
    }

  @get:Bindable
  var number: String = ""
    set(value) {
      if (field != value) {
        field = value
        Log.d("myteg", "Passport Data Title $value")
        if (!isValidationNumber(value)) {
          errorNumber = "Error"
        } else errorNumber = null
      }
    }

  @get:Bindable var errorIssuanceDate: String? = null
    set(value) {
      if (field != value) {
        field = value
        notifyPropertyChanged(BR.errorIssuanceDate)
      }
    }

  @get:Bindable
  var issuanceDate: String = ""
    set(value) {
      if (field != value) {
        field = value
        Log.d("myteg", "Passport Data Title $value")
        if (!isValidationIssuanceDate(value)) {
          errorIssuanceDate = "777-777"
        } else errorIssuanceDate = null
      }
    }




}


