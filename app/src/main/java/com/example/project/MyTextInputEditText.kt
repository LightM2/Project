package com.example.project

import android.content.Context
import android.graphics.Color
import android.graphics.Rect
import android.util.AttributeSet
import android.util.Log
import com.google.android.material.textfield.TextInputEditText

class MyTextInputEditText : TextInputEditText {
  @JvmOverloads
  constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = android.R.attr.editTextStyle
  ) : super(context, attrs, defStyleAttr)

  override fun getFocusedRect(rect: Rect?) {
    super.getFocusedRect(rect)
    var view = this
    Log.d("myteg", "Focused $rect")
    if (view.isFocused) {
      Log.d("myteg", "Focused true")
      view.setTextColor(Color.GREEN)
    }

  }

}