package com.compose.practise.composepractise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.compose.practise.composepractise.data.repository.ImageRepositoryImpl
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
            ComposePractiseTheme {
                ImageScreen(
                    uiState = uiState,
                    onEvent = viewModel::processIntent)
            }
        }
    }
}
