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
import androidx.compose.ui.unit.dp
import com.example.letssopt.R
import com.example.letssopt.presentation.main.NavItem

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
           text = "메인",
           iconRes = R.drawable.ic_bottom_bar_main_24)

        NavItem(
            text = "개별 구매",
            iconRes = R.drawable.ic_bottom_bar_purchase_24)

        NavItem(
            text = "웹툰",
            iconRes = R.drawable.ic_bottom_bar_webtoon_24)

        NavItem(
            text = "찾기",
            iconRes = R.drawable.ic_bottom_bar_search_24)

        NavItem(
            text = "보관함",
            iconRes = R.drawable.ic_bottom_bar_save_24)
    }
}