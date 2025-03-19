package com.example.sportsstore

import android.graphics.Color
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.sportsstore.display.screens.managementPage.ManagementPage
import com.example.sportsstore.display.view.navigation.NavigationClass
import com.example.sportsstore.display.view.screens.RegistrationClass
import com.example.sportsstore.ui.theme.SportsStoreTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SportsStoreTheme {
                NavigationClass(this).Navigation()
//                ManagementPage()
            }
        }
    }
}
