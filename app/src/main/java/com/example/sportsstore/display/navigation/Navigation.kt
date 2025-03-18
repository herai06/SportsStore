package com.example.sportsstore.display.view.navigation

import android.content.Context
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sportsstore.display.screens.authorization.AuthorizationClass
import com.example.sportsstore.display.view.screens.RegistrationClass

class NavigationClass(private val context: Context) {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Navigation() {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = "Registration"
        ) {
            composable("Registration") { RegistrationClass(context).Registration(navController) }
            composable("Authorization") { AuthorizationClass(context).Authorization(navController) }
        }
    }
}

