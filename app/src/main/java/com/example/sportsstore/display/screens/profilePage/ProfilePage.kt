package com.example.sportsstore.display.screens.profilePage

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sportsstore.R

@SuppressLint("StateFlowValueCalledInComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfilePage(viewModel: ProfilePageViewModel = viewModel()) {
    val fontRaleway = FontFamily(
        Font(R.font.raleway_regular, FontWeight.Normal),
        Font(R.font.raleway_medium, FontWeight.Medium),
        Font(R.font.raleway_bold, FontWeight.Bold)
    )
    val textColor = Color(red = 112, green = 123, blue = 129, alpha = 255)

    val currentUser = viewModel.GetCurrentUser()
    val currentUserFirstname = currentUser?.firstname
    var firstName by remember { mutableStateOf(currentUserFirstname) }

    Box (
        modifier = Modifier.fillMaxSize()
            .padding(top = 50.dp, start = 20.dp, end = 20.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ElevatedButton (
                onClick = {
                    if (currentUser != null) {
                        viewModel.UpdateUserData(currentUser, firstName.toString())
                    }
                },
                modifier = Modifier.width(200.dp),
                shape = RoundedCornerShape(13.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF87CEEB))
            ) {
                Text (
                    "Сохранить",
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    fontFamily =  fontRaleway,
                    color = Color.White
                )
            }

            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = "Ваше имя",
                    fontFamily =  fontRaleway,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp
                )
                OutlinedTextField (
                    value = firstName.toString(),
                    onValueChange = { newText -> firstName = newText },
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
        }
    }
}