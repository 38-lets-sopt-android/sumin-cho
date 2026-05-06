package com.example.letssopt.presentation.home

import android.R.attr.height
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

@Composable
fun WatchaParty(modifier: Modifier = Modifier)
{
    val images = listOf(
        R.drawable.img_watchaparty_1,
        R.drawable.img_watchaparty_2,
        R.drawable.img_watchaparty_3,
        R.drawable.img_watchaparty_4,
        R.drawable.img_watchaparty_5
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.Black)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "공개 예정 콘텐츠",
                fontFamily = FontFamily(Font(R.font.pretendard_regular)),
                fontWeight = FontWeight.Normal,
                color = Color.White,
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

        Spacer(modifier = Modifier.height(8.dp))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 8.dp)
        ) {
            items(images) { imageRes ->
                Box(
                    modifier = Modifier
                        .size(width = 196.dp, height = 185.dp)
                        .background(Color(0xFF2A2A2A))
                ) {
                    Image(
                        painter = painterResource(id = imageRes),
                        contentDescription = null,
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .padding(bottom = 47.dp)
                    )
                }
            }
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
    partyImageItem(
        image= R.drawable.img_watchaparty_1
    )
}