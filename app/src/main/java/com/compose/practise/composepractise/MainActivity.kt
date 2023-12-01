package com.compose.practise.composepractise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.compose.practise.composepractise.data.remote.ImageRepositoryImpl
import com.compose.practise.composepractise.ui.screens.ImageScreen
import com.compose.practise.composepractise.ui.them.ComposePractiseTheme
import com.compose.practise.composepractise.ui.viewmodel.ImageViewModel

class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<ImageViewModel> {
        viewModelFactory {
            initializer {
                ImageViewModel(
                    ImageRepositoryImpl()
                )
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val uiState = viewModel.uiState
            val data = viewModel.data

            ComposePractiseTheme {
                ImageScreen(
                    uiState = uiState,
                    data = data,
                    onEvent = viewModel::processIntent)
            }
        }
    }
}
