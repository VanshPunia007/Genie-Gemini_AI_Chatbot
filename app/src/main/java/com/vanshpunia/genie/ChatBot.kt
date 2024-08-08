package com.vanshpunia.genie

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.vanshpunia.genie.components.ChatFooter
import com.vanshpunia.genie.components.ChatHeader
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vanshpunia.genie.components.ChatList

@Composable
fun ChatBot(
    viewModel: ChatBotVM = viewModel()
){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ){
        ChatHeader()
        
        Box(
            modifier = Modifier
                .weight(1f)
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            if(viewModel.list.isEmpty()){
                Image(painter = painterResource(id = R.drawable.logo5), contentDescription = null)
            }else{
                ChatList(list = viewModel.list)
            }
        }
        
        ChatFooter {
            if(it.isNotEmpty()){
                viewModel.sendMessage(it)
            }
        }
    }
}