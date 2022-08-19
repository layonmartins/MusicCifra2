package com.example.testciframusic

import android.text.SpannableString
import android.text.Spanned
import android.text.style.TextAppearanceSpan
import android.widget.TextView

fun TextView.setStyleOnSubstring(string: String, substring: String, style: Int){
    text = if (string.contains(substring)) {
        val spannable = SpannableString(string)
        spannable.setSpan(
            TextAppearanceSpan(context, style),
            string.indexOf(substring),
            string.indexOf(substring) + substring.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannable
    } else {
        string
    }
}

//TODO create a function that receives enum note and find all cipher
fun TextView.setStyleOnAllCipherSubstring(
    string: String,
    cipherSubstring: Note,
    style: Int = R.style.Theme_TestCifraMusic_Cipher
) {

}