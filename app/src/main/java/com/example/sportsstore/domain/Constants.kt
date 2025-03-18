package com.example.sportsstore.domain

import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.Auth
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.storage.Storage

object Constants {
    val supabase = createSupabaseClient(
        supabaseUrl = "https://vgqqzenpedsvzgnhyeem.supabase.co",
        supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InZncXF6ZW5wZWRzdnpnbmh5ZWVtIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NDIxMzg4OTYsImV4cCI6MjA1NzcxNDg5Nn0.FyPP04q63tqdunRb-QYa7bPaf0WlPWPzub2gZkDF7Ac"
    ) {
        install(Auth)
        install(Postgrest)
        install(Storage)
    }
}