package com.vanshpunia.genie.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp

@Composable
fun ChatFooter(
    onClick: (text: String) -> Unit
) {
    var inputText by remember {
        mutableStateOf("")
    }
    val focusManager = LocalFocusManager.current
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        OutlinedTextField(
            value = inputText, onValueChange = { inputText = it },
            placeholder = { Text(text = "Enter your message") },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .weight(3f)
                .background(color = Color(0xFF000D33)),
            shape = RoundedCornerShape(16.dp)
        )

        IconButton(onClick = {
            onClick(inputText)
            inputText = ""
            focusManager.clearFocus() // Clear focus to close keyboard
        }) {

            Icon(
                Icons.AutoMirrored.Rounded.Send, contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .border(2.dp, Color.Cyan, RoundedCornerShape(16.dp))
                    .clip(CircleShape)
                    .background(color = Color(0xFF000D33))
                    .padding(8.dp), tint = Color.White
            )
        }

    }
}