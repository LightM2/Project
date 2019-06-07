package com.example.project

import java.util.Calendar

interface DateChosen {
  fun onDateChosen(calendar: Calendar): Unit
}