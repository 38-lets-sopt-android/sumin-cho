package com.example.letssopt.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.letssopt.presentation.home.component.MainBannerSection
import com.example.letssopt.presentation.home.component.RecommendationSection
import com.example.letssopt.presentation.home.component.TopBar
import com.example.letssopt.presentation.home.component.UpcomingContentSection
import com.example.letssopt.presentation.home.component.WatchaPartySection
import kotlinx.serialization.Serializable

@Serializable
data object Home

@Composable
fun HomeRoute(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(),
){
    HomeScreen(
        viewModel = viewModel,
        modifier = modifier
    )
}

@Composable
private fun HomeScreen(
    viewModel: HomeViewModel,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
        ) {
            TopBar()

            Spacer(modifier = Modifier.height(24.dp))

            MainBannerSection(viewModel = viewModel)
            RecommendationSection(viewModel = viewModel)
            UpcomingContentSection(viewModel = viewModel)
            WatchaPartySection(viewModel = viewModel)
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun HomeScreenPreview() {
//    HomeScreen()
//}