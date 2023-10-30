package com.rafflypohan.vascommassessment.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rafflypohan.vascommassessment.ui.theme.Green
import com.rafflypohan.vascommassessment.ui.theme.LightGray
import com.rafflypohan.vascommassessment.ui.theme.Navy
import com.rafflypohan.vascommassessment.ui.theme.Orange
import com.rafflypohan.vascommassessment.ui.theme.SageGreen
import com.rafflypohan.vascommassessment.ui.theme.VascommAssessmentTheme
import com.rafflypohan.vascommassessment.ui.theme.figtreeFontFamily

@Composable
fun ProductItem(
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.width(160.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(contentColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 20.dp)
    ) {
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Rounded.Star,
                    contentDescription = null,
                    tint = Color.Yellow
                )
                Text(
                    text = "5",
                    fontSize = 16.sp,
                    fontFamily = figtreeFontFamily,
                    fontWeight = FontWeight(600),
                    color = LightGray,
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

//        Image(painter = , contentDescription = )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Suntik Steril",
                fontSize = 14.sp,
                fontFamily = figtreeFontFamily,
                fontWeight = FontWeight(600),
                color = Navy,
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Rp 10.000",
                    fontSize = 12.sp,
                    fontFamily = figtreeFontFamily,
                    fontWeight = FontWeight(600),
                    color = Orange,
                )

                Text(
                    text = "Ready Stock",
                    fontSize = 10.sp,
                    fontFamily = figtreeFontFamily,
                    fontWeight = FontWeight(400),
                    color = Green,
                    modifier = Modifier
                        .background(SageGreen)
                        .padding(horizontal = 4.dp, vertical = 2.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun ProductIemPreview() {
    VascommAssessmentTheme {
        ProductItem()
    }
}