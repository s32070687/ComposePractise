package com.compose.practise.composepractise.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.compose.practise.composepractise.ui.them.Purple40
import com.compose.practise.composepractise.ui.them.Purple80
import com.compose.practise.composepractise.ui.viewmodel.ImageUIState
import com.compose.practise.composepractise.ui.viewmodel.ImageViewIntent

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

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                OutlinedTextField(
                    modifier = Modifier
                        .width(300.dp),
                    value = uiState.query,
                    onValueChange = {
                        onEvent(ImageViewIntent.ChangeQuery(it))
                    },
                    label = { Text("Search") },
                    singleLine = true
                )

                IconButton(
                    onClick = {
                        onEvent(ImageViewIntent.ChangeLayoutManager(""))
                    },
                ) {
                    Icon(
                        imageVector = Icons.Default.List,
                        contentDescription = "Change Layout",
                        tint = Purple40)
                }

            }

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