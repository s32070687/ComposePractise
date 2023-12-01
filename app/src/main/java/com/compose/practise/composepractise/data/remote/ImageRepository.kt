package com.compose.practise.composepractise.data.remote

import com.compose.practise.composepractise.data.model.BaseCallBackStatus
import com.compose.practise.composepractise.data.model.SearchImage
import kotlinx.coroutines.flow.Flow

interface ImageRepository {
    fun searchImage(query: String): Flow<BaseCallBackStatus<SearchImage>>
}