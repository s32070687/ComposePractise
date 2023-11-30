package com.compose.practise.composepractise.ui.viewmodel

sealed class ImageViewIntent {

    data class ChangeQuery(val query: String) : ImageViewIntent()

    data class ChangeLayoutManager(val layoutManager: LayoutManagerType) : ImageViewIntent()

    data class SearchImages(val query: String) : ImageViewIntent()

    object DismissDialog : ImageViewIntent()
}

enum class LayoutManagerType {
    GRID,
    LIST
}