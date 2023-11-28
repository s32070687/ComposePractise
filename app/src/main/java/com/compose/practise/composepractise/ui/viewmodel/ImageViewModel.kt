package com.compose.practise.composepractise.ui.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.practise.composepractise.data.model.BaseCallBackStatus
import com.compose.practise.composepractise.data.repository.ImageRepository
import kotlinx.coroutines.launch

class ImageViewModel(
    private val imageRepositoryImpl: ImageRepository
) : ViewModel() {
    var uiState by mutableStateOf(ImageUIState())
        private set

    fun processIntent(intent: ImageViewIntent) {
        when(intent) {
            is ImageViewIntent.ChangeQuery -> changeQuery(intent.query)

            is ImageViewIntent.SearchImages -> searchImage(intent.query)
        }
    }

    private fun changeQuery(query: String) {
        uiState = uiState.copy(query = query)
    }

    private fun searchImage(query: String) {
        viewModelScope.launch {
            uiState = uiState.copy(isLoading = true)
            try {
                imageRepositoryImpl.searchImage(query).collect {
                    when(it) {
                        is BaseCallBackStatus.SUCCESS -> {
                            uiState = uiState.copy(isLoading = false)
                            Log.e("Jason","$it it")
                        }
                        is BaseCallBackStatus.ERROR -> {
                            uiState = uiState.copy(isLoading = false)
                            Log.e("Jason","$it it")
                        }

                    }
                }
            } catch (e: Exception) {
                Log.e("Jason","$e e")
            }
        }
    }
}

data class ImageUIState(
    val isLoading: Boolean = false,

    val query: String = ""
)