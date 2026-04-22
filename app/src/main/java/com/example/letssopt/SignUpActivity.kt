package com.example.letssopt

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LETSSOPTTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SignUpScreen(
                        modifier = Modifier.padding(innerPadding),
                        onSignUpComplete = { userId, userPw ->
                            val resultIntent = Intent().apply {
                                putExtra("userId", userId)
                                putExtra("userPw", userPw)
                            }
                            setResult(RESULT_OK, resultIntent)
                            finish()
                        },
                    )
                }
            }
        }
    }
}

@Composable
fun SignUpScreen(
    modifier: Modifier= Modifier,
    onSignUpComplete: (String, String)-> Unit
) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var checkPassword by remember { mutableStateOf("") }
    val context = LocalContext.current
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
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
            text = "회원가입",
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
                Text("이메일 주소를 입력하세요",
                    color = Color(0xFF666666) ,
                    fontFamily = FontFamily(Font(R.font.pretendard_regular)),
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp)
            },
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
                Text("비밀번호를 입력하세요",
                    color = Color(0xFF666666),
                    fontFamily = FontFamily(Font(R.font.pretendard_regular)),
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp)
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

        Spacer(modifier = Modifier.height(18.dp))

        Text(
            text = "비밀번호 확인",
            fontFamily = FontFamily(Font(R.font.pretendard_regular)),
            fontWeight = FontWeight.Normal,
            color = Color(0xFF999999),
            fontSize = 14.sp,
        )

        Spacer(modifier = Modifier.height(3.dp))

        TextField(
            value = checkPassword,
            onValueChange = { checkPassword= it },
            textStyle = TextStyle(
                fontFamily = FontFamily(Font(R.font.pretendard_regular)),
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                color = Color(0xFFFFFFFF)
            ),
            placeholder = {
                Text("비밀번호를 다시 입력하세요",
                    color = Color(0xFF666666),
                    fontFamily = FontFamily(Font(R.font.pretendard_regular)),
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp)
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

        Button(
            onClick = {
                when{
                    !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                        Toast.makeText(context, "올바른 이메일 형식이 아닙니다", Toast.LENGTH_SHORT).show()
                    }
                    password.length < 8 || password.length > 12 -> {
                        Toast.makeText(context, "비밀번호는 8~12글자 사이로 입력해주세요", Toast.LENGTH_SHORT).show()
                    }
                    password != checkPassword -> {
                        Toast.makeText(context, "비밀번호가 일치하지 않습니다", Toast.LENGTH_SHORT).show()
                    }
                    else -> {
                        onSignUpComplete(email, password)
                        Toast.makeText(context, "회원가입이 완료되었습니다", Toast.LENGTH_SHORT).show()
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth(),
                contentPadding = PaddingValues(vertical = 17.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFE8003C)
            ),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = "회원가입",
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
private fun PreviewSignUpScreen() {
    MaterialTheme {
        SignUpScreen(onSignUpComplete = { _, _ -> })
    }
}