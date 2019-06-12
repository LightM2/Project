package com.example.project

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.util.AttributeSet
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.content.ContextCompat
import com.google.android.material.textfield.TextInputLayout

class MyLinearLayout @JvmOverloads constructor(
  context: Context,
  attrs: AttributeSet? = null,
  defStyleAttr: Int = 0
) : LinearLayoutCompat(context, attrs, defStyleAttr) {

  private var iconImageView: ImageView = ImageView(context)

  enum class State {
    DEFAULT,
    FOCUSED,
    ERROR
  }

  private var error = false
  private var focus = false
  var colorStateList: ColorStateList = ColorStateList(
    arrayOf(intArrayOf(android.R.attr.state_enabled)),
    intArrayOf(R.color.colorFocusedTextInputLayout)
  )

  init {
    if (attrs != null) {
      val t = context.obtainStyledAttributes(attrs, R.styleable.MyLinearLayout, defStyleAttr, 0)
      colorStateList = t.getColorStateList(R.styleable.MyLinearLayout_colorSL)
      val color = colorStateList.getColorForState(drawableState, Color.WHITE)
      Log.d("myteg", "$color")

    }
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
        changedState(hasFocus, child)

        /*if (hasFocus) {
          changedState(hasFocus)

          iconImageView.setColorFilter(colorStateList.getColorForState(drawableState, 0))
        }*/
      }
    }
  }

  private fun changedState(hasFocus: Boolean, textInputLayout: TextInputLayout) {
    var text = textInputLayout.editText?.text.toString()
    if (error) {
      setError(text)
    } else {
      if (hasFocus) {
        setFocus()
        Log.d("myteg", "Focused")
      } else {
        setError(text)
        Log.d("myteg", "Default")
        textInputLayout.error = "Error"
      }
    }

    /*if (hasFocus()){
      State.Focused.s = true
      State.Default.s = false
      iconImageView.setColorFilter(colorStateList.getColorForState(drawableState, 0))
      Log.d("myteg", "Focused")
    }else{
      State.Focused.s = false
      State.Default.s = true
      Log.d("myteg", "Default")
    }*/
  }

  private fun setError(string: String) {
    error = true
    focus = false
    iconImageView.setColorFilter(ContextCompat.getColor(context, R.color.colorErrorTextInputLayout))
  }

  private fun setFocus() {
    focus = true
    iconImageView.setColorFilter(
      ContextCompat.getColor(
        context,
        R.color.colorFocusedTextInputLayout
      )
    )
  }

}