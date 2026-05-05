package com.example.letssopt.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
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

@Composable
fun UpcomingContentSection(
    viewModel: MainViewModel
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "공개 예정 콘텐츠",
            fontFamily = FontFamily(Font(R.font.pretendard_semibold)),
            fontWeight = FontWeight.SemiBold,
            color = Color.White,
            fontSize = 20.sp
        )

        Text(
            text = "더보기",
            fontFamily = FontFamily(Font(R.font.pretendard_light)),
            fontWeight = FontWeight.Light,
            color = Color(0xFF999999),
            fontSize = 12.sp
        )
    }

    Spacer(modifier = Modifier.height(8.dp))

    LazyRow(
        modifier = Modifier.padding(bottom = 23.dp),
        horizontalArrangement = Arrangement.spacedBy(13.dp),
        contentPadding = PaddingValues(horizontal = 8.dp)
    ) {
        items(viewModel.getReleasedList()) { item ->
            Image(
                painter = painterResource(id = item.image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(103.dp, 153.dp)
                    .clip(RoundedCornerShape(10.dp))
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UpcomingContentSectionPreview() {

    val fakeViewModel = MainViewModel()

    Column(
        modifier = Modifier
            .background(Color.Black)
    ) {
        UpcomingContentSection(viewModel = fakeViewModel)
    }
}