package com.example.sportsstore.display.screens.registration

import android.app.AlertDialog
import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.sportsstore.domain.Constants
import com.example.sportsstore.models.profiles
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.gotrue.providers.builtin.Email
import io.github.jan.supabase.postgrest.from
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.datetime.Clock
import java.util.UUID

class AccessControlViewModel(private val context: Context) : ViewModel() {
    // регулярное выражение
    private val emailRegex = "^[a-z0-9]+@[a-z0-9]+\\.[a-z]{2,}$".toRegex()

    // проверка email на корректный ввод
    fun IsValidEmail(email: String): Boolean {
        return emailRegex.matches(email)
    }

    // отображение диалогового окна с ошибкой ввода email
    fun ShowInvalidEmailDialog() {
        AlertDialog.Builder(context)
            .setTitle("Некорректный электронный адрес")
            .setMessage("Пожалуйста, проверьте формат электронного адреса.")
            .setPositiveButton("OK") { _, _ -> }
            .show()
    }

    // отображение диалогового окна с ошибкой пустых полей
    fun ShowEmptyFieldsDialog() {
        AlertDialog.Builder(context)
            .setTitle("Уведомление")
            .setMessage("Пожалуйста, заполните все поля.")
            .setPositiveButton("OK") { _, _ -> }
            .show()
    }

    // функция регистрации нового пользователя в базу данных
    suspend fun RegistrationNewUser( emailUser: String, passwordUser: String, nameUser: String): Boolean {
        return try {
            // регистрация пользователя в "auth"
            val authResponse = withContext(Dispatchers.IO) {
                Constants.supabase.auth.signUpWith(Email) {
                    email = emailUser
                    password = passwordUser
                }
            }
            val user = Constants.supabase.auth.retrieveUserForCurrentSession(updateSession = true) // получение id текущего пользователя
            val userId = user.id
            val newId = UUID.randomUUID() // генерация идентификатора для таблицы "profiles"
            val now = Clock.System.now() // получение текущей даты и времени
            // создание записи
            val newUser = profiles(
                id = newId.toString(),
                user_id = userId,
                created_at = now,
                photo = null,
                firstname = nameUser,
                lastname = null,
                address = null,
                phone = null
            )
            Constants.supabase.from("profiles")
                .insert(newUser) // добавление записи в таблицу "profiles"
            true
        } catch (e: Exception) {
            println("Ошибка регистрации: ${e.message}")
            false
        }
    }

    // функция авторизации пользователя
    suspend fun AuthorizationUser(emailUser: String, passwordUser: String): Boolean {
        return try {
            val user = withContext(Dispatchers.IO) {
                Constants.supabase.auth.signInWith(Email) {
                    email = emailUser
                    password = passwordUser
                }
            }
            val userr = Constants.supabase.auth.retrieveUserForCurrentSession(updateSession = true) // получение id текущего пользователя
            val userId = userr.id
            println("Пользователь: ${userId}")
            true
        } catch (e: Exception) {
            println("Ошибка авторизации: ${e.message}")
            false
        }
    }
}