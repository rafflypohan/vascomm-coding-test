package com.rafflypohan.vascommassessment.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.LocalHospital
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rafflypohan.vascommassessment.R
import com.rafflypohan.vascommassessment.ui.theme.LightGray
import com.rafflypohan.vascommassessment.ui.theme.Navy
import com.rafflypohan.vascommassessment.ui.theme.Orange
import com.rafflypohan.vascommassessment.ui.theme.VascommAssessmentTheme
import com.rafflypohan.vascommassessment.ui.theme.figtreeFontFamily

@Composable
fun LayananKesehatanItem(
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 24.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
//                    .fillMaxWidth()
                    .padding(vertical = 12.dp)
            ) {
//                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "PCR Swab Test (Drive Thru)\n" +
                            "Hasil 1 Hari Kerja",
                    fontSize = 14.sp,
                    lineHeight = 16.8.sp,
                    fontFamily = figtreeFontFamily,
                    fontWeight = FontWeight(600),
                    color = Navy,
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Rp 1.400.000",
                    fontSize = 14.sp,
                    fontFamily = figtreeFontFamily,
                    fontWeight = FontWeight(600),
                    color = Orange,
                )

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Rounded.LocalHospital,
                        contentDescription = null,
                        tint = Navy
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Lenmarc Surabaya",
                        fontSize = 14.sp,
                        fontFamily = figtreeFontFamily,
                        fontWeight = FontWeight(600),
                        color = Color(0xFF6A6A6A),
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Rounded.LocationOn,
                        contentDescription = null,
                        tint = Navy
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Dukuh Pakis, Surabaya",
                        fontSize = 14.sp,
                        fontFamily = figtreeFontFamily,
                        fontWeight = FontWeight(400),
                        color = LightGray,
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))
            }
            val painter = painterResource(id = R.drawable.image_6)

            Image(
                modifier = Modifier
                    .weight(1f, fill = false)
                    .aspectRatio(painter.intrinsicSize.width / painter.intrinsicSize.height)
//                    .fillMaxHeight()
                    .width(120.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.Green),
                painter = painter,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                alignment = Alignment.CenterEnd
            )
        }
    }
}

@Preview
@Composable
fun LayananKesehatanItemPreview() {
    VascommAssessmentTheme {
        LayananKesehatanItem()
    }
}