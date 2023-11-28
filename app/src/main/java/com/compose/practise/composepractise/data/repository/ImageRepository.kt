package com.compose.practise.composepractise.data.repository

import com.compose.practise.composepractise.data.model.BaseCallBackStatus
import com.compose.practise.composepractise.data.model.Image
import kotlinx.coroutines.flow.Flow

interface ImageRepository {
    fun searchImage(query: String): Flow<BaseCallBackStatus<Image>>
}