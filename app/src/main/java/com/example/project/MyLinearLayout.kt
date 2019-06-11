package com.example.project

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.content.ContextCompat
import com.google.android.material.textfield.TextInputLayout

class MyLinearLayout : LinearLayoutCompat {
  constructor(context: Context) : this(context, null)
  constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

  constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
    context,
    attrs,
    defStyleAttr
  ) {
    var t = context.obtainStyledAttributes(attrs, R.styleable.StateLL, defStyleAttr, 0)

  }




  private var iconImageView: ImageView = ImageView(context)

  /*private var textInputLayout: TextInputLayout = TextInputLayout(context)*/
  private var focusET = false
  private var errorET = false
  /*private val STATE_FOCUS_LL = intArrayOf(R.attr.state_focus_LL)
  private val STATE_ERROR_LL = intArrayOf(R.attr.state_error_LL)
  private val STATE_DEFAULT_LL = intArrayOf(R.attr.state_default_LL)*/

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
          errorET = true
          iconImageView.setColorFilter(
            ContextCompat.getColor(
              context,
              R.color.colorFocusedTextInputLayout
            ), android.graphics.PorterDuff.Mode.SRC_IN
          )
        }
      }
    }
  }

  fun setError() {

  }

  /*fun changedIVTint(){
    val states = arrayOf( intArrayOf(android.R.attr.state_enabled) )
    //iconImageView.imageTintList = ColorStateList( states, intArrayOf(Color.GREEN) )
    when{
      focusET -> iconImageView.imageTintList = ColorStateList( states, intArrayOf(R.color.colorFocusedTextInputLayout) )
      errorET -> iconImageView.imageTintList = ColorStateList( states, intArrayOf(R.color.colorErrorTextInputLayout) )
      else -> iconImageView.imageTintList = ColorStateList( states, intArrayOf(R.color.colorDefaultTextInputLayout) )
    }
  }*/

  /*override fun onCreateDrawableState(extraSpace: Int): IntArray {
    val baseState = super.onCreateDrawableState(extraSpace + 3)
    when{
      focusET -> View.mergeDrawableStates(baseState, STATE_FOCUS_LL)
      errorET -> View.mergeDrawableStates(baseState, STATE_ERROR_LL)
      else -> View.mergeDrawableStates(baseState, STATE_DEFAULT_LL)
    }
    return baseState
  }




  fun setFocusET(b:Boolean){
    if (focusET != b){
      focusET = b
      refreshDrawableState()
    }
  }

  fun setErrorET(b: Boolean){
    if (errorET != b){
      errorET = b
      refreshDrawableState()
    }
  }*/

}