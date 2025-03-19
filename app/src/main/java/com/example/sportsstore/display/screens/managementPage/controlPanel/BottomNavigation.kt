package com.example.sportsstore.display.screens.managementPage.controlPanel

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigation(navController: NavController) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route
    var listItem = listOf(
        ButtonItem.Home,
        ButtonItem.Favorite,
        ButtonItem.Bag,
        ButtonItem.Notification,
        ButtonItem.Profile
    )
    NavigationBar (
        containerColor = Color.White
    ) {
        listItem.forEach { navItem ->
            NavigationBarItem(
                selected = currentRoute == navItem.route,
                onClick = {
                    if (currentRoute != navItem.route){
                        navController.navigate(navItem.route){
                            popUpTo(navController.graph.findStartDestination().id) {saveState = true}
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                icon = {
                    if (navItem.route == "BagPage")
                    {
                        Box(
                            modifier = Modifier.padding(bottom = 20.dp)
                        ){
                            FloatingActionButton(
                                onClick = {},
                                shape = CircleShape,
                                containerColor = Color(0xFF48B2E7),
                                contentColor = Color.White
                            ) {
                                Icon(
                                    painter = painterResource(navItem.image),
                                    contentDescription = navItem.title
                                )
                            }
                        }
                    } else {
                        Icon(
                            painter = painterResource(navItem.image),
                            contentDescription = navItem.title
                        )
                    }
                },
                alwaysShowLabel = false,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(0xFF48B2E7),
                    unselectedIconColor = Color(0xFF707B81),
                    indicatorColor = Color.Transparent
                )
            )
        }
    }
}