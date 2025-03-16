package com.example.sportsstore.display.view.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.example.sportsstore.display.screens.registration.RegistrationViewModel


@Composable
@Preview
fun Registration(viewModel: RegistrationViewModel = RegistrationViewModel()) {
    Column()
    {
        Text(text = "Регистрация")
        Text(text = "Заполните Свои данные")

        Column()
        {
            Text(text = "Ваше имя")
        }

    }
}