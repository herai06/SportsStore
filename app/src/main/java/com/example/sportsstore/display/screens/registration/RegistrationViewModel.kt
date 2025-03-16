package com.example.sportsstore.display.screens.registration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RegistrationViewModel : ViewModel() {
    private val _emailError = MutableStateFlow<String?>(null)
    val emailError: StateFlow<String?> = _emailError

    fun validateEmail(email: String) {
        viewModelScope.launch {
            if (!email.contains("@")) {
                _emailError.value = "Некорректный адрес электронной почты"
            } else {
                _emailError.value = null
            }
        }
    }
}