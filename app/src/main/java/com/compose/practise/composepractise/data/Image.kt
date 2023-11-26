package com.compose.practise.composepractise.data

data class Image(
    val total: Int? = null,
    val totalHits: Int? = null,
    val hits: ArrayList<ImageHits>
)

data class ImageHits(
    val id: Int? = null,
    val pageURL: String? = null,
    val type: String? = null,
    val tags: String? = null,
    val previewURL: String? = null,
    val previewWidth: Int? = null,
    val previewHeight: Int? = null,
    val webformatURL: String? = null,
    val webformatWidth: Int? = null,
    val webformatHeight: Int? = null,
    val largeImageURL: String? = null,
    val fullHDURL: String? = null,
    val imageURL: String? = null,      // API文件上有但是沒有回傳該值
    val imageWidth: Int? = null,
    val imageHeight: Int? = null,
    val imageSize: Int? = null,
    val views: Int? = null,
    val downloads: Int? = null,
    val likes: Int? = null,
    val comments: Int? = null,
    val user_id: Int? = null,
    val user: String? = null,
    val userImageURL: String? = null
)
