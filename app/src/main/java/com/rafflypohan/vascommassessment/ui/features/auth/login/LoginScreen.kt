package com.rafflypohan.vascommassessment.ui.features.auth.login

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowRight
import androidx.compose.material.icons.filled.Copyright
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.rafflypohan.vascommassessment.R
import com.rafflypohan.vascommassessment.core.data.source.remote.request.LoginRequest
import com.rafflypohan.vascommassessment.ui.components.AuthHeader
import com.rafflypohan.vascommassessment.ui.components.CustomTextField
import com.rafflypohan.vascommassessment.ui.components.LabeledField
import com.rafflypohan.vascommassessment.ui.features.auth.AuthViewModel
import com.rafflypohan.vascommassessment.ui.theme.Gray
import com.rafflypohan.vascommassessment.ui.theme.GrayBlue
import com.rafflypohan.vascommassessment.ui.theme.LightGray
import com.rafflypohan.vascommassessment.ui.theme.Navy
import com.rafflypohan.vascommassessment.ui.theme.PaleNavy
import com.rafflypohan.vascommassessment.ui.theme.VascommAssessmentTheme
import com.rafflypohan.vascommassessment.ui.theme.figtreeFontFamily
import com.rafflypohan.vascommassessment.ui.theme.gilroyFontFamily
import com.rafflypohan.vascommassessment.ui.utils.FieldType
import es.dmoral.toasty.Toasty
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    viewModel: AuthViewModel = hiltViewModel(),
    navigateToRegister: () -> Unit,
    navigateToHome: () -> Unit
) {
    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    val state by viewModel.state.collectAsState()

    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(vertical = 20.dp)
            .verticalScroll(rememberScrollState())
    ) {
        AuthHeader()
        Spacer(modifier = Modifier.height(16.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            LabeledField(
                labelName = "Email",
                textFieldValue = email,
                placeholderText = "Masukkan email anda",
                fieldType = FieldType.Email,
                trailingLabel = { /*TODO*/ },
                onValueChange = {
                    email = it
                }
            )

            Spacer(modifier = Modifier.height(40.dp))

            LabeledField(
                labelName = "Password",
                textFieldValue = password,
                placeholderText = "Masukkan password anda",
                fieldType = FieldType.Password,
                trailingLabel = {
                    Text(
                        text = "Lupa password anda?",
                        fontSize = 14.sp,
                        fontWeight = FontWeight(600),
                        color = GrayBlue,
                        fontFamily = gilroyFontFamily
                    )
                },
                onValueChange = {
                    password = it
                }
            )

            Spacer(modifier = Modifier.height(30.dp))

            Button(
                onClick = {
                    viewModel.login(
                        LoginRequest(email, password)
                    )
                },
                modifier = Modifier
                    .shadow(
                        elevation = 4.dp,
//                    spotColor = Color(0x3D1D334F),
                        ambientColor = Color(0x3D1D334F)
                    )
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Navy),
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "Login",
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                        fontFamily = figtreeFontFamily,
                        fontWeight = FontWeight(600),
                        color = Color.White,
                        modifier = Modifier.padding(1.dp)
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(
                        imageVector = Icons.Rounded.ArrowForward,
                        contentDescription = null,
                    )
                }
            }
            Spacer(modifier = Modifier.height(30.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Belum punya akun?",
                    fontSize = 14.sp,
                    lineHeight = 18.2.sp,
                    fontWeight = FontWeight(400),
                    color = LightGray,
                    fontFamily = figtreeFontFamily
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = "Daftar sekarang",
                    fontSize = 14.sp,
                    lineHeight = 18.2.sp,
                    fontWeight = FontWeight(600),
                    color = Navy,
                    fontFamily = figtreeFontFamily,
                    modifier = Modifier.clickable {
                        navigateToRegister()
                    }
                )
            }
            Spacer(modifier = Modifier.height(40.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Copyright,
                    contentDescription = null,
                    tint = LightGray,
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "SILK. all right reserved.",
                    fontSize = 12.sp,
                    fontWeight = FontWeight(600),
                    color = LightGray,
                    fontFamily = figtreeFontFamily
                )
            }
        }
    }

    if (!state.token.isNullOrBlank()) {
        Toasty.success(context, "Login Success", Toast.LENGTH_SHORT, true).show()
        LaunchedEffect(key1 = Unit, block = {
            delay(1000)
            navigateToHome()
        })
    }

    if (state.errorMessage != null){
        Toasty.error(context, "Missing password", Toast.LENGTH_SHORT, true).show()
        password = ""
    }
}

//@Preview
//@Composable
//fun LoginScreenPreview() {
//    VascommAssessmentTheme {
//        LoginScreen(
//            navigateToHome = {},
//            navigateToRegister = {}
//        )
//    }
//}