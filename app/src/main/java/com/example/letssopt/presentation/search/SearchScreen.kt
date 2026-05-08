package com.example.letssopt.presentation.search

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
import androidx.compose.ui.unit.dp
import com.example.letssopt.presentation.home.HomeViewModel
import kotlinx.serialization.Serializable

@Serializable
data object Search

@Composable
fun SearchRoute(
    paddingValues: PaddingValues
) {
    SearchScreen(modifier = Modifier.padding(paddingValues))
}
@Composable
private fun SearchScreen(
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
            text = "찾기",
            color = Color.White
        )
    }
}

//@Preview(showBackground = true)
//@Composable
//fun SearchScreenPreview() {
//    SearchRoute(paddingValues = PaddingValues(0.dp))
//}