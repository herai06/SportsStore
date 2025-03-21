package com.example.sportsstore.display.screens.profilePage

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sportsstore.domain.Constants
import com.example.sportsstore.models.profiles
import io.github.jan.supabase.postgrest.from
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class ProfilePageViewModel : ViewModel() {
    var currentUser by mutableStateOf(EmptyProfile())

    @Composable
    fun GetCurrentUser() : profiles? {
        LaunchedEffect(Unit) {
            try {
                currentUser = withContext(Dispatchers.IO){
                    Constants.supabase.from("profiles").select().decodeSingle<profiles>()
                }
                println("Пользователь: ${currentUser.user_id}")
            } catch (e: Exception) {
                println("Ошибка получения данных о пользователе: ${e.message}")
            }
        }
        return currentUser
    }

    fun UpdateUserData(currentUser: profiles, firstName: String) {
        viewModelScope.launch {
            try {
                Constants.supabase
                    .from("profiles")
                    .update(mapOf("firstname" to firstName)) {
                        filter{
                            eq("id", currentUser.id)
                        }
                    }
                println("Данные о пользователе ${currentUser.id} обновлены!")
            } catch (e: Exception) {
                println("Ошибка обновления данных о пользователе: ${e.message}")
            }
        }
    }

    fun EmptyProfile(): profiles {
        return profiles(
            id = "",
            created_at = null,
            user_id = null,
            photo = null,
            firstname = null,
            lastname = null,
            address = null,
            phone = null
        )
    }

}