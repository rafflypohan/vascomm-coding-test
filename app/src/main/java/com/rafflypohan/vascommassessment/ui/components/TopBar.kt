package com.rafflypohan.vascommassessment.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rafflypohan.vascommassessment.ui.theme.Navy
import com.rafflypohan.vascommassessment.ui.theme.VascommAssessmentTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    onMenuClick: () -> Unit
) {
    TopAppBar(
        title = { },
        navigationIcon = {
            IconButton(onClick = {
                onMenuClick()
            }) {
                Icon(
                    imageVector = Icons.Rounded.Menu,
                    contentDescription = "Menu"
                )
            }
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Rounded.ShoppingCart,
                    contentDescription = "Cart"
                )
            }

            IconButton(onClick = { /*TODO*/ }) {
                BadgedBox(badge = {
                    Badge(
                        containerColor = Color.Red, modifier = Modifier
                            .size(6.dp)
                            .offset(x = -(10.dp), y = 6.dp)
//                            .border(width = 2.dp, color = Color.White, shape = CircleShape)
                    ) {

                    }
                }) {
                    Icon(
                        imageVector = Icons.Rounded.Notifications,
                        contentDescription = "Notification",
                        modifier = Modifier
                    )
                }
            }
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = Color.White,
            actionIconContentColor = Navy,
            navigationIconContentColor = Navy
        )
    )
}

@Preview
@Composable
fun TopBarPreview() {
    VascommAssessmentTheme {
        TopBar(){}
    }
}