package com.example.sportsstore.display.screens.homePage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sportsstore.domain.Constants
import com.example.sportsstore.domain.state.ResultState
import com.example.sportsstore.models.products
import com.example.sportsstore.models.profiles
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.storage.storage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomePageViewModel : ViewModel() {
//    private val _resultState = MutableStateFlow<ResultState>(ResultState.Loading)
//    val resultState: StateFlow<ResultState> = _resultState.asStateFlow()

    private val _products = MutableLiveData<List<products>>()
    val products: LiveData<List<products>> get() = _products

    private var allProduct: List<products> = listOf()

    private fun LoadProducts() {
        viewModelScope.launch {
            try {
                allProduct = Constants.supabase.postgrest.from("products").select().decodeList<products>()
                _products.value = allProduct

            } catch (e: Exception) {
                println("Ошибка чтения данных: ${e.message}")
            }
        }
    }

//    // Функция для получения URL изображения книги
//    suspend fun getUrlImage(productName: String): String {
//        return withContext(Dispatchers.IO) {
//            try {
//                val url = Constants.supabase.storage.from("products").publicUrl("${productName}.png")
//                Log.d("buck", url)
//                url
//            } catch (ex: AuthRestException) {
//                Log.e("Error", "Failed to get URL: ${ex.message}")
//                ""
//            }
//        }
//    }
}