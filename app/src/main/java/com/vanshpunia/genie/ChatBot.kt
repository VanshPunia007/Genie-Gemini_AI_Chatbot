package com.vanshpunia.genie

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.vanshpunia.genie.components.ChatFooter
import com.vanshpunia.genie.components.ChatHeader
import androidx.lifecycle.viewmodel.compose.viewModel
@Composable
fun ChatBot(
    viewModel: ChatBotVM = viewModel()
){
    Column{
        ChatHeader()

        ChatFooter {
            if(it.isNotEmpty()){
                viewModel.sendMessage(it)
            }
        }
    }
}