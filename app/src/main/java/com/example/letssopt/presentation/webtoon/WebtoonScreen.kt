package com.example.letssopt.presentation.webtoon

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.serialization.Serializable

@Serializable
data object Webtoon

@Composable
fun WebtoonRoute(
    paddingValues: PaddingValues
) {
    WebtoonScreen(modifier = Modifier.padding(paddingValues))
}

@Composable
private fun WebtoonScreen(
    modifier: Modifier = Modifier
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "웹툰",
            color = Color.White
        )
    }
}

//@Preview(showBackground = true)
//@Composable
//fun WebtoonScreenPreview() {
//    WebtoonScreen()
//}