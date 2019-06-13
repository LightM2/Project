package com.example.project

import android.content.Context
import android.content.res.ColorStateList
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

  private enum class State {
    DEFAULT,
    FOCUSED,
    ERROR
  }

  private var focus = false
    set(value) {
      if (field != value) {
        field = value
        changedStateTIL()
      }
    }

  var errorText: String? = null
    set(value) {
      if (field != value) {
        field = value
        changedStateTIL()
        textInputLayout.error = value
      }
    }
  private var state = State.DEFAULT
    set(value) {
      if (field != value) {
        field = value
        changedStateIV()
      }
    }

  private lateinit var textInputLayout: TextInputLayout

  private val colorError = ContextCompat.getColor(context, R.color.colorErrorTextInputLayout)
  private val colorFocused = ContextCompat.getColor(context, R.color.colorFocusedTextInputLayout)
  private val colorDefault = ContextCompat.getColor(context, R.color.colorDefaultTextInputLayout)

  private var colorStateList: ColorStateList = ColorStateList(
    arrayOf(intArrayOf(android.R.attr.state_enabled)),
    intArrayOf(R.color.colorFocusedTextInputLayout)
  )

  init {
    if (attrs != null) {
      val t = context.obtainStyledAttributes(attrs, R.styleable.MyLinearLayout, defStyleAttr, 0)
      colorStateList = t.getColorStateList(R.styleable.MyLinearLayout_colorSL)
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
      textInputLayout = child
      child.editText?.setOnFocusChangeListener { _, hasFocus ->
        Log.d("myteg", "$hasFocus")
        focus = hasFocus
      }
    }
  }

  private fun changedStateTIL() {
    state = when {
      errorText != null -> State.ERROR
      focus -> State.FOCUSED
      else -> State.DEFAULT
    }
    changedStateIV()
  }

  private fun changedStateIV() {
    iconImageView.setColorFilter(
      when (state) {
        State.FOCUSED -> colorFocused
        State.ERROR -> colorError
        State.DEFAULT -> colorDefault
      }
    )
  }

}