package com.compose.practise.composepractise.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import com.compose.practise.composepractise.data.ImageHits

class ImageViewModel(
    pager: Pager<Int, ImageHits>
) : ViewModel() {

//    val imagePagingFlow = pager
//        .flow
//        .map { pagingData ->
//            pagingData.map { it }
//        }
}