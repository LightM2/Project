package com.example.project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val mainFragment = MainFragment.newInstance()
    val manager = supportFragmentManager
    val transaction = manager.beginTransaction()
    transaction.replace(R.id.fragmentFrame, mainFragment) //+extension
    transaction.addToBackStack(null)
    transaction.commit()
  }
}
