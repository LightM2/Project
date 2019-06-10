package com.example.project

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.LinearLayoutCompat
import com.google.android.material.textfield.TextInputLayout

class MyLinearLayout : LinearLayoutCompat {
  @JvmOverloads
  constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
  ) : super(context, attrs, defStyleAttr)

  private var iconImageView: ImageView = ImageView(context)
  /*private var textInputLayout: TextInputLayout = TextInputLayout(context)*/
  private var focusET = false

  init {
    iconImageView.setImageResource(R.drawable.ic_check_circle_default)
    val paramsIV = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
    paramsIV.gravity = Gravity.CENTER
    iconImageView.layoutParams = paramsIV
    this.addView(iconImageView, paramsIV)

  }

  override fun addView(child: View?, params: ViewGroup.LayoutParams?) {
    super.addView(child, params)
    if (child is TextInputLayout) {
      child.editText?.setOnFocusChangeListener { v, hasFocus ->
        Log.d("myteg", "$hasFocus")
        if (hasFocus) {
          focusET = true
        }
      }
    }

  }

}