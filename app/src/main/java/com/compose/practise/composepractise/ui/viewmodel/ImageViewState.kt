package com.compose.practise.composepractise.ui.viewmodel

import com.compose.practise.composepractise.data.ImageHits

sealed class ImageViewState {
    object Loading: ImageViewState()

    data class Success(val image: List<ImageHits>): ImageViewState()

    data class Error(val message: String): ImageViewState()
}
