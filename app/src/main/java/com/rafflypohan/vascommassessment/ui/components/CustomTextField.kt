package com.rafflypohan.vascommassessment.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rafflypohan.vascommassessment.ui.theme.Gray
import com.rafflypohan.vascommassessment.ui.theme.Navy
import com.rafflypohan.vascommassessment.ui.theme.VascommAssessmentTheme
import com.rafflypohan.vascommassessment.ui.theme.figtreeFontFamily
import com.rafflypohan.vascommassessment.ui.utils.FieldType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    value: String,
    placeholderText: String,
    fieldType: FieldType = FieldType.Default,
    shape: RoundedCornerShape = RoundedCornerShape(8.dp),
    trailingIcon: @Composable () -> Unit = {},
    onValueChange: (String) -> Unit,
) {
    var isPasswordVisible by remember {
        mutableStateOf(false)
    }
    TextField(
        value = value,
        onValueChange = { onValueChange(it) },
        placeholder = {
            Text(
                text = placeholderText,
                fontSize = 12.sp,
                lineHeight = 14.4.sp,
                fontWeight = FontWeight(400),
                fontFamily = figtreeFontFamily
            )
        },
        singleLine = true,
        modifier = Modifier
            .shadow(
                elevation = 24.dp,
                spotColor = Color(0x29BEBEBE),
//                    ambientColor = Color(0x29BEBEBE)
            )
            .fillMaxWidth(),
        shape = shape,
        textStyle = TextStyle(
            fontSize = 12.sp,
            fontFamily = figtreeFontFamily,
            fontWeight = FontWeight(600),
            color = Navy,
        ),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Navy,
            containerColor = Color.White,
            placeholderColor = Gray,
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent
        ),
        trailingIcon = {
            if (fieldType == FieldType.Password) {
                Icon(
                    imageVector = if (isPasswordVisible) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                    contentDescription = null,
                    modifier = Modifier.clickable {
                        isPasswordVisible = !isPasswordVisible
                    })
            }
            trailingIcon()
        },
        visualTransformation = if (fieldType == FieldType.Password && !isPasswordVisible) PasswordVisualTransformation() else VisualTransformation.None,
        keyboardOptions = KeyboardOptions(
            keyboardType = when (fieldType) {
                FieldType.Default -> KeyboardType.Text
                FieldType.Password -> KeyboardType.Password
                FieldType.Number -> KeyboardType.Number
                FieldType.Phone -> KeyboardType.Phone
                FieldType.Email -> KeyboardType.Email
            }
        )
    )
}

@Preview
@Composable
fun PreviewCustomTextField() {
    VascommAssessmentTheme {
        CustomTextField(value = "", placeholderText = "Tess", fieldType = FieldType.Password) {

        }
    }
}