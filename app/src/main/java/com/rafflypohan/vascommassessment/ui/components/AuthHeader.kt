package com.rafflypohan.vascommassessment.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rafflypohan.vascommassessment.R
import com.rafflypohan.vascommassessment.ui.theme.GrayBlue
import com.rafflypohan.vascommassessment.ui.theme.PaleNavy
import com.rafflypohan.vascommassessment.ui.theme.figtreeFontFamily
import com.rafflypohan.vascommassessment.ui.theme.gilroyFontFamily

@Composable
fun AuthHeader(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = "Hai, Selamat Datang",
            fontSize = 28.sp,
            lineHeight = 33.6.sp,
            fontWeight = FontWeight(600),
            color = PaleNavy,
            fontFamily = gilroyFontFamily,
            modifier = Modifier.padding(horizontal = 20.dp)
        )
        Spacer(modifier = Modifier
            .height(4.dp)
            .padding(20.dp))
        Text(
            text = "Silahkan login untuk melanjutkan",
            fontSize = 12.sp,
            lineHeight = 15.6.sp,
            fontWeight = FontWeight(600),
            color = GrayBlue,
            fontFamily = figtreeFontFamily,
            modifier = Modifier.padding(horizontal = 20.dp)
        )
        // Image
        Image(
            painter = painterResource(id = R.drawable.header_image),
            contentDescription = null,
            modifier = Modifier.align(Alignment.End)
        )
    }
}