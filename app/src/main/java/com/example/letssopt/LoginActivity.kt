package com.example.letssopt

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.letssopt.ui.theme.LETSSOPTTheme
import kotlin.jvm.java

class LoginActivity : ComponentActivity() {
    private var savedId: String? = null
    private var savedPw: String? = null

    private val signUpLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            savedId = result.data?.getStringExtra("userId")
            savedPw = result.data?.getStringExtra("userPw")
        }
    }
    private val pref by lazy {
        getSharedPreferences("login_prefs", MODE_PRIVATE)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val isAutoLogin = pref.getBoolean("autoLogin", false)

        if (isAutoLogin) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
            return
        }
        setContent {
            LETSSOPTTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LoginScreen(
                        modifier = Modifier.padding(innerPadding),
                        onSignUpClick = {
                            val intent = Intent(this, SignUpActivity::class.java)
                            signUpLauncher.launch(intent)
                        },
                        onLoginClick = { inputId, inputPw ->
                            when {
                                savedId == null || savedPw == null -> {
                                    Toast.makeText(this, "회원가입을 먼저 해주세요", Toast.LENGTH_SHORT).show()
                                }

                                inputId == savedId && inputPw == savedPw -> {
                                    val editor = pref.edit()
                                    editor.putString("userId", inputId)
                                    editor.putString("userPw", inputPw)
                                    editor.putBoolean("autoLogin", true)
                                    editor.apply()

                                    val intent = Intent(this, MainActivity::class.java)
                                    Toast.makeText(this, "로그인에 성공했습니다", Toast.LENGTH_SHORT).show()
                                    startActivity((intent))
                                    finish()
                                }
                                else -> Toast.makeText(this, "다시 입력해주세요", Toast.LENGTH_SHORT).show()
                            }
                        }
                        )
                }
            }
        }
    }
}

@Composable
fun LoginScreen(
    modifier: Modifier= Modifier,
    onSignUpClick: () -> Unit,
    onLoginClick: (String, String) -> Unit,)
{

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(horizontal = 20.dp)
            .padding(top = 60.dp, bottom = 26.dp)
    ) {
        Text(
            text = "watcha",
            fontFamily = FontFamily(Font(R.font.pretendard_bold)),
            fontWeight = FontWeight.Bold,
            color = Color(0xFFE8003C),
            fontSize = 36.sp,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(26.dp))

        Text(
            text = "이메일로 로그인",
            fontFamily = FontFamily(Font(R.font.pretendard_bold)),
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 20.sp,
        )

        Spacer(modifier = Modifier.height(36.dp))

        Text(
            text = "이메일",
            fontFamily = FontFamily(Font(R.font.pretendard_regular)),
            fontWeight = FontWeight.Normal,
            color = Color(0xFF999999),
            fontSize = 14.sp,
        )

        Spacer(modifier = Modifier.height(3.dp))

        TextField(
            value = email,
            onValueChange = { email = it },
            textStyle = TextStyle(
                fontFamily = FontFamily(Font(R.font.pretendard_regular)),
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                color = Color(0xFFFFFFFF)
            ),
            placeholder = {
                Text(
                    text = "이메일 주소를 입력하세요",
                    color = Color(0xFF666666) ,
                    fontFamily = FontFamily(Font(R.font.pretendard_regular)),
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp
                )
                          },
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFF2A2A2A),
                unfocusedContainerColor = Color(0xFF2A2A2A),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent ) )

        Spacer(modifier = Modifier.height(18.dp))

        Text(
            text = "비밀번호",
            fontFamily = FontFamily(Font(R.font.pretendard_regular)),
            fontWeight = FontWeight.Normal,
            color = Color(0xFF999999),
            fontSize = 14.sp,
        )

        Spacer(modifier = Modifier.height(3.dp))

        TextField(
            value = password,
            onValueChange = { password = it },
            textStyle = TextStyle(
                fontFamily = FontFamily(Font(R.font.pretendard_regular)),
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                color = Color(0xFFFFFFFF)
            ),
            placeholder = {
                Text(
                    text = "비밀번호를 입력하세요",
                    color = Color(0xFF666666),
                    fontFamily = FontFamily(Font(R.font.pretendard_regular)),
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp
                )
            },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFF2A2A2A),
                unfocusedContainerColor = Color(0xFF2A2A2A),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "아직 계정이 없으신가요? 회원가입",
            color = Color(0xFF999999),
            fontFamily = FontFamily(Font(R.font.pretendard_regular)),
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            modifier = Modifier
                .fillMaxWidth()
                .clickable{onSignUpClick()},
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {onLoginClick(email,password)},
            modifier = Modifier
                .fillMaxWidth(),
                contentPadding = PaddingValues(vertical = 17.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE8003C)),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = "로그인",
                fontFamily = FontFamily(Font(R.font.pretendard_bold)),
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 16.sp
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
    MaterialTheme {
        LoginScreen(
            onSignUpClick = {},
            onLoginClick = {_, _ ->}
        )
    }
}