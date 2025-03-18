package com.example.sportsstore.models

import kotlinx.serialization.Serializable

@Serializable
data class categories (
    val id: String,
    val title: String
)