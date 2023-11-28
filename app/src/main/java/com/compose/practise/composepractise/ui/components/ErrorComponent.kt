package com.compose.practise.composepractise.ui.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.DialogProperties
import com.compose.practise.composepractise.ui.them.Purple80

@Composable
fun ErrorComponent(
    message: String,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    AlertDialog(
        containerColor = Color.White,
        properties = DialogProperties(),
        text = {
            Text(text = message)
        },
        onDismissRequest = { onDismiss() },
        confirmButton = {
            TextButton(
                onClick = { onConfirm() }
            ) {
                Text(
                    text = "OK",
                    color = Purple80
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DialogPreview() {
    ErrorComponent(
        message = "大長粗硬久鈴薯",
        onDismiss = {},
        onConfirm = {}
    )
}