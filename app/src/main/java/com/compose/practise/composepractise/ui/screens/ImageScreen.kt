package com.compose.practise.composepractise.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.compose.practise.composepractise.R
import com.compose.practise.composepractise.data.model.SearchImage
import com.compose.practise.composepractise.data.model.ImageHits
import com.compose.practise.composepractise.ui.components.LoadingComponent
import com.compose.practise.composepractise.ui.them.Purple40
import com.compose.practise.composepractise.ui.viewmodel.ImageUIState
import com.compose.practise.composepractise.ui.viewmodel.ImageViewIntent
import com.compose.practise.composepractise.ui.viewmodel.LayoutManagerType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImageScreen(
    uiState: ImageUIState,
    data: SearchImage,
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

            if (uiState.isLoading) {
                LoadingComponent()
            }

            Text(
                text = "Pixabay Image Finder",
                fontFamily = FontFamily.Cursive,
                fontSize = 32.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            val layoutStatus = uiState.layoutManagerStatus

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                OutlinedTextField(
                    modifier = Modifier
                        .weight(1f),
                    value = uiState.query,
                    onValueChange = {
                        onEvent(ImageViewIntent.ChangeQuery(it))
                    },
                    singleLine = true,
                    placeholder = {
                        Text(text = "Search")
                    },
                    trailingIcon = {
                        IconButton(
                            onClick = {
                                if (uiState.query.isNotBlank()) {
                                    onEvent(ImageViewIntent.SearchImages(uiState.query))
                                } else {
//                                    errorMessage = "Enter a query first"
                                }
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Search",
                                tint = Purple40
                            )
                        }
                    }
                )

                IconButton(
                    onClick = {
                        onEvent(
                            ImageViewIntent.ChangeLayoutManager(
                                if (layoutStatus == LayoutManagerType.GRID)
                                    LayoutManagerType.LIST
                                else
                                    LayoutManagerType.GRID
                            )
                        )
                    },
                ) {
                    if (layoutStatus == LayoutManagerType.GRID) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_grid_view_24),
                            contentDescription = "Grid",
                            tint = Purple40
                        )
                    } else {
                        Icon(
                            imageVector = Icons.Default.List,
                            contentDescription = "List",
                            tint = Purple40
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Log.e("Jason", "data: ${data.hits.size} size")
            if (layoutStatus == LayoutManagerType.GRID) {
                ImageGridScreen()
            } else {
                ImageListScreen(data.hits)
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DialogPreview() {
    ImageScreen(
        uiState = ImageUIState(),
        data = fakeData(),
        onEvent = {}
    )
}

fun fakeData(): SearchImage {
    val data = SearchImage(
        total = 10,
        totalHits = 10,
        hits = List(10) {
            ImageHits(
                id = it + 1,
                pageURL = "https://example.com/page$it",
                type = "Type$it",
                tags = "Tag$it",
                previewURL = "https://example.com/preview$it.jpg",
                previewWidth = 200,
                previewHeight = 150,
                webformatURL = "https://example.com/webformat$it.jpg",
                webformatWidth = 800,
                webformatHeight = 600,
                largeImageURL = "https://example.com/large$it.jpg",
                fullHDURL = "https://example.com/fullhd$it.jpg",
                imageURL = "https://example.com/image$it.jpg",
                imageWidth = 1200,
                imageHeight = 900,
                imageSize = 1024,
                views = 100 * it,
                downloads = 50 * it,
                likes = 30 * it,
                comments = 10 * it,
                user_id = it + 100,
                user = "User$it",
                userImageURL = "https://example.com/user$it.jpg"
            )
        }
    )

    return data
}
