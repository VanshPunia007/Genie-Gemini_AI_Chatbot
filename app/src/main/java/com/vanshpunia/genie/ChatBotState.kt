package com.vanshpunia.genie

sealed class ChatBotUiState{
    data object Ideal: ChatBotUiState()
    data object Loading: ChatBotUiState()
    data class Error(val chatError: String): ChatBotUiState()
    data class Success(val chatData: String): ChatBotUiState()
}