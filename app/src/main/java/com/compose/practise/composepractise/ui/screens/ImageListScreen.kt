package com.compose.practise.composepractise.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.compose.practise.composepractise.data.model.ImageHits
import com.compose.practise.composepractise.ui.components.ItemColumComponent

@Composable
fun ImageListScreen(images: List<ImageHits>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 8.dp)
            .background(Color.White)
    ) {
        items(images) {
            ImageListItem(image = it)
        }
    }
}

@Composable
fun ImageListItem(image: ImageHits) {
    ElevatedCard(
        colors = CardDefaults.elevatedCardColors(containerColor = Color.White),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp)
            .height(150.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
        ) {

            // 圖片
            AsyncImage(
                model = image.previewURL,
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .height(140.dp)
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(6))
            )

            // 資訊區塊
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 4.dp)
            ) {

                // 圖片名稱
                Text(
                    text = image.tags ?: "",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .fillMaxWidth()
                )

                // 作者
                Text(
                    text = "User: ${image.user}",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 2.dp)
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    verticalArrangement = Arrangement.SpaceAround,
                ) {
                    ItemColumComponent(image)
                }

            }
        }
    }
}

