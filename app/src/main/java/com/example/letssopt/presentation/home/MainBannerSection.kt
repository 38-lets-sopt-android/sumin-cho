package com.example.letssopt.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.letssopt.R
import com.example.letssopt.presentation.main.MainViewModel

import androidx.compose.runtime.remember

@Composable
fun MainBannerSection(
    viewModel: MainViewModel
) {
    Text(
        modifier = Modifier.padding(start = 19.dp),
        text = "방금 막 도착한 신상 컨텐츠",
        fontFamily = FontFamily(Font(R.font.pretendard_semibold)),
        fontWeight = FontWeight.SemiBold,
        color = Color.White,
        fontSize = 20.sp
    )

    Spacer(modifier = Modifier.height(4.dp))

    Text(
        modifier = Modifier.padding(start = 19.dp),
        text = "예능부터 드라마까지!",
        fontFamily = FontFamily(Font(R.font.pretendard_semibold)),
        fontWeight = FontWeight.SemiBold,
        color = Color(0xFFBABAC1),
        fontSize = 18.sp
    )

    Spacer(modifier = Modifier.height(24.dp))

    LazyRow(
        modifier = Modifier.padding(bottom = 26.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(viewModel.getMainBannerList()) { item ->
            Image(
                painter = painterResource(id = item.image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(280.dp, 160.dp)
                    .clip(RoundedCornerShape(10.dp))
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainBannerSectionPreview() {

    val fakeViewModel = remember { MainViewModel() }

    Column(
        modifier = Modifier
            .background(Color.Black)
    ) {
        MainBannerSection(viewModel = fakeViewModel)
    }
}