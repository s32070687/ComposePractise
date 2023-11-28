package com.compose.practise.composepractise.data.repository

import com.compose.practise.composepractise.data.ApiService
import com.compose.practise.composepractise.data.model.BaseCallBackStatus
import com.compose.practise.composepractise.data.model.Image
import com.compose.practise.composepractise.di.AppModule
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ImageRepositoryImpl(
    private val apiService: ApiService = AppModule.createApiClient()
): ImageRepository {
    override fun searchImage(query: String): Flow<BaseCallBackStatus<Image>> =
        flow {
            apiService.runCatching {
                searchImage(q = query)
            }.onSuccess {
                when {
                    it?.hits?.isEmpty() == true -> emit(BaseCallBackStatus.ERROR("No Data"))
                    else -> emit(BaseCallBackStatus.SUCCESS(it as Image))
                }
            }.onFailure {
                emit(BaseCallBackStatus.ERROR(it.message))
            }
        }
}