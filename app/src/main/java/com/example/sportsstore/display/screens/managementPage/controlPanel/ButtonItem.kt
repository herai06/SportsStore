package com.example.sportsstore.display.screens.managementPage.controlPanel

import com.example.sportsstore.R

sealed class ButtonItem(val title: String,val image: Int, val route: String) {
    object Home: ButtonItem("Главная", R.drawable.ic_home, "HomePage")
    object Favorite: ButtonItem("Избранное", R.drawable.ic_favorite, "FavoritePage")
    object Bag: ButtonItem("Корзина", R.drawable.ic_bag, "BagPage")
    object Notification: ButtonItem("Уведомления", R.drawable.ic_notification, "NotificationPage")
    object Profile: ButtonItem("Профиль", R.drawable.ic_profile, "ProfilePage")
}