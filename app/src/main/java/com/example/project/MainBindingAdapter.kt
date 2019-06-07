package com.example.project

import android.app.DatePickerDialog
import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputEditText
import java.util.Calendar

class MainBindingAdapter {
  companion object CurrencyBindingAdapter {

    @BindingAdapter(value = arrayOf("chosenDataListener", "chosenData"))
    @JvmStatic
    fun onDateChosen(
      textInputEditText: TextInputEditText,
      dateChosenListener: DateChosen,
      chosenDate: Calendar?
    ) {
      textInputEditText.setOnClickListener { view ->
        val calendar = chosenDate ?: Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val dialog = DatePickerDialog(
          view.context,
          DatePickerDialog.OnDateSetListener { _, yearOf, monthOfYear, dayOfMonth ->
            val newCalendar = Calendar.getInstance()
            newCalendar.set(yearOf, monthOfYear, dayOfMonth)
            dateChosenListener.onDateChosen(newCalendar)
          },
          year,
          month,
          day
        )
        dialog.show()
      }
    }
  }

}