package com.compose.practise.composepractise.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.compose.practise.composepractise.data.repository.ImageRepositoryImpl
import com.compose.practise.composepractise.ui.viewmodel.ImageUIState
import com.compose.practise.composepractise.ui.viewmodel.ImageViewIntent
import com.compose.practise.composepractise.ui.viewmodel.ImageViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImageScreen(
    uiState: ImageUIState,
    onEvent: (ImageViewIntent) -> Unit
) {

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(8.dp)
                .fillMaxWidth()
        ) {

            Text(
                text = "Pixabay Image Finder",
                fontFamily = FontFamily.Cursive,
                fontSize = 32.sp
            )

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = uiState.query,
                onValueChange = {
                    onEvent(ImageViewIntent.ChangeQuery(it))
                },
                label = { Text("Search") },
                singleLine = true
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DialogPreview() {
    ImageScreen(
        uiState = ImageUIState(),
        onEvent = {}
    )
}