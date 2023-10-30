package com.rafflypohan.vascommassessment.ui.features.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Facebook
import androidx.compose.material.icons.rounded.FilterList
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.offset
import androidx.compose.ui.unit.sp
import com.rafflypohan.vascommassessment.R
import com.rafflypohan.vascommassessment.ui.components.HomeFooter
import com.rafflypohan.vascommassessment.ui.components.Chip
import com.rafflypohan.vascommassessment.ui.components.CustomTextField
import com.rafflypohan.vascommassessment.ui.components.LayananKesehatanItem
import com.rafflypohan.vascommassessment.ui.components.ProductItem
import com.rafflypohan.vascommassessment.ui.components.TopBar
import com.rafflypohan.vascommassessment.ui.theme.GrayBlue
import com.rafflypohan.vascommassessment.ui.theme.Navy
import com.rafflypohan.vascommassessment.ui.theme.VascommAssessmentTheme
import com.rafflypohan.vascommassessment.ui.theme.figtreeFontFamily
import com.rafflypohan.vascommassessment.ui.theme.gilroyFontFamily
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navigateToProfile: () -> Unit,
    navigateToSetting: () -> Unit,
    navigateToLogin: () -> Unit
) {
    val assetOffset = 32.dp
    val marginTop = 20.dp + assetOffset

    val filterLabelList = listOf("All Product", "Layanan Kesehatan", "Alat Kesehatan")

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            if (drawerState.isOpen) {
                DrawerContent(
                    drawerState = drawerState,
                    navigateToProfile = { navigateToProfile() },
                    navigateToSetting = {},
                    navigateToLogin = { navigateToLogin() })
            }
        },
        gesturesEnabled = false
    ) {
        Scaffold(
            modifier = modifier,
            topBar = {
                TopBar() {
                    scope.launch {
                        drawerState.open()
                    }
                }
            },
        ) { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .padding(paddingValues)
//                .padding(horizontal = 20.dp)
//                .padding(top = marginTop, bottom = 20.dp)
                    .fillMaxSize(),
                contentPadding = PaddingValues(top = 20.dp, start = 20.dp, end = 20.dp),
                content = {
                    item {
                        Box(modifier = Modifier.fillMaxWidth()) {
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(end = 10.dp),
                                shape = RoundedCornerShape(16.dp),
                                elevation = CardDefaults.cardElevation(defaultElevation = 20.dp),
                                colors = CardDefaults.cardColors(containerColor = Color(0xFFDAE9F9))
                            ) {
                                Column(
                                    modifier = Modifier.padding(16.dp)
                                ) {
                                    Row {
                                        Text(
                                            text = "Solusi, ",
                                            fontSize = 18.sp,
                                            fontFamily = gilroyFontFamily,
                                            fontWeight = FontWeight(600),
                                            color = Navy,
                                        )
                                        Text(
                                            text = "Kesehatan anda",
                                            fontSize = 18.sp,
                                            fontFamily = gilroyFontFamily,
                                            fontWeight = FontWeight.Bold,
                                            color = Navy,
                                        )
                                    }

                                    Spacer(modifier = Modifier.height(8.dp))

                                    Text(
                                        text = "Update informasi seputar kesehatan\nsemua bisa disini !",
                                        fontSize = 12.sp,
                                        fontFamily = figtreeFontFamily,
                                        lineHeight = 13.sp,
                                        fontWeight = FontWeight(400),
                                        color = GrayBlue,
                                    )

                                    Spacer(modifier = Modifier.height(12.dp))

                                    Button(
                                        onClick = { /*TODO*/ },
                                        modifier = Modifier
                                            .shadow(
                                                elevation = 4.dp,
//                    spotColor = Color(0x3D1D334F),
                                                ambientColor = Color(0x3D1D334F)
                                            ),
                                        shape = RoundedCornerShape(8.dp),
                                        colors = ButtonDefaults.buttonColors(containerColor = Navy),
                                    ) {
                                        Text(
                                            text = "Selengkapnya",
                                            fontSize = 16.sp,
                                            fontFamily = figtreeFontFamily,
                                            fontWeight = FontWeight(600),
                                            color = Color.White,
                                            modifier = Modifier.padding(1.dp)
                                        )
                                    }
                                }
                            }
                            Image(
                                painter = painterResource(id = R.drawable.calendar_asset),
                                contentDescription = null,
                                modifier = Modifier
                                    .align(Alignment.TopEnd)
                                    .offset(y = -(36.dp))
                            )
                        }

                        Spacer(modifier = Modifier.height(marginTop))

                        Box(modifier = Modifier.fillMaxWidth()) {
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(end = 10.dp),
                                shape = RoundedCornerShape(16.dp),
                                elevation = CardDefaults.cardElevation(defaultElevation = 24.dp),
                                colors = CardDefaults.cardColors(containerColor = Color.White)
                            ) {
                                Column(
                                    modifier = Modifier.padding(16.dp)
                                ) {
                                    Text(
                                        text = "Layanan Khusus",
                                        fontSize = 18.sp,
                                        fontFamily = gilroyFontFamily,
                                        fontWeight = FontWeight(600),
                                        color = Navy,
                                    )

                                    Spacer(modifier = Modifier.height(8.dp))

                                    Text(
                                        text = "Tes Covid 19, Cegah Corona\nSedini Mungkin",
                                        fontSize = 12.sp,
                                        fontFamily = figtreeFontFamily,
                                        lineHeight = 13.sp,
                                        fontWeight = FontWeight(400),
                                        color = GrayBlue,
                                    )

                                    Spacer(modifier = Modifier.height(12.dp))

                                    Row(
                                        modifier = Modifier,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Text(
                                            text = "Daftar Tes",
                                            fontSize = 16.sp,
                                            fontFamily = figtreeFontFamily,
                                            fontWeight = FontWeight(600),
                                            color = Navy,
                                            modifier = Modifier.padding(1.dp)
                                        )

                                        Icon(
                                            imageVector = Icons.Rounded.ArrowForward,
                                            contentDescription = null,
                                            tint = Navy
                                        )
                                    }
                                }
                            }
                            Image(
                                painter = painterResource(id = R.drawable.calendar_asset),
                                contentDescription = null,
                                modifier = Modifier
                                    .align(Alignment.TopEnd)
                                    .offset(y = -(36.dp))
                            )
                        }

                        Spacer(modifier = Modifier.height(marginTop))

                        Box(modifier = Modifier.fillMaxWidth()) {
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                shape = RoundedCornerShape(16.dp),
                                elevation = CardDefaults.cardElevation(defaultElevation = 24.dp),
                                colors = CardDefaults.cardColors(containerColor = Color.White)
                            ) {
                                Row(modifier = Modifier.fillMaxWidth()) {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .weight(.6f)
                                    )
                                    Column(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .weight(1f)
                                            .padding(16.dp),
                                    ) {
                                        Text(
                                            text = "Track Pemeriksaan",
                                            fontSize = 18.sp,
                                            fontFamily = gilroyFontFamily,
                                            fontWeight = FontWeight(600),
                                            color = Navy,
                                        )

                                        Spacer(modifier = Modifier.height(8.dp))

                                        Text(
                                            text = "Kamu dapat mengecek progress pemeriksaanmu disini",
                                            softWrap = true,
                                            fontSize = 12.sp,
                                            fontFamily = figtreeFontFamily,
                                            lineHeight = 13.sp,
                                            fontWeight = FontWeight(400),
                                            color = GrayBlue,
                                        )

                                        Spacer(modifier = Modifier.height(12.dp))

                                        Row(
                                            modifier = Modifier,
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Text(
                                                text = "Track",
                                                fontSize = 16.sp,
                                                fontFamily = figtreeFontFamily,
                                                fontWeight = FontWeight(600),
                                                color = Navy,
                                                modifier = Modifier.padding(1.dp)
                                            )

                                            Icon(
                                                imageVector = Icons.Rounded.ArrowForward,
                                                contentDescription = null,
                                                tint = Navy
                                            )
                                        }
                                    }
                                }
                            }
                            Image(
                                painter = painterResource(id = R.drawable.calendar_asset),
                                contentDescription = null,
                                modifier = Modifier
                                    .align(Alignment.TopStart)
                                    .offset(y = -(36.dp))
                            )
                        }

                        Spacer(modifier = Modifier.height(40.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(30.dp)
                        ) {
                            FloatingActionButton(
                                onClick = { /*TODO*/ },
                                containerColor = Color.White,
                                contentColor = Navy,
                                elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 24.dp),
                                shape = CircleShape
                            ) {
                                Icon(
                                    imageVector = Icons.Rounded.FilterList,
                                    contentDescription = null
                                )
                            }

                            CustomTextField(
                                value = "",
                                placeholderText = "Search",
                                shape = RoundedCornerShape(30.dp),
                                trailingIcon = {
                                    Icon(
                                        imageVector = Icons.Rounded.Search,
                                        contentDescription = null,
                                        tint = Navy
                                    )
                                },
                                onValueChange = {}
                            )
                        }

                        Spacer(modifier = Modifier.height(40.dp))

                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(20.dp),
                            content = {
                                itemsIndexed(filterLabelList) { index, item ->
                                    Chip(label = item, isSelected = index == 0)
                                }
                            }
                        )

                        Spacer(modifier = Modifier.height(40.dp))

                        Text(
                            text = "Pilih Tipe Layanan Kesehatan Anda",
                            fontSize = 16.sp,
                            fontFamily = figtreeFontFamily,
                            fontWeight = FontWeight(600),
                            color = Navy,
                        )

                        Spacer(modifier = Modifier.height(40.dp))
                    }

                    items(5) {
                        LayananKesehatanItem()
                        Spacer(modifier = Modifier.height(30.dp))
                    }

                    item {
//                    Spacer(modifier = Modifier.height(40.dp))
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
            )
