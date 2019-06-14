package com.example.project

val patternDocument = "[А-Яа-яЁё -]{1,100}".toRegex()
val patternSeries = "[0-9]{1,4}".toRegex()
val patternNumber = "[0-9]{1,6}".toRegex()
val patternIssuanceDate = "[0-9]+-[0-9]{1,3}".toRegex()

fun isValidationDocument(string: String): Boolean {
  return patternDocument.matches(string)
}

fun isValidationSeries(string: String): Boolean {
  return patternSeries.matches(string)
}

fun isValidationNumber(string: String): Boolean {
  return patternNumber.matches(string)
}

fun isValidationIssuanceDate(string: String): Boolean {
  return patternIssuanceDate.matches(string)
}



