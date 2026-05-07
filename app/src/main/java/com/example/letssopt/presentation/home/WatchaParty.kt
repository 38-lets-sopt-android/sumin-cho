package com.example.letssopt.presentation.home

import android.R.attr.height
import android.R.attr.text
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
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
import com.example.letssopt.R
import com.example.letssopt.presentation.main.MainViewModel

import androidx.compose.runtime.remember
@Composable
fun WatchaPartySection(
    viewModel: MainViewModel
) {
    val watchaPartyList = viewModel.getWatchaPartyList()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF141414))
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "왓챠 파티",
                fontFamily = FontFamily(Font(R.font.pretendard_regular)),
                fontWeight = FontWeight.Normal,
                color = Color(0xFFFFFFFF),
                fontSize = 20.sp
            )

            Text(
                text = "더보기",
                fontFamily = FontFamily(Font(R.font.pretendard_regular)),
                fontWeight = FontWeight.Normal,
                color = Color(0xFF999999),
                fontSize = 12.sp
            )
        }

        Spacer(modifier = Modifier.height(7.dp))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 8.dp)
        ) {

            items(viewModel.getWatchaPartyList()) { item ->

                partyItem(
                    image = item.image,
                    startTime = item.startTime,
                    tag = item.tag
                )
            }
        }
    }
}

@Composable
fun partyItem(
    @DrawableRes image: Int,
    startTime: String,
    tag: String
) {

    Box(
        modifier = Modifier
            .size(width = 200.dp, height = 190.dp)
            .background(Color.Black)
    ) {

        Column {

            partyImageItem(image)

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = startTime,
                modifier = Modifier.padding(start = 8.dp),
                color = Color(0xFFE8003C),
                fontSize = 12.sp
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = tag,
                modifier = Modifier.padding(start = 8.dp),
                color = Color.White,
                fontSize = 12.sp
            )
        }
    }
}
@Composable
fun partyImageItem(
    @DrawableRes image: Int
) {
    Box(
        modifier = Modifier.size(height = 140.dp,width = 200.dp)
    ){
        Image(
            painter = painterResource(id=image),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
    )

        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_watchaparty_ring),
            contentDescription = null,
            modifier = Modifier
                .size(35.dp)
                .padding(horizontal = 5.dp,vertical = 7.dp)
                .align (Alignment.TopEnd),
            tint = Color.Unspecified
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun WatchaPartyPreview() {

    val mainViewModel = remember { MainViewModel() }

    WatchaPartySection(
        viewModel = mainViewModel
    )
}