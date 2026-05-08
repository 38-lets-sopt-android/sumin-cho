package com.example.letssopt.presentation.home

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.letssopt.R

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.sp

@Composable
fun BottomNavigationBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .padding(top = 15.dp, bottom = 12.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        NavItem(
           text = "메인",
           iconRes = R.drawable.ic_bottom_bar_main_24
        )

        NavItem(
            text = "개별 구매",
            iconRes = R.drawable.ic_bottom_bar_purchase_24
        )

        NavItem(
            text = "웹툰",
            iconRes = R.drawable.ic_bottom_bar_webtoon_24
        )

        NavItem(
            text = "찾기",
            iconRes = R.drawable.ic_bottom_bar_search_24
        )

        NavItem(
            text = "보관함",
            iconRes = R.drawable.ic_bottom_bar_save_24
        )
    }
}

@Composable
fun NavItem(
    text: String,
    iconRes: Int,
    isSelected: Boolean = false,
    onClick: () -> Unit = {}
) {

    Column(
        modifier = Modifier.clickable {
            onClick()
        },

        horizontalAlignment =
            Alignment.CenterHorizontally
    ) {

        Icon(
            imageVector =
                ImageVector.vectorResource(iconRes),

            contentDescription = text,

            tint =
                if (isSelected)
                    Color.White
                else
                    Color(0xFF333333)
        )

        Text(
            text = text,

            color =
                if (isSelected)
                    Color.White
                else
                    Color(0xFF333333),

            fontSize = 12.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPreview() {
    BottomNavigationBar()
}