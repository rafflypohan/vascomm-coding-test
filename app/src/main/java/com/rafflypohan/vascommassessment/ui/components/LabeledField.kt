package com.rafflypohan.vascommassessment.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rafflypohan.vascommassessment.ui.theme.GrayBlue
import com.rafflypohan.vascommassessment.ui.theme.PaleNavy
import com.rafflypohan.vascommassessment.ui.theme.VascommAssessmentTheme
import com.rafflypohan.vascommassessment.ui.theme.gilroyFontFamily
import com.rafflypohan.vascommassessment.ui.utils.FieldType

@Composable
fun LabeledField(
    modifier: Modifier = Modifier,
    labelName: String,
    textFieldValue: String,
    placeholderText: String,
    fieldType: FieldType = FieldType.Default,
    trailingLabel: @Composable () -> Unit,
    onValueChange: (String) -> Unit,
) {
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = labelName,
                color = PaleNavy,
                fontSize = 16.sp,
                fontWeight = FontWeight(600),
                fontFamily = gilroyFontFamily
            )
            trailingLabel()
        }
        Spacer(modifier = Modifier.height(16.dp))
        CustomTextField(
            value = textFieldValue,
            placeholderText = placeholderText,
            fieldType = fieldType,
            onValueChange = onValueChange
        )
    }
}

@Preview
@Composable
fun LabeledFieldPreview() {
    VascommAssessmentTheme {
        LabeledField(
            labelName = "Bane",
            textFieldValue = "",
            placeholderText = "Masukkan email anda",
            trailingLabel = {
                Text(
                    text = "Lupa password anda?",
                    fontSize = 14.sp,
                    fontWeight = FontWeight(600),
                    color = GrayBlue,
                    fontFamily = gilroyFontFamily
                )
            },
            onValueChange = { /*TODO*/ })
    }
}