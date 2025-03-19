package com.example.sportsstore.display.screens.managementPage

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDirection.Companion.Content
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.sportsstore.display.screens.homePage.HomePage
import com.example.sportsstore.display.screens.managementPage.controlPanel.BottomNavigation
import com.example.sportsstore.display.screens.managementPage.controlPanel.ButtonItem
import com.example.sportsstore.display.screens.profilePage.ProfilePage
import androidx.compose.material3.IconButton as IconButton

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ManagementPage() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigation(navController) }
    ) {
        NavHost(
            navController = navController,
            startDestination = "HomePage"
        ) {
              composable("HomePage") { HomePage() }
              composable("FavoritePage") {  }
              composable("BagPage") {  }
              composable("NotificationPage") {  }
              composable("ProfilePage") { ProfilePage() }
        }
    }
}