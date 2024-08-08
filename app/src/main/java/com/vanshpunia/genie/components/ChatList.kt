package com.vanshpunia.genie.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vanshpunia.genie.ChatData
import com.vanshpunia.genie.ChatRoleEnum

@Composable
fun ChatList(
    list: MutableList<ChatData>
){

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(list) { item ->
            if (item.role == ChatRoleEnum.USER.role) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Spacer(modifier = Modifier.weight(1f)) // Occupy available space

                    Text(text = item.message,
                        modifier = Modifier
                            .wrapContentWidth(Alignment.End)
                            .drawBehind {
                                val strokeWidth = 2.dp.toPx()
                                val cornerRadius = 16.dp.toPx()
                                drawRoundRect(
                                    color = Color(0xFF80DEEA),
                                    style = Stroke(strokeWidth),
                                    cornerRadius = CornerRadius(cornerRadius)
                                )
                            }
                            .padding(8.dp),
                        color = Color(0xFFFFFFFF),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            } else {
                Text(
                    text = item.message,
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .background(color = Color(0xFF81D4FA))
                        .padding(8.dp)
                        .wrapContentWidth(Alignment.Start), // Align to left
                    color = Color(0xFF00134B),
                    fontSize = 16.sp
                )
            }
            Spacer(modifier = Modifier.height(8.dp)) // Add space after each item
        }
    }
}