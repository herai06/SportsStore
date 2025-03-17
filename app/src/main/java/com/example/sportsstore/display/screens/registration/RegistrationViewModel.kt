package com.example.sportsstore.display.screens.registration


import android.app.AlertDialog
import android.content.Context
import androidx.lifecycle.ViewModel

class RegistrationViewModel(private val context: Context) : ViewModel() {
    private val emailRegex = "^[a-z0-9]+@[a-z0-9]+\\.[a-z]{3,}$".toRegex()
    fun isValidEmail(email: String): Boolean {
        return emailRegex.matches(email)
    }

    fun showInvalidEmailDialog() {
        AlertDialog.Builder(context)
            .setTitle("Некорректный электронный адрес")
            .setMessage("Пожалуйста, проверьте формат электронного адреса.")
            .setPositiveButton("OK") { _, _ -> }
            .show()
    }


}