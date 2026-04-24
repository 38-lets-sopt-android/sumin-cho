package com.example.letssopt

import android.R.attr.bottom
import android.R.attr.top
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.letssopt.ui.theme.LETSSOPTTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LETSSOPTTheme {
                Scaffold(modifier = Modifier.fillMaxSize(),
                bottomBar = { BottomNavigationBar() })
                { innerPadding ->
                    MainScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier)
{
    val posterList = listOf(
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3,
        R.drawable.image4,
        R.drawable.image5,
        R.drawable.image6
    )
    val girlList = listOf(
        R.drawable.girl_image1,
        R.drawable.girl_image2,
        R.drawable.girl_image3,
        R.drawable.girl_image4,
        R.drawable.girl_image5,
        R.drawable.girl_image6,
        R.drawable.girl_image7,
        R.drawable.girl_image8,
        R.drawable.girl_image9,
        R.drawable.girl_image10
    )
    val manList = listOf(
        R.drawable.man_image7,
        R.drawable.man_image8,
        R.drawable.man_image9,
        R.drawable.man_image10,
        R.drawable.man_image11,
        R.drawable.man_image12,
        R.drawable.man_image1,
        R.drawable.man_image2,
        R.drawable.man_image3,
        R.drawable.man_image4,
        R.drawable.man_image5,
        R.drawable.man_image6
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 20.dp)
                .padding(top = 23.dp),
            horizontalArrangement = Arrangement.End
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_top_watch),
                contentDescription = null,
                tint = Color.Unspecified,
            )

            Spacer(modifier = Modifier.width(14.dp))

            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_top_notic),
                contentDescription = null,
                tint = Color.Unspecified,
            )

            Spacer(modifier = Modifier.width(14.dp))

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
            items(posterList) {images ->
                Image(
                    painter = painterResource(id = images),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(200.dp, 160.dp)
                        .clip(RoundedCornerShape(10.dp))
                )
            }
        }

        Icon(
            modifier = Modifier.padding(start = 16.dp),
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
            items(girlList) {images ->
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
            items(manList) {images ->
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
fun BottomNavigationBar() {
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
            Color(0xFFFFFFFF)
        )
        NavItem(
            "개별 구매",
            R.drawable.ic_bottom_bar_category_24,
            Color(0xFF333333)
        )
        NavItem("웹툰",
            R.drawable.ic_bottom_bar_wallet_24,
            Color(0xFF333333)
        )
        NavItem("찾기",
            R.drawable.ic_bottom_bar_search_24,
            Color(0xFF333333)
        )
        NavItem("보관함",
            R.drawable.ic_bottom_bar_folder_24,
            Color(0xFF333333)
        )
    }
}
@Composable
fun NavItem(text: String, iconRes: Int,textColor: Color)
    {
    Column(horizontalAlignment = Alignment.CenterHorizontally)
    {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            tint = Color.Unspecified
        )

        Spacer(modifier = Modifier.height(7.dp))

        Text(text, color = textColor, fontSize = 12.sp)
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    MaterialTheme {
        Scaffold(
            bottomBar = { BottomNavigationBar() }
        ) { padding ->
            MainScreen(modifier = Modifier.padding(padding))
        }
    }
}