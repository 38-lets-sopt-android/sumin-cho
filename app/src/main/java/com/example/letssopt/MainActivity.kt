package com.example.letssopt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.letssopt.ui.theme.LETSSOPTTheme
import androidx.lifecycle.viewmodel.compose.viewModel
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LETSSOPTTheme {

                var selectedTab by remember { mutableStateOf(0) }

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = Color.Black,
                    bottomBar = {
                        BottomNavigationBar(
                            selectedTab = selectedTab,
                            onTabSelected = { selectedTab = it }
                        )
                    }
                ) { innerPadding ->

                    when (selectedTab) {
                        0 -> MainScreen(modifier = Modifier.padding(innerPadding))
                        1 -> CategoryScreen(innerPadding)
                        2 -> WebtoonScreen(innerPadding)
                        3 -> SearchScreen(innerPadding)
                        4 -> SaveScreen(innerPadding)
                    }
                }
            }
        }
    }
}

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = viewModel()
)
{
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 20.dp)
                .padding(vertical = 23.dp),
            horizontalArrangement = Arrangement.spacedBy(14.dp, Alignment.End)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_top_watch),
                contentDescription = null,
                tint = Color.Unspecified,
            )

            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_top_notic),
                contentDescription = null,
                tint = Color.Unspecified,
            )

            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_top_profile),
                contentDescription = null,
                tint = Color.Unspecified,
            )
        }

        Spacer(modifier = Modifier.height(47.dp))

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
            horizontalArrangement = Arrangement.spacedBy (16.dp)
        ){
            items(viewModel.mainbannerList) { images ->
                Image(
                    painter = painterResource(id = images),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(280.dp, 160.dp)
                        .clip(RoundedCornerShape(10.dp))
                )
            }
        }

        Icon(
            modifier = Modifier
                .padding(start = 16.dp)
                .size(width = 80.dp, height = 26.dp),
            imageVector = ImageVector.vectorResource(R.drawable.ic_mid_title),
            contentDescription = null,
            tint = Color.Unspecified,
        )

        Spacer(modifier = Modifier.height(4.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        )
        {
            Text(
            text = "예능부터 드라마까지!",
            fontFamily = FontFamily(Font(R.font.pretendard_semibold)),
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFFBABAC1),
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
        Spacer(modifier = Modifier.height(6.dp))

        LazyRow(
            modifier = Modifier.padding(bottom = 23.dp),
            horizontalArrangement = Arrangement.spacedBy (13.dp),
            contentPadding = PaddingValues(horizontal = 8.dp)
        )
        {
            items(viewModel.whatgorithmeList) { images ->
                Image(
                    painter = painterResource(id = images),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(103.dp, 153.dp)
                        .clip(RoundedCornerShape(10.dp))
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        )
        {
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
            horizontalArrangement = Arrangement.spacedBy (13.dp),
            contentPadding = PaddingValues(horizontal = 8.dp)
        )
        {
            items(viewModel.releasedList) {images ->
                Image(
                    painter = painterResource(id = images),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(103.dp, 153.dp)
                        .clip(RoundedCornerShape(10.dp))
                )
            }
        }
            }
        }
@Composable
fun CategoryScreen(padding : PaddingValues) {
    Text(
        text = "개별 구매",
        color = Color.White,
        modifier = Modifier.padding(padding)
    )
}

@Composable
fun WebtoonScreen(padding: PaddingValues) {
    Text(
        text = "웹툰",
        color = Color.White,
        modifier = Modifier.padding(padding)
    )
}

@Composable
fun SearchScreen(padding: PaddingValues) {
    Text(
        text = "찾기",
        color = Color.White,
        modifier = Modifier.padding(padding)
    )
}

@Composable
fun SaveScreen(padding: PaddingValues) {
    Text(
        text = "보관함",
        color = Color.White,
        modifier = Modifier.padding(padding)
    )
}
@Composable
fun BottomNavigationBar(
    selectedTab: Int,
    onTabSelected: (Int) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .padding(vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        NavItem(
            "메인",
            R.drawable.ic_bottom_bar_main_24,
            selectedTab == 0
        ) { onTabSelected(0) }

        NavItem(
            "개별 구매",
            R.drawable.ic_bottom_bar_category_24,
            selectedTab == 1
        ) { onTabSelected(1) }

        NavItem(
            "웹툰",
            R.drawable.ic_bottom_bar_wallet_24,
            selectedTab == 2
        ) { onTabSelected(2) }

        NavItem(
            "찾기",
            R.drawable.ic_bottom_bar_search_24,
            selectedTab == 3
        ) { onTabSelected(3) }

        NavItem(
            "보관함",
            R.drawable.ic_bottom_bar_folder_24,
            selectedTab == 4
        ) { onTabSelected(4) }
    }
}
@Composable
fun NavItem(
    text: String,
    iconRes: Int,
    isSelected: Boolean,
    onClick:() -> Unit)
    {
    Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.clickable { onClick() })
    {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            tint = if (isSelected) Color.White else Color(0xFF333333)
        )

        Spacer(modifier = Modifier.height(7.dp))

        Text(
            text,
            color = if (isSelected) Color.White
                    else Color(0xFF333333),
            fontSize = 12.sp)
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    MaterialTheme {
        Scaffold(
            bottomBar = { BottomNavigationBar( selectedTab = 0,
                onTabSelected = {}) }
        ) { padding ->
            MainScreen(modifier = Modifier.padding(padding))
        }
    }
}