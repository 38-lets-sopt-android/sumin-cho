package com.example.letssopt.presentation.main.Navigation

import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.letssopt.presentation.home.Home
import com.example.letssopt.presentation.home.HomeRoute
import com.example.letssopt.presentation.login.AUTO_LOGIN
import com.example.letssopt.presentation.login.LoginScreen
import com.example.letssopt.presentation.login.USER_ID_KEY
import com.example.letssopt.presentation.login.USER_PW_KEY
import com.example.letssopt.presentation.purchase.Purchase
import com.example.letssopt.presentation.purchase.PurchaseRoute
import com.example.letssopt.presentation.save.Save
import com.example.letssopt.presentation.save.SaveRoute
import com.example.letssopt.presentation.search.Search
import com.example.letssopt.presentation.search.SearchRoute
import com.example.letssopt.presentation.signup.SignUpScreen
import com.example.letssopt.presentation.webtoon.Webtoon
import com.example.letssopt.presentation.webtoon.WebtoonRoute


 @Composable
 fun MainNavHost() {

     val navController = rememberNavController()

     NavHost(
         navController = navController,
         startDestination = Home
     ) {

//         composable("login") {
//
//             LoginScreen(
//
//                 onSignUpClick = {
//                     navController.navigate("signup")
//                 },
//
//                 onLoginClick = { inputId, inputPw ->
//
//                     val savedId =
//                         pref.getString(USER_ID_KEY, null)
//
//                     val savedPw =
//                         pref.getString(USER_PW_KEY, null)
//
//                     when {
//
//                         savedId == null || savedPw == null -> {
//
//                             Toast.makeText(
//                                 this@MainActivity,
//                                 "회원가입을 먼저 해주세요",
//                                 Toast.LENGTH_SHORT
//                             ).show()
//                         }
//
//                         inputId == savedId &&
//                                 inputPw == savedPw -> {
//
//                             pref.edit()
//                                 .putBoolean(AUTO_LOGIN, true)
//                                 .apply()
//
//                             Toast.makeText(
//                                 this@MainActivity,
//                                 "로그인 성공",
//                                 Toast.LENGTH_SHORT
//                             ).show()
//
//                             navController.navigate("main") {
//
//                                 popUpTo("login") {
//                                     inclusive = true
//                                 }
//                             }
//                         }
//
//                         else -> {
//
//                             Toast.makeText(
//                                 this@MainActivity,
//                                 "아이디 또는 비밀번호를 확인해주세요",
//                                 Toast.LENGTH_SHORT
//                             ).show()
//                         }
//                     }
//                 }
//             )
//         }
//
//         composable("signup") {
//
//             SignUpScreen(
//
//                 onSignUpComplete = { _, _ ->
//
//                     Toast.makeText(
//                         this@MainActivity,
//                         "회원가입 완료",
//                         Toast.LENGTH_SHORT
//                     ).show()
//
//                     navController.navigate("login")
//                 }
//             )
//         }

         composable<Home> {
             HomeRoute()
         }

         composable<Purchase> {
             PurchaseRoute(
                 paddingValues = PaddingValues(0.dp)
             )
         }

         composable<Webtoon> {
             WebtoonRoute(
                 paddingValues = PaddingValues(0.dp)
             )
         }

         composable<Search> {
             SearchRoute(
                 paddingValues = PaddingValues(0.dp)
             )
         }

         composable<Save> {
             SaveRoute(
                 paddingValues = PaddingValues(0.dp)
             )
         }
     }

 }