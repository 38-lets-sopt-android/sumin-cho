package com.example.letssopt.presentation.main

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
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