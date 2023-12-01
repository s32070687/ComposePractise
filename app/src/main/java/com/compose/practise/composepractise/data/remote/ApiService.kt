package com.compose.practise.composepractise.data.remote

import com.compose.practise.composepractise.data.model.SearchImage
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    companion object {
        const val BASE_URL = "https://pixabay.com/"
        const val PIXABAY_API_KEY = "31710667-862c7e67b22aab6ffbbd9ac75"
    }

    /** 搜尋圖片 */
    @GET("api/")
    suspend fun searchImage(
        @Query("key") key: String = PIXABAY_API_KEY,
        @Query(value = "q", encoded = true) q: String = "",
        @Query(value = "lang") lang: String = "en",
        @Query(value = "id") id: String = "",
        @Query(value = "image_type") image_type: String = "all",
        @Query(value = "orientation") orientation: String = "all",
        @Query(value = "category") category: String = "",
        @Query(value = "min_width") min_width: Int = 0,
        @Query(value = "min_height") min_height: Int = 0,
        @Query(value = "colors") colors: String = "",
        @Query(value = "editors_choice") editors_choice: Boolean = false,
        @Query(value = "safesearch") safesearch: Boolean = false,
        @Query(value = "order") order: String = "popular",
        @Query(value = "page") page: Int = 1,
        @Query(value = "per_page") per_page: Int = 20,
        @Query(value = "callback") callback: String = "",
        @Query(value = "pretty") pretty: Boolean = false
    ): SearchImage?
}