package com.example.sportsstore.display.screens.authorization

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sportsstore.R
import com.example.sportsstore.display.screens.registration.AccessControlViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AuthorizationClass(private val context: Context) {
    // подключение шрифта
    val fontRaleway = FontFamily(
        Font(R.font.raleway_regular, FontWeight.Normal),
        Font(R.font.raleway_medium, FontWeight.Medium),
        Font(R.font.raleway_bold, FontWeight.Bold)
    )
    val textColor = Color(red = 112, green = 123, blue = 129, alpha = 255)

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Authorization(navController: NavController) {
        val viewModel = AccessControlViewModel(context) // подключение viewModel
        val flagUser = remember { mutableStateOf(false) } // флаг, отвечающий за успех авторизации и переход на следующий экран
        val emailUser = remember { mutableStateOf("") } // переменная для значения email
        val passwordUser = remember { mutableStateOf("") } // переменная для значения пароля
        var passwordVisibility by remember { mutableStateOf(false) } // показ пароля
        val icon = if (passwordVisibility) // устанока картинки в зависимости от показа пароля
            painterResource(id = R.drawable.ic_visibility_off)
        else
            painterResource(id = R.drawable.ic_visibility)

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(start = 20.dp, end = 20.dp, bottom = 40.dp)
            )
            {
                // колонка с заголовком
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(bottom = 50.dp)
                ) {
                    Text(
                        text = "Привет!",
                        fontFamily =  fontRaleway,
                        fontWeight = FontWeight.Normal,
                        fontSize = 32.sp,
                        modifier = Modifier.padding(bottom = 10.dp)
                    )
                    Text(
                        text = "Заполните Свои Данные",
                        fontFamily =  fontRaleway,
                        fontWeight = FontWeight.Normal,
                        fontSize = 16.sp,
                        color = textColor
                    )
                }
                // колонка с полем для ввода email
                Column(
                    modifier = Modifier.padding(bottom = 10.dp)
                )
                {
                    Text(
                        text = "Email",
                        fontFamily =  fontRaleway,
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp
                    )
                    OutlinedTextField(
                        value = emailUser.value,
                        onValueChange = { newText -> emailUser.value = newText },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp)
                            .clip(
                                RoundedCornerShape(
                                    topStart = 10.dp,
                                    topEnd = 10.dp,
                                    bottomEnd = 10.dp,
                                    bottomStart = 10.dp,
                                )
                            )
                            .background(color = Color(247, 247, 249, 255)),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                        textStyle = TextStyle(
                            color = Color.Black,
                            fontFamily =  fontRaleway,
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp,
                        ),
                        placeholder = {
                            Text("xyz@gmail.com",
                                color = textColor,
                                fontFamily =  fontRaleway,
                                fontWeight = FontWeight.Normal,
                                fontSize = 14.sp,
                                modifier = Modifier.padding(0.dp).fillMaxWidth()
                            )
                        },
                        singleLine = true
                    )
                }
                // колонка с полем для ввода пароля
                Column(
                    modifier = Modifier.padding(bottom = 15.dp)
                )
                {
                    Text(
                        text = "Пароль",
                        fontFamily =  fontRaleway,
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp
                    )
                    OutlinedTextField(
                        value = passwordUser.value,
                        onValueChange = { newText -> passwordUser.value = newText },
                        trailingIcon = {
                            IconButton(onClick = {
                                passwordVisibility = !passwordVisibility
                            }) {
                                Icon(
                                    painter = icon,
                                    contentDescription = "скрыть/показать"
                                )
                            }
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password
                        ),
                        visualTransformation = if (passwordVisibility) VisualTransformation.None
                        else PasswordVisualTransformation(),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp)
                            .clip(
                                RoundedCornerShape(
                                    topStart = 10.dp,
                                    topEnd = 10.dp,
                                    bottomEnd = 10.dp,
                                    bottomStart = 10.dp,
                                )
                            )
                            .background(color = Color(247, 247, 249, 255)),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                        textStyle = TextStyle(
                            color = Color.Black,
                            fontFamily =  fontRaleway,
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp,
                        ),
                        singleLine = true
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth().padding(bottom = 15.dp),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        "Восстановить",
                        fontFamily =  fontRaleway,
                        fontWeight = FontWeight.Normal,
                        fontSize = 12.sp
                    )
                }
                // кнопка для авторизации
                Button (
                    onClick = {
                        if (emailUser.value.isNotEmpty() && passwordUser.value.isNotEmpty()) {
                            if (viewModel.IsValidEmail(emailUser.value)) { // проверка на корректный ввод email
                            CoroutineScope(Dispatchers.IO).launch {
                                val flag = viewModel.AuthorizationUser(emailUser.value, passwordUser.value) // авторизация пользователя
                                flagUser.value = flag
                                if (flagUser.value == true) {
//                                navController.navigate("MainPage")
                                }
                            }
                            } else {
                                viewModel.ShowInvalidEmailDialog() // отображение диалогового окна с ошибкой ввода email
                            }
                        } else {
                            viewModel.ShowEmptyFieldsDialog() // отображение диалогового окна с ошибкой пустых полей
                        }

                    },
                    modifier = Modifier.fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(13.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF87CEEB)),
                ) {
                    Text(
                        "Войти",
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp,
                        fontFamily =  fontRaleway,
                        color = Color.White
                    )
                }
            }
            // строка для перехода на страницу регистрации
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 55.dp),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.Center
            )
            {
                Text(
                    text = "Вы впервые?",
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    fontFamily =  fontRaleway,
                    modifier = Modifier.padding(end = 5.dp)
                )
                Text (
                    text = "Создать",
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    fontFamily =  fontRaleway,
                    modifier = Modifier.clickable(
                        onClick = {
                            navController.navigate("Registration")
                        }
                    )
                )
            }
        }
    }
}
