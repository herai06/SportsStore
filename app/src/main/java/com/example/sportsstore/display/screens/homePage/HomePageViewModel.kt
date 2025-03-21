package com.example.sportsstore.display.screens.homePage

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.sportsstore.domain.Constants
import com.example.sportsstore.models.categories
import com.example.sportsstore.models.products
import io.github.jan.supabase.postgrest.from
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HomePageViewModel : ViewModel() {
    var listProducts by mutableStateOf<List<products>>(listOf())
    var listCategories by mutableStateOf<List<categories>>(listOf())

    @Composable
    fun GetListProducts() {
        LaunchedEffect(Unit) {
            listProducts = withContext(Dispatchers.IO) {
                Constants.supabase.from("products").select().decodeList<products>()
            }
        }
    }

    @Composable
    fun GetCategories() {
        LaunchedEffect(Unit) {
            listCategories = withContext(Dispatchers.IO) {
                Constants.supabase.from("categories").select().decodeList<categories>()
            }
        }
    }


}