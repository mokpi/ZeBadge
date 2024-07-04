package de.berlindroid.zeapp.zeui.zehome

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import de.berlindroid.zeapp.zevm.MessageUi
import de.berlindroid.zeapp.zevm.ZePassVm

@Composable
fun ZeUserProfile() {
    val viewModel: ZePassVm = hiltViewModel()

    val messages: List<MessageUi> = remember { viewModel.uiState.value.messages }

    Text(
        text = messages.joinToString("\n") {
            "${it.userName}: ${it.text}"
        },
    )
}
