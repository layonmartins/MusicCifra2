package com.example.testciframusic

import android.text.SpannableString
import android.text.Spanned
import android.text.style.TextAppearanceSpan
import android.util.Log
import android.widget.TextView
import java.lang.IndexOutOfBoundsException

fun TextView.setStyleOnSubstringApproach1(string: String, substring: String, style: Int){
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

//It faster than setStyleOnSubstringApproach1
fun TextView.setStyleOnSubstringApproach2(
    string: String,
    cipherSubstring: Note,
    style: Int = R.style.Theme_TestCifraMusic_Cipher
) {
    Log.i("layon.f", "setStyleOnSubstringApproach2 string = $string")
    val spannable = SpannableString(string)
    try {
        spannable.setSpan(
            TextAppearanceSpan(context, style),
            string.indexOf(cipherSubstring.cipher),
            string.indexOf(cipherSubstring.cipher) + cipherSubstring.cipher.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        text = spannable
    } catch (e : IndexOutOfBoundsException) {
        Log.e("layon.f", "Error, there is no substring on string")
    }
}

//It batter than setStyleOnSubstringApproach2
fun TextView.setStyleOnSubstringApproach3(
    string: String,
    style: Int = R.style.Theme_TestCifraMusic_Cipher
) {
    Log.i("layon.f", "setStyleOnSubstringApproach3 string = $string")
    val spannable = SpannableString(string)

    try {
        spannable.setSpan(
            TextAppearanceSpan(context, style),
            string.indexOf(Note.D.cipher),
            string.indexOf(Note.D.cipher) + Note.D.cipher.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
    } catch (e : IndexOutOfBoundsException) {
        Log.e("layon.f", "Error, there is no substring on string")
    }

    try {
        spannable.setSpan(
            TextAppearanceSpan(context, style),
            string.indexOf(Note.D.cipher),
            string.indexOf(Note.D.cipher) + Note.D.cipher.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
    } catch (e : IndexOutOfBoundsException) {
        Log.e("layon.f", "Error, there is no substring on string")
    }

    text = spannable
}

//It batter than setStyleOnSubstringApproach3
fun TextView.setStyleOnSubstringApproach4(
    string: String,
    style: Int = R.style.Theme_TestCifraMusic_Cipher
) {
    Log.i("layon.f", "setStyleOnSubstringApproach4 string = $string")
    val spannable = SpannableString(string)

    Note.values().forEach {
        try {
            spannable.setSpan(
                TextAppearanceSpan(context, style),
                string.indexOf(it.cipher),
                string.indexOf(it.cipher) + it.cipher.length,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        } catch (e : IndexOutOfBoundsException) {
            Log.e("layon.f", "Error, there is no substring (${it.cipher}) on string")
        }
    }

    text = spannable
}

//iterate and change all note with plus tom note
fun String.plusTom(
    string: String,
) : String {
    return string.replace(Note.C.cipher, Note.D.cipher)
}
