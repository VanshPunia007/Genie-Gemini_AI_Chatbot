package com.vanshpunia.genie.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vanshpunia.genie.ChatData
import com.vanshpunia.genie.ChatRoleEnum

@Composable
fun ChatList(
    list: MutableList<ChatData>
){
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(list){
            if(it.role == ChatRoleEnum.USER.role){
                Text(text = it.message,
                    modifier = Modifier.fillMaxWidth()
                        .background(color = Color.Blue)
                        .padding(8.dp),
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
            else{
                Text(text = it.message,
                    modifier = Modifier.fillMaxWidth()
                        .background(color = Color.Red)
                        .padding(8.dp),
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal
                )
            }
        }
    }
}