package com.rafflypohan.vascommassessment.ui.features.auth.register

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Copyright
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rafflypohan.vascommassessment.ui.components.AuthHeader
import com.rafflypohan.vascommassessment.ui.components.LabeledField
import com.rafflypohan.vascommassessment.ui.theme.GrayBlue
import com.rafflypohan.vascommassessment.ui.theme.LightGray
import com.rafflypohan.vascommassessment.ui.theme.Navy
import com.rafflypohan.vascommassessment.ui.theme.VascommAssessmentTheme
import com.rafflypohan.vascommassessment.ui.theme.figtreeFontFamily
import com.rafflypohan.vascommassessment.ui.theme.gilroyFontFamily
import com.rafflypohan.vascommassessment.ui.utils.FieldType

@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier,
    navigateToLogin: () -> Unit,
    navigateBack: () -> Unit
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(vertical = 20.dp)
            .verticalScroll(scrollState)
    ) {
        AuthHeader()
        Spacer(modifier = Modifier.height(16.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(34.dp)
            ) {
                LabeledField(
                    labelName = "Nama Depan",
                    textFieldValue = "Jhon",
                    placeholderText = "Masukkan nama depan anda",
                    trailingLabel = { /*TODO*/ },
                    onValueChange = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                )

                LabeledField(
                    labelName = "Nama Belakang",
                    textFieldValue = "Doe",
                    placeholderText = "Masukkan nama belakang anda",
                    trailingLabel = { /*TODO*/ },
                    onValueChange = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                )
            }

            Spacer(modifier = Modifier.height(40.dp))

            LabeledField(
                labelName = "No KTP",
                textFieldValue = "",
                placeholderText = "Masukkan nomor KTP anda",
                fieldType = FieldType.Number,
                trailingLabel = { /*TODO*/ },
                onValueChange = { /*TODO*/ }
            )

            Spacer(modifier = Modifier.height(40.dp))

            LabeledField(
                labelName = "Email",
                textFieldValue = "",
                placeholderText = "Masukkan email anda",
                fieldType = FieldType.Email,
                trailingLabel = { /*TODO*/ },
                onValueChange = { /*TODO*/ }
            )

            Spacer(modifier = Modifier.height(40.dp))

            LabeledField(
                labelName = "No Telpon",
                textFieldValue = "",
                placeholderText = "Masukkan nomor telpon anda",
                fieldType = FieldType.Phone,
                trailingLabel = { /*TODO*/ },
                onValueChange = { /*TODO*/ }
            )

            Spacer(modifier = Modifier.height(40.dp))

            LabeledField(
                labelName = "Password",
                textFieldValue = "",
                placeholderText = "Masukkan password anda",
                fieldType = FieldType.Password,
                trailingLabel = {},
                onValueChange = { /*TODO*/ }
            )

            Spacer(modifier = Modifier.height(40.dp))

            LabeledField(
                labelName = "Konfirmasi",
                textFieldValue = "123",
                placeholderText = "Masukkan ulang password anda",
                fieldType = FieldType.Password,
                trailingLabel = {},
                onValueChange = { /*TODO*/ }
            )

            Spacer(modifier = Modifier.height(30.dp))

            Button(
                onClick = { /*TODO*/ },
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
                        text = "Register",
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
                    text = "Sudah punya akun?",
                    fontSize = 14.sp,
                    lineHeight = 18.2.sp,
                    fontWeight = FontWeight(400),
                    color = LightGray,
                    fontFamily = figtreeFontFamily
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = "Login sekarang",
                    fontSize = 14.sp,
                    lineHeight = 18.2.sp,
                    fontWeight = FontWeight(600),
                    color = Navy,
                    fontFamily = figtreeFontFamily,
                    modifier = Modifier.clickable {
                        navigateToLogin()
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
}

@Preview
@Composable
fun RegisterScreenPreview() {
    VascommAssessmentTheme {
        RegisterScreen(
            navigateToLogin = {},
            navigateBack = {}
        )
    }
}