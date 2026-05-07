package com.example.letssopt.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.letssopt.R
import com.example.letssopt.presentation.main.MainViewModel

//@Composable
//            fun HomeScreen(modifier: Modifier = Modifier) {
//
//                val viewModel: MainViewModel = viewModel()
//
//                Column(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .background(Color.Black)
//                        .verticalScroll(rememberScrollState())
//                ) {
//                    Row(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(end = 20.dp)
//                            .padding(vertical = 23.dp),
//                        horizontalArrangement = Arrangement.spacedBy(14.dp, Alignment.End)
//                    ) {
//                        Icon(
//                            imageVector = ImageVector.vectorResource(R.drawable.ic_top_watch),
//                            contentDescription = null,
//                            tint = Color.Unspecified,
//                        )
//
//                        Icon(
//                imageVector = ImageVector.vectorResource(R.drawable.ic_top_notic),
//                contentDescription = null,
//                tint = Color.Unspecified,
//            )
//
//            Icon(
//                imageVector = ImageVector.vectorResource(R.drawable.ic_top_profile),
//                contentDescription = null,
//                tint = Color.Unspecified,
//            )
//        }
//
//        Spacer(modifier = Modifier.height(47.dp))
//
//        Text(
//            modifier = Modifier.padding(start = 19.dp),
//            text = "방금 막 도착한 신상 컨텐츠",
//            fontFamily = FontFamily(Font(R.font.pretendard_semibold)),
//            fontWeight = FontWeight.SemiBold,
//            color = Color.White,
//            fontSize = 20.sp
//        )
//
//        Spacer(modifier = Modifier.height(4.dp))
//
//        Text(
//            modifier = Modifier.padding(start = 19.dp),
//            text = "예능부터 드라마까지!",
//            fontFamily = FontFamily(Font(R.font.pretendard_semibold)),
//            fontWeight = FontWeight.SemiBold,
//            color = Color(0xFFBABAC1),
//            fontSize = 18.sp
//        )
//
//        Spacer(modifier = Modifier.height(24.dp))
//
//        LazyRow(
//            modifier = Modifier.padding(bottom = 26.dp),
//            horizontalArrangement = Arrangement.spacedBy (16.dp)
//        ){
//            items(viewModel.getMainBannerList()) { item ->
//                Image(
//                    painter = painterResource(id = item.image),
//                    contentDescription = null,
//                    contentScale = ContentScale.Crop,
//                    modifier = Modifier
//                        .size(280.dp, 160.dp)
//                        .clip(RoundedCornerShape(10.dp))
//                )
//            }
//        }
//
//        Icon(
//            modifier = Modifier
//                .padding(start = 16.dp)
//                .size(width = 80.dp, height = 26.dp),
//            imageVector = ImageVector.vectorResource(R.drawable.ic_mid_title),
//            contentDescription = null,
//            tint = Color.Unspecified,
//        )
//
//        Spacer(modifier = Modifier.height(4.dp))
//
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(horizontal = 16.dp),
//            horizontalArrangement = Arrangement.SpaceBetween
//        )
//        {
//            Text(
//                text = "예능부터 드라마까지!",
//                fontFamily = FontFamily(Font(R.font.pretendard_semibold)),
//                fontWeight = FontWeight.SemiBold,
//                color = Color(0xFFBABAC1),
//                fontSize = 20.sp
//            )
//
//            Text(
//                text = "더보기",
//                fontFamily = FontFamily(Font(R.font.pretendard_light)),
//                fontWeight = FontWeight.Light,
//                color = Color(0xFF999999),
//                fontSize = 12.sp
//            )
//        }
//        Spacer(modifier = Modifier.height(6.dp))
//
//        LazyRow(
//            modifier = Modifier.padding(bottom = 23.dp),
//            horizontalArrangement = Arrangement.spacedBy (13.dp),
//            contentPadding = PaddingValues(horizontal = 8.dp)
//        )
//        {
//            items(viewModel.getWhatgorithmeList()) { item ->
//                Image(
//                    painter = painterResource(id = item.image),
//                    contentDescription = null,
//                    contentScale = ContentScale.Crop,
//                    modifier = Modifier
//                        .size(103.dp, 153.dp)
//                        .clip(RoundedCornerShape(10.dp))
//                )
//            }
//        }
//
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(horizontal = 16.dp),
//            horizontalArrangement = Arrangement.SpaceBetween
//        )
//        {
//            Text(
//                text = "공개 예정 콘텐츠",
//                fontFamily = FontFamily(Font(R.font.pretendard_semibold)),
//                fontWeight = FontWeight.SemiBold,
//                color = Color.White,
//                fontSize = 20.sp
//            )
//
//            Text(
//                text = "더보기",
//                fontFamily = FontFamily(Font(R.font.pretendard_light)),
//                fontWeight = FontWeight.Light,
//                color = Color(0xFF999999),
//                fontSize = 12.sp
//            )
//        }
//
//        Spacer(modifier = Modifier.height(8.dp))
//
//        LazyRow(
//            modifier = Modifier.padding(bottom = 23.dp),
//            horizontalArrangement = Arrangement.spacedBy (13.dp),
//            contentPadding = PaddingValues(horizontal = 8.dp)
//        )
//        {
//            items(viewModel.getReleasedList()) {item ->
//                Image(
//                    painter = painterResource(id = item.image),
//                    contentDescription = null,
//                    contentScale = ContentScale.Crop,
//                    modifier = Modifier
//                        .size(103.dp, 153.dp)
//                        .clip(RoundedCornerShape(10.dp))
//                )
//            }
//        }
//    }
//}

@Composable
fun HomeScreen(){

    val viewModel = remember { MainViewModel() }

    Column(
        modifier = Modifier
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

        BottomNavigationBar()
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}