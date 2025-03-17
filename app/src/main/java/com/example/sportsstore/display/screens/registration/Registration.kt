package com.example.sportsstore.display.view.screens

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.example.sportsstore.R
import com.example.sportsstore.display.screens.registration.RegistrationViewModel


@ExperimentalMaterial3Api
class RegistrationClass(private val context: Context) {
//class RegistrationClass() {

    private val fontRaleway = FontFamily(
        Font(R.font.raleway_regular, FontWeight.Normal),
        Font(R.font.raleway_medium, FontWeight.Medium),
        Font(R.font.raleway_bold, FontWeight.Bold)
    )

    private val textColor = Color(red = 112, green = 123, blue = 129, alpha = 255)

//    @Preview
    @Composable
    fun Registration() {
        val viewModel = RegistrationViewModel(context)
        val nameUser = remember { mutableStateOf("") }
        val emailUser = remember { mutableStateOf("") }
        val passwordUser = remember { mutableStateOf("") }
        var checkedState by remember { mutableStateOf(false) }
        var isButtonEnabled by remember { mutableStateOf(false) }
        var passwordVisibility by remember { mutableStateOf(false) }
        val icon = if (passwordVisibility)
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
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(bottom = 50.dp)
                ) {
                    Text(
                        text = "Регистрация",
                        fontFamily =  fontRaleway,
                        fontWeight = FontWeight.Normal,
                        fontSize = 32.sp,
                        modifier = Modifier.padding(bottom = 10.dp)
                    )
                    Text(
                        text = "Заполните Свои данные",
                        fontFamily =  fontRaleway,
                        fontWeight = FontWeight.Normal,
                        fontSize = 16.sp,
                        color = textColor
                    )
                }
                Column(
                    modifier = Modifier.padding(bottom = 10.dp)
                )
                {
                    Text(
                        text = "Ваше имя",
                        fontFamily =  fontRaleway,
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp
                    )
                    OutlinedTextField(
                        value = nameUser.value,
                        onValueChange = { newText -> nameUser.value = newText },
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
                            containerColor = Color.Transparent, // Удаление рамок
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
                            Text("xxxxxxxx",
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
                            containerColor = Color.Transparent, // Удаление рамок
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
                                    contentDescription = "Visibility Icon"
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
                            containerColor = Color.Transparent, // Удаление рамок
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
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                )
                {
                    Checkbox(
                        checked = checkedState,
                        onCheckedChange = {
                            checkedState = it
                            isButtonEnabled = it
                        },
                        colors = CheckboxDefaults.colors(
                            checkedColor = Color(0xFF87CEEB)
                        )
                    )
                    Text(
                        "Даю согласие на обработку персональных данных",
                        fontSize = 14.sp,
                        color = textColor,
                        fontFamily =  fontRaleway,
                        fontWeight = FontWeight.Normal,
                        lineHeight = 16.sp,
                        textDecoration = TextDecoration.Underline,
                        modifier = Modifier.padding(bottom = 15.dp)
                    )
                }
                Button(
                    onClick = {
                        if (viewModel.isValidEmail(emailUser.value)) {

                        }
                        else{
                            viewModel.showInvalidEmailDialog()
                        }
                    },
                    enabled = isButtonEnabled,
                    modifier = Modifier.fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(13.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF87CEEB)),
                ) {
                    Text(
                        "Зарегистрироваться",
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp,
                        fontFamily =  fontRaleway,
                        color = Color.White
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 55.dp),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.Center
            )
            {
                Text(
                    text = "Есть аккаунт?",
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    fontFamily =  fontRaleway,
                    modifier = Modifier.padding(end = 5.dp)
                )
                Text (
                    text = "Войти",
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    fontFamily =  fontRaleway,
//                    modifier = Modifier.clickable(
//                        onClick = {
//                            // Здесь указываем переход на другую страницу
//                            navController.navigate("route_to_another_screen")
//                        }
//                    )
                )
            }
        }
    }
}





