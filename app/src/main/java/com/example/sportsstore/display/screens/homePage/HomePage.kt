package com.example.sportsstore.display.screens.homePage

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sportsstore.display.screens.homePage.components.ProductCard
import kotlinx.coroutines.runBlocking

@Composable
fun HomePage(viewModel: HomePageViewModel = viewModel()) {
    val products = viewModel.products.observeAsState(emptyList())

    LazyColumn {

    }
}