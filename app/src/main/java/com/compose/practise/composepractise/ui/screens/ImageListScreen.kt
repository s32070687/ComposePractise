package com.compose.practise.composepractise.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.compose.practise.composepractise.R
import com.compose.practise.composepractise.data.model.ImageHits
import com.compose.practise.composepractise.ui.them.Color00C8FA
import com.compose.practise.composepractise.ui.them.ColorA700FA
import com.compose.practise.composepractise.ui.them.ColorFA0025

@Composable
fun ImageListScreen(images: List<ImageHits>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
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
                    .width(140.dp)
                    .clip(RoundedCornerShape(50))
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
                    // 觀看數
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_remove_red_eye_24),
                            contentDescription = null,
                            tint = Color00C8FA,
                        )

                        Text(
                            modifier = Modifier.padding(start = 4.dp),
                            text = image.views.toString(),
                            fontSize = 14.sp
                        )
                    }

                    // 點讚數
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_favorite_24),
                            contentDescription = null,
                            tint = ColorFA0025,
                        )

                        Text(
                            modifier = Modifier.padding(start = 4.dp),
                            text = image.likes.toString(),
                            fontSize = 14.sp
                        )
                    }

                    // 下載數
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_download_24),
                            contentDescription = null,
                            tint = ColorA700FA,
                        )

                        Text(
                            modifier = Modifier.padding(start = 4.dp),
                            text = image.downloads.toString(),
                            fontSize = 14.sp
                        )
                    }
                }

            }
        }
    }
}