//        Column(
//            modifier = Modifier
//                .padding(paddingValues)
//                .padding(horizontal = 20.dp)
//                .padding(top = marginTop, bottom = 20.dp)
//                .fillMaxSize()
//                .verticalScroll(rememberScrollState())
//        ) {
//            Box(modifier = Modifier.fillMaxWidth()) {
//                Card(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(end = 10.dp),
//                    shape = RoundedCornerShape(16.dp),
//                    elevation = CardDefaults.cardElevation(defaultElevation = 20.dp),
//                    colors = CardDefaults.cardColors(containerColor = Color(0xFFDAE9F9))
//                ) {
//                    Column(
//                        modifier = Modifier.padding(16.dp)
//                    ) {
//                        Row {
//                            Text(
//                                text = "Solusi, ",
//                                fontSize = 18.sp,
//                                fontFamily = gilroyFontFamily,
//                                fontWeight = FontWeight(600),
//                                color = Navy,
//                            )
//                            Text(
//                                text = "Kesehatan anda",
//                                fontSize = 18.sp,
//                                fontFamily = gilroyFontFamily,
//                                fontWeight = FontWeight.Bold,
//                                color = Navy,
//                            )
//                        }
//
//                        Spacer(modifier = Modifier.height(8.dp))
//
//                        Text(
//                            text = "Update informasi seputar kesehatan\nsemua bisa disini !",
//                            fontSize = 12.sp,
//                            fontFamily = figtreeFontFamily,
//                            lineHeight = 13.sp,
//                            fontWeight = FontWeight(400),
//                            color = GrayBlue,
//                        )
//
//                        Spacer(modifier = Modifier.height(12.dp))
//
//                        Button(
//                            onClick = { /*TODO*/ },
//                            modifier = Modifier
//                                .shadow(
//                                    elevation = 4.dp,
////                    spotColor = Color(0x3D1D334F),
//                                    ambientColor = Color(0x3D1D334F)
//                                ),
//                            shape = RoundedCornerShape(8.dp),
//                            colors = ButtonDefaults.buttonColors(containerColor = Navy),
//                        ) {
//                            Text(
//                                text = "Selengkapnya",
//                                fontSize = 16.sp,
//                                fontFamily = figtreeFontFamily,
//                                fontWeight = FontWeight(600),
//                                color = Color.White,
//                                modifier = Modifier.padding(1.dp)
//                            )
//                        }
//                    }
//                }
//                Image(
//                    painter = painterResource(id = R.drawable.calendar_asset),
//                    contentDescription = null,
//                    modifier = Modifier
//                        .align(Alignment.TopEnd)
//                        .offset(y = -(36.dp))
//                )
//            }
//
//            Spacer(modifier = Modifier.height(marginTop))
//
//            Box(modifier = Modifier.fillMaxWidth()) {
//                Card(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(end = 10.dp),
//                    shape = RoundedCornerShape(16.dp),
//                    elevation = CardDefaults.cardElevation(defaultElevation = 24.dp),
//                    colors = CardDefaults.cardColors(containerColor = Color.White)
//                ) {
//                    Column(
//                        modifier = Modifier.padding(16.dp)
//                    ) {
//                        Text(
//                            text = "Layanan Khusus",
//                            fontSize = 18.sp,
//                            fontFamily = gilroyFontFamily,
//                            fontWeight = FontWeight(600),
//                            color = Navy,
//                        )
//
//                        Spacer(modifier = Modifier.height(8.dp))
//
//                        Text(
//                            text = "Tes Covid 19, Cegah Corona\nSedini Mungkin",
//                            fontSize = 12.sp,
//                            fontFamily = figtreeFontFamily,
//                            lineHeight = 13.sp,
//                            fontWeight = FontWeight(400),
//                            color = GrayBlue,
//                        )
//
//                        Spacer(modifier = Modifier.height(12.dp))
//
//                        Row(
//                            modifier = Modifier,
//                            verticalAlignment = Alignment.CenterVertically
//                        ) {
//                            Text(
//                                text = "Daftar Tes",
//                                fontSize = 16.sp,
//                                fontFamily = figtreeFontFamily,
//                                fontWeight = FontWeight(600),
//                                color = Navy,
//                                modifier = Modifier.padding(1.dp)
//                            )
//
//                            Icon(
//                                imageVector = Icons.Rounded.ArrowForward,
//                                contentDescription = null,
//                                tint = Navy
//                            )
//                        }
//                    }
//                }
//                Image(
//                    painter = painterResource(id = R.drawable.calendar_asset),
//                    contentDescription = null,
//                    modifier = Modifier
//                        .align(Alignment.TopEnd)
//                        .offset(y = -(36.dp))
//                )
//            }
//
//            Spacer(modifier = Modifier.height(marginTop))
//
//            Box(modifier = Modifier.fillMaxWidth()) {
//                Card(
//                    modifier = Modifier
//                        .fillMaxWidth(),
//                    shape = RoundedCornerShape(16.dp),
//                    elevation = CardDefaults.cardElevation(defaultElevation = 24.dp),
//                    colors = CardDefaults.cardColors(containerColor = Color.White)
//                ) {
//                    Row(modifier = Modifier.fillMaxWidth()) {
//                        Box(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .weight(.6f)
//                        )
//                        Column(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .weight(1f)
//                                .padding(16.dp),
//                        ) {
//                            Text(
//                                text = "Track Pemeriksaan",
//                                fontSize = 18.sp,
//                                fontFamily = gilroyFontFamily,
//                                fontWeight = FontWeight(600),
//                                color = Navy,
//                            )
//
//                            Spacer(modifier = Modifier.height(8.dp))
//
//                            Text(
//                                text = "Kamu dapat mengecek progress pemeriksaanmu disini",
//                                softWrap = true,
//                                fontSize = 12.sp,
//                                fontFamily = figtreeFontFamily,
//                                lineHeight = 13.sp,
//                                fontWeight = FontWeight(400),
//                                color = GrayBlue,
//                            )
//
//                            Spacer(modifier = Modifier.height(12.dp))
//
//                            Row(
//                                modifier = Modifier,
//                                verticalAlignment = Alignment.CenterVertically
//                            ) {
//                                Text(
//                                    text = "Track",
//                                    fontSize = 16.sp,
//                                    fontFamily = figtreeFontFamily,
//                                    fontWeight = FontWeight(600),
//                                    color = Navy,
//                                    modifier = Modifier.padding(1.dp)
//                                )
//
//                                Icon(
//                                    imageVector = Icons.Rounded.ArrowForward,
//                                    contentDescription = null,
//                                    tint = Navy
//                                )
//                            }
//                        }
//                    }
//                }
//                Image(
//                    painter = painterResource(id = R.drawable.calendar_asset),
//                    contentDescription = null,
//                    modifier = Modifier
//                        .align(Alignment.TopStart)
//                        .offset(y = -(36.dp))
//                )
//            }
//
//            Spacer(modifier = Modifier.height(40.dp))
//
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                horizontalArrangement = Arrangement.spacedBy(30.dp)
//            ) {
//                FloatingActionButton(
//                    onClick = { /*TODO*/ },
//                    containerColor = Color.White,
//                    contentColor = Navy,
//                    elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 24.dp),
//                    shape = CircleShape
//                ) {
//                    Icon(imageVector = Icons.Rounded.FilterList, contentDescription = null)
//                }
//
//                CustomTextField(
//                    value = "",
//                    placeholderText = "Search",
//                    shape = RoundedCornerShape(30.dp),
//                    trailingIcon = {
//                        Icon(
//                            imageVector = Icons.Rounded.Search,
//                            contentDescription = null,
//                            tint = Navy
//                        )
//                    },
//                    onValueChange = {}
//                )
//            }
//
//            Spacer(modifier = Modifier.height(40.dp))
//
//            LazyRow(content = {
//                itemsIndexed(filterLabelList) { index, item ->
//                    Chip(label = item, isSelected = index == 0)
//                }
//            })
//
//            Spacer(modifier = Modifier.height(24.dp))
//
//            LazyRow(horizontalArrangement = Arrangement.spacedBy(20.dp), content = {
//                items(5) {
//                    ProductItem()
//                }
//            })
//
//            Spacer(modifier = Modifier.height(40.dp))
//
//            Text(
//                text = "Pilih Tipe Layanan Kesehatan Anda",
//                fontSize = 16.sp,
//                fontFamily = figtreeFontFamily,
//                fontWeight = FontWeight(600),
//                color = Navy,
//            )
//
//            Spacer(modifier = Modifier.height(40.dp))
//
//            LazyColumn(content = {
//                items(5) {
//                    LayananKesehatanItem()
//                }
//            })
//
//            Spacer(modifier = Modifier.height(40.dp))
//
//            HomeFooter()
//        }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrawerContent(
    modifier: Modifier = Modifier,
    drawerState: DrawerState,
    navigateToProfile: () -> Unit,
    navigateToSetting: () -> Unit,
    navigateToLogin: () -> Unit
) {
    ModalDrawerSheet(
        modifier = modifier.fillMaxSize(),
        drawerContainerColor = Color.White,
        drawerContentColor = Navy,
        drawerShape = RectangleShape
    ) {
        val scope = rememberCoroutineScope()
        Row(
            modifier = Modifier
                .fillMaxSize()
//                .padding(24.dp, 40.dp)
//                .background(Color.White)
                .padding(top = 40.dp)
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(.2f)
                    .layout { measurable, constraints ->
                        // Measure the composable adding the side padding*2 (left+right)
                        val topPadding = -(40).dp
                        val placeable =
                            measurable.measure(constraints.offset(vertical = -topPadding.roundToPx() * 2))

                        //increase the width adding the side padding*2
                        layout(
                            placeable.width,
                            placeable.height + topPadding.roundToPx() * 2
                        ) {
                            // Where the composable gets placed
                            placeable.place(0, +topPadding.roundToPx())
                        }
                    }
                    .background(Navy.copy(alpha = 0.8f)),
                contentAlignment = Alignment.TopCenter
            ) {
                IconButton(onClick = {
                    scope.launch {
                        drawerState.close()
                    }
                }) {
                    Icon(
                        imageVector = Icons.Rounded.Close,
                        contentDescription = null,
                        modifier = Modifier,
                        tint = Color.White,

                        )
                }
            }


            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.White)
                    .padding(40.dp),

                ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
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
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text(
                            text = "Angga Praja",
                            fontSize = 14.sp,
                            fontFamily = figtreeFontFamily,
                            fontWeight = FontWeight(700),
                            color = Navy,
                        )
                        Text(
                            text = "Membership BLK",
                            fontSize = 11.sp,
                            fontFamily = figtreeFontFamily,
                            fontWeight = FontWeight(600),
                            color = Color(0xFF002060),
                        )
                    }
                }

                Spacer(modifier = Modifier.height(40.dp))

                TextButton(onClick = {
                    navigateToProfile()
                }) {
                    Text(
                        text = "Profile saya",
                        fontSize = 12.sp,
                        fontFamily = figtreeFontFamily,
                        fontWeight = FontWeight(600),
                        color = Color(0xFF9A9A9A),
                    )

                    Icon(
                        imageVector = Icons.Rounded.ArrowForward,
                        contentDescription = null,
                        tint = Color(0xFF9A9A9A)
                    )
                }

                TextButton(onClick = {
                    navigateToSetting()
                }) {
                    Text(
                        text = "Pengaturan",
                        fontSize = 12.sp,
                        fontFamily = figtreeFontFamily,
                        fontWeight = FontWeight(600),
                        color = Color(0xFF9A9A9A),
                    )
                    Icon(
                        imageVector = Icons.Rounded.ArrowForward,
                        contentDescription = null,
                        tint = Color(0xFF9A9A9A)
                    )
                }

                Spacer(modifier = Modifier.padding(40.dp))

                Button(
                    onClick = {
                        navigateToLogin()
                    },
                    colors = ButtonDefaults.buttonColors(Color.Red),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Logout", fontSize = 11.sp,
                        fontFamily = figtreeFontFamily,
                        fontWeight = FontWeight(400),
                        color = Color(0xFFFFFFFF),
                    )
                }

                Spacer(modifier = Modifier.height(80.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(
                        text = "Ikuti kami di",
                        fontSize = 16.sp,
                        fontFamily = gilroyFontFamily,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF002060),
                    )

                    Icon(
                        imageVector = Icons.Rounded.Facebook,
                        contentDescription = null,
                        tint = Navy
                    )
                    Icon(
                        imageVector = Icons.Rounded.Facebook,
                        contentDescription = null,
                        tint = Navy
                    )
                    Icon(
                        imageVector = Icons.Rounded.Facebook,
                        contentDescription = null,
                        tint = Navy
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun HomeScreenPreview() {
    VascommAssessmentTheme {
        DrawerContent(
            drawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
            navigateToProfile = {},
            navigateToSetting = {}
        ) {}
    }
}