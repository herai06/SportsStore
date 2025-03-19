package com.example.sportsstore.display.screens.profilePage

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.MutableLiveData
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sportsstore.display.screens.managementPage.controlPanel.ButtonItem
import com.example.sportsstore.domain.Constants
import com.example.sportsstore.domain.state.ResultState
import com.example.sportsstore.models.profiles
import io.github.jan.supabase.gotrue.exception.AuthRestException
import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.postgrest.postgrest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class ProfilePageViewModel : ViewModel() {
    private val _resultState = MutableStateFlow<ResultState>(ResultState.Loading)
    val resultState: StateFlow<ResultState> = _resultState.asStateFlow()

    private val _currentUser = MutableLiveData<List<profiles>>()
    val currentUser: LiveData<List<profiles>> get() = _currentUser

    private var allUser: List<profiles> = listOf()

    fun LoadCurrentUser() {
        _resultState.value = ResultState.Loading
        viewModelScope.launch {
            try {
                allUser = Constants.supabase.postgrest.from("profiles").select().decodeList<profiles>()
                _currentUser.value = allUser

            } catch (e: Exception) {
                println("Ошибка авторизации: ${e.message}")
            }
        }
    }
}