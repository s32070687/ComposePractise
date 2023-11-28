package com.compose.practise.composepractise.ui.viewmodel

sealed class ImageViewIntent {

    data class ChangeQuery(val query: String) : ImageViewIntent()
    data class SearchImages(val query: String) : ImageViewIntent()
}
