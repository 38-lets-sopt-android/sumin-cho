package com.example.letssopt.presentation.main

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.letssopt.R
import com.example.letssopt.presentation.home.BottomNavigationBar
import com.example.letssopt.presentation.home.HomeScreen
import com.example.letssopt.presentation.login.AUTO_LOGIN
import com.example.letssopt.presentation.login.LoginScreen
import com.example.letssopt.presentation.login.USER_ID_KEY
import com.example.letssopt.presentation.login.USER_PW_KEY
import com.example.letssopt.presentation.purchase.PurchaseScreen
import com.example.letssopt.presentation.save.SaveScreen
import com.example.letssopt.presentation.search.SearchScreen
import com.example.letssopt.presentation.signup.SignUpScreen
import com.example.letssopt.presentation.webtoon.WebtoonScreen
import com.example.letssopt.ui.theme.LETSSOPTTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {

            LETSSOPTTheme {

                val navController = rememberNavController()

                val backStackEntry by
                navController.currentBackStackEntryAsState()

                val currentRoute =
                    backStackEntry?.destination?.route ?: "main"

                val pref = getSharedPreferences(
                    "login_prefs",
                    MODE_PRIVATE
                )

                val startDestination =
                    if (pref.getBoolean(AUTO_LOGIN, false)) {
                        "main"
                    } else {
                        "login"
                    }

                Scaffold(

                    bottomBar = {

                        BottomNavigationBar()
                    }

                ) { padding ->

                NavHost(
                        navController = navController,
                        startDestination = startDestination,
                        modifier = Modifier.padding(padding)
                    ) {

                        composable("login") {

                            LoginScreen(

                                onSignUpClick = {
                                    navController.navigate("signup")
                                },

                                onLoginClick = { inputId, inputPw ->

                                    val savedId =
                                        pref.getString(USER_ID_KEY, null)

                                    val savedPw =
                                        pref.getString(USER_PW_KEY, null)

                                    when {

                                        savedId == null || savedPw == null -> {

                                            Toast.makeText(
                                                this@MainActivity,
                                                "회원가입을 먼저 해주세요",
                                                Toast.LENGTH_SHORT
                                            ).show()
                                        }

                                        inputId == savedId &&
                                                inputPw == savedPw -> {

                                            pref.edit()
                                                .putBoolean(AUTO_LOGIN, true)
                                                .apply()

                                            Toast.makeText(
                                                this@MainActivity,
                                                "로그인 성공",
                                                Toast.LENGTH_SHORT
                                            ).show()

                                            navController.navigate("main") {

                                                popUpTo("login") {
                                                    inclusive = true
                                                }
                                            }
                                        }

                                        else -> {

                                            Toast.makeText(
                                                this@MainActivity,
                                                "아이디 또는 비밀번호를 확인해주세요",
                                                Toast.LENGTH_SHORT
                                            ).show()
                                        }
                                    }
                                }
                            )
                        }

                        composable("signup") {

                            SignUpScreen(

                                onSignUpComplete = { _, _ ->

                                    Toast.makeText(
                                        this@MainActivity,
                                        "회원가입 완료",
                                        Toast.LENGTH_SHORT
                                    ).show()

                                    navController.navigate("login")
                                }
                            )
                        }

                        composable("main") {
                            HomeScreen()
                        }

                        composable("purchase") {
                            PurchaseScreen()
                        }

                        composable("webtoon") {
                            WebtoonScreen()
                        }

                        composable("search") {
                            SearchScreen()
                        }

                        composable("save") {
                            SaveScreen()
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {

    LETSSOPTTheme {

        Scaffold(

            bottomBar = {
                BottomNavigationBar()
            }

        ) { padding ->

            Box(
                modifier = Modifier.padding(padding)
            ) {

                HomeScreen()
            }
        }
    }
}