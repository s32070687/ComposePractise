package com.compose.practise.composepractise.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.compose.practise.composepractise.R
import com.compose.practise.composepractise.data.model.ImageHits
import com.compose.practise.composepractise.ui.them.Color00C8FA
import com.compose.practise.composepractise.ui.them.ColorA700FA
import com.compose.practise.composepractise.ui.them.ColorFA0025

@Composable
fun ItemColumComponent(image: ImageHits) {
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