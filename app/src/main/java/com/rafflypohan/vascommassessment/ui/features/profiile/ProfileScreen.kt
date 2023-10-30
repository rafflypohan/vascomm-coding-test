package com.rafflypohan.vascommassessment.ui.features.profiile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.outlined.Save
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material.icons.rounded.PersonPin
import androidx.compose.material.icons.rounded.Save
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.offset
import androidx.compose.ui.unit.sp
import com.rafflypohan.vascommassessment.R
import com.rafflypohan.vascommassessment.core.data.source.remote.request.LoginRequest
import com.rafflypohan.vascommassessment.ui.components.HomeFooter
import com.rafflypohan.vascommassessment.ui.components.LabeledField
import com.rafflypohan.vascommassessment.ui.theme.Gray
import com.rafflypohan.vascommassessment.ui.theme.LightGray
import com.rafflypohan.vascommassessment.ui.theme.Navy
import com.rafflypohan.vascommassessment.ui.theme.VascommAssessmentTheme
import com.rafflypohan.vascommassessment.ui.theme.figtreeFontFamily
import com.rafflypohan.vascommassessment.ui.theme.gilroyFontFamily
import com.rafflypohan.vascommassessment.ui.utils.FieldType

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(20.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Card(
            modifier = Modifier,
            colors = CardDefaults.cardColors(containerColor = Navy),
            shape = RoundedCornerShape(20.dp)
        ) {
            Column(
                modifier = Modifier,
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(vertical = 32.dp, horizontal = 24.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.image_6),
                        contentDescription = null,
                        modifier = Modifier
                            .size(36.dp)
                            .clip(
                                CircleShape
                            ),
                        contentScale = ContentScale.FillBounds
                    )
                    Spacer(modifier = Modifier.width(18.dp))
                    Column {
                        Text(
                            text = "Angga Praja",
                            fontSize = 28.sp,
                            fontFamily = figtreeFontFamily,
                            fontWeight = FontWeight(700),
                            color = Color.White,
                        )
                        Text(
                            text = "Membership BLK",
                            fontSize = 14.sp,
                            fontFamily = figtreeFontFamily,
                            fontWeight = FontWeight(600),
                            color = Color.White.copy(0.86f),
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
//                        .background(Navy.copy(alpha = 0.8f))
                        .background(Color(0xFF1A3E78), RoundedCornerShape(topStart = 20.dp))
                ) {
                    Text(
                        text = "Lengkapi profile anda untuk memaksimalkan penggunaan aplikasi",
                        fontSize = 12.sp,
                        fontFamily = figtreeFontFamily,
                        fontWeight = FontWeight(400),
                        color = Color(0xFFFFFFFF),
                        modifier = Modifier.padding(12.dp)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier
                .background(Color.White)
                .padding(30.dp)
        ) {
            Text(
                text = "Pilih data yang ingin ditampilkan",
                fontSize = 16.sp,
                fontFamily = gilroyFontFamily,
                fontWeight = FontWeight(600),
                color = Color(0xFF002060),
            )

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .background(Color.Cyan, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Rounded.PersonPin,
                        contentDescription = null,
                        tint = Navy,
                        modifier = Modifier.size(20.dp)
                    )
                }

                Column {
                    Text(
                        text = "Data Diri",
                        fontSize = 14.sp,
                        fontFamily = gilroyFontFamily,
                        fontWeight = FontWeight(600),
                        color = Color(0xFF333333),
                    )
                    Text(
                        text = "Data diri anda sesuai KTP",
                        fontSize = 10.sp,
                        fontFamily = figtreeFontFamily,
                        fontWeight = FontWeight(400),
                        color = Color(0xFFBDBDBD),
                    )
                }

                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .background(LightGray, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Rounded.LocationOn,
                        contentDescription = null,
                        tint = Gray,
                        modifier = Modifier.size(20.dp)
                    )
                }

            }

            Spacer(modifier = Modifier.height(30.dp))

            LabeledField(
                labelName = "Nama Depan",
                textFieldValue = "Jhon",
                placeholderText = "Masukkan nama depan anda",
                fieldType = FieldType.Default,
                trailingLabel = { /*TODO*/ },
                onValueChange = {
//                email = it
                }
            )

            Spacer(modifier = Modifier.height(30.dp))

            LabeledField(
                labelName = "Nama Belakang",
                textFieldValue = "",
                placeholderText = "Masukkan nama belakang anda",
                fieldType = FieldType.Default,
                trailingLabel = { /*TODO*/ },
                onValueChange = {
//                email = it
                }
            )

            Spacer(modifier = Modifier.height(30.dp))

            LabeledField(
                labelName = "Email",
                textFieldValue = "",
                placeholderText = "Masukkan email anda",
                fieldType = FieldType.Email,
                trailingLabel = { /*TODO*/ },
                onValueChange = {
//                email = it
                }
            )

            Spacer(modifier = Modifier.height(30.dp))

            LabeledField(
                labelName = "No Telpon",
                textFieldValue = "",
                placeholderText = "Masukkan no telpon anda",
                fieldType = FieldType.Phone,
                trailingLabel = { /*TODO*/ },
                onValueChange = {
//                email = it
                }
            )

            Spacer(modifier = Modifier.height(30.dp))

            LabeledField(
                labelName = "No KTP",
                textFieldValue = "",
                placeholderText = "Masukkan no ktp anda",
                fieldType = FieldType.Number,
                trailingLabel = { /*TODO*/ },
                onValueChange = {
//                email = it
                }
            )

            Spacer(modifier = Modifier.height(40.dp))

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(imageVector = Icons.Default.Info, contentDescription = null, tint = Navy)
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "Pastikan profile anda terisi dengan benar, data pribadi anda terjamin keamanannya",
                    fontSize = 12.sp,
                    lineHeight = 14.4.sp,
                    fontFamily = figtreeFontFamily,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF6A6A6A),
                )
            }

            Spacer(modifier = Modifier.height(34.dp))

            Button(
                onClick = {
//                    viewModel.login(
//                        LoginRequest(email, password)
//                    )
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
                        text = "Simpan Profile",
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                        fontFamily = figtreeFontFamily,
                        fontWeight = FontWeight(600),
                        color = Color.White,
                        modifier = Modifier.padding(1.dp)
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(
                        imageVector = Icons.Outlined.Save
                        ,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }
        }

        val sidePadding = -(20).dp

        HomeFooter(modifier = Modifier.layout { measurable, constraints ->
            // Measure the composable adding the side padding*2 (left+right)
            val placeable =
                measurable.measure(constraints.offset(horizontal = -sidePadding.roundToPx() * 2))

            //increase the width adding the side padding*2
            layout(
                placeable.width + sidePadding.roundToPx() * 2,
                placeable.height
            ) {
                // Where the composable gets placed
                placeable.place(+sidePadding.roundToPx(), 0)
            }

        })
    }
}

@Preview
@Composable
fun ProfileScreenPreview() {
    VascommAssessmentTheme {
        ProfileScreen()
    }
}