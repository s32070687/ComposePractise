package com.compose.practise.composepractise.data.model

sealed interface BaseCallBackStatus<T: Any> {
    data class SUCCESS<T: Any>(val data: T): BaseCallBackStatus<T>
    data class ERROR<T: Any>(val message: String?): BaseCallBackStatus<T>
}
