package com.example.letssopt.presentation.main

import android.media.Image
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
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
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.letssopt.R
import com.example.letssopt.presentation.home.HomeScreen
import com.example.letssopt.presentation.home.TopBar
import com.example.letssopt.presentation.login.AUTO_LOGIN
import com.example.letssopt.presentation.login.LoginScreen
import com.example.letssopt.presentation.login.USER_ID_KEY
import com.example.letssopt.presentation.login.USER_PW_KEY
import com.example.letssopt.presentation.signup.SignUpScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LETSSOPTTheme {

                val navController = rememberNavController()
                var selectedTab by remember { mutableStateOf("main") }

                Scaffold(
                    bottomBar = {
                        BottomNavigationBar(
                            navController = navController,
                            selectedTab = selectedTab,
                            onTabSelected = { selectedTab = it }
                        )
                    }
                ) { padding ->

                    NavHost(
                        navController = navController,
                        startDestination = "login",
                        modifier = Modifier.padding(padding)
                    ) {

                        composable("login") {
                            val context = LocalContext.current
                            val pref =
                                context.getSharedPreferences("login_prefs", MODE_PRIVATE)

                            LoginScreen(
                                onSignUpClick = {
                                    navController.navigate("signup")
                                },
                                onLoginClick = { inputId, inputPw ->

                                    val savedId = pref.getString(USER_ID_KEY, null)
                                    val savedPw = pref.getString(USER_PW_KEY, null)

                                    when {
                                        savedId == null || savedPw == null -> {
                                            Toast.makeText(
                                                context,
                                                "회원가입을 먼저 해주세요",
                                                Toast.LENGTH_SHORT
                                            )
                                                .show()
                                        }

                                        inputId == savedId && inputPw == savedPw -> {
                                            pref.edit()
                                                .putBoolean(AUTO_LOGIN, true)
                                                .apply()

                                            Toast.makeText(
                                                context,
                                                "로그인에 성공했습니다",
                                                Toast.LENGTH_SHORT
                                            )
                                                .show()

                                            navController.navigate("main") {
                                                popUpTo("login") { inclusive = true }
                                            }
                                        }

                                        else -> {
                                            Toast.makeText(context, "다시 입력해주세요", Toast.LENGTH_SHORT)
                                                .show()
                                        }
                                    }
                                }
                            )
                        }

                        composable("signup") {
                            SignUpScreen(
                                onSignUpComplete = { _, _ ->
                                    navController.navigate("main")
                                }
                            )
                        }

                        composable("main") {
                                HomeScreen()
                            }
                        composable("category") { CategoryScreen(PaddingValues(0.dp)) }

                        composable("webtoon") { WebtoonScreen(PaddingValues(0.dp)) }

                        composable("search") { SearchScreen(PaddingValues(0.dp)) }

                        composable("save") { SaveScreen(PaddingValues(0.dp)) }
                        }
                    }
                }
            }
        }
    }
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

    val viewModel: MainViewModel = viewModel()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .verticalScroll(rememberScrollState())
    ) {
        TopBar()
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
            items(viewModel.getWhatgorithmeList()) { item ->
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
            items(viewModel.getReleasedList()) {item ->
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
    navController: NavHostController,
    selectedTab: String,
    onTabSelected: (String) -> Unit,
)
{
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp),
        horizontalArrangement = Arrangement.spacedBy(43.dp)
    ) {
        NavItem(
            text = "메인",
            iconRes = R.drawable.ic_bottom_bar_main_24,
            isSelected = selectedTab == "main",
            onClick = {
                onTabSelected("main")
                navController.navigate("main")
            }
        )

        NavItem(
            text="개별구매",
            iconRes = R.drawable.ic_bottom_bar_purchase_24,
            isSelected = selectedTab == "purchase",
            onClick = {
                onTabSelected("purchase")
                navController.navigate("purchase")
            }
        )

        NavItem(
            text = "웹툰",
            iconRes = R.drawable.ic_bottom_bar_webtoon_24,
            isSelected = selectedTab == "webtoon",
            onClick = {
                onTabSelected("webtoon")
                navController.navigate("webtoon")
            }
        )

        NavItem(
            text = "찾기",
            iconRes = R.drawable.ic_bottom_bar_search_24,
            isSelected = selectedTab == "search",
            onClick = {
                onTabSelected("search")
                navController.navigate("search")}
        )

        NavItem(
            text = "보관함",
            iconRes = R.drawable.ic_bottom_bar_save_24,
            isSelected = selectedTab == "save",
            onClick = {
                onTabSelected("save")
                navController.navigate("save")
            }
        )
    }
}
@Composable
fun NavItem(
    text: String,
    @DrawableRes iconRes: Int,
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
    onClick:() -> Unit = {}
)
    {
    Column(
        modifier = modifier.clickable { onClick() },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(7.dp)
            )
    {
        Icon(
            //painter = painterResource(id = iconRes),
            imageVector = ImageVector.vectorResource(id = iconRes),
            contentDescription = null,
            tint = if (isSelected) Color.White else Color(0xFF333333)
        )

        Text(
            text = text,
            color = if (isSelected) Color.White
                    else Color(0xFF333333),
            fontSize = 12.sp
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    MaterialTheme {
        Scaffold(
            bottomBar = {
                BottomNavigationBar(
                    navController = rememberNavController(),
                    selectedTab = "main",
                    onTabSelected = {}
                )
            }
        ) { padding ->
            HomeScreen(modifier = Modifier.padding(padding))
        }
    }
}