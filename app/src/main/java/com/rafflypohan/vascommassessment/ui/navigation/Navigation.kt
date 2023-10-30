package com.rafflypohan.vascommassessment.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rafflypohan.vascommassessment.ui.features.auth.login.LoginScreen
import com.rafflypohan.vascommassessment.ui.features.auth.register.RegisterScreen
import com.rafflypohan.vascommassessment.ui.features.home.HomeScreen
import com.rafflypohan.vascommassessment.ui.features.profiile.ProfileScreen

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Register : Screen("register")
    object Home : Screen("home")
    object Profile : Screen("profile")
}

@Composable
fun Navigation(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = Screen.Login.route) {
        composable(Screen.Login.route) {
            LoginScreen(
                navigateToRegister = {
                    navController.navigate(Screen.Register.route)
                },
                navigateToHome = {
                    navController.navigate(Screen.Home.route)
                }
            )
        }

        composable(Screen.Register.route) {
            RegisterScreen(
                navigateToLogin = {
                    navController.navigate(Screen.Login.route)
                },
                navigateBack = {
                    navController.navigateUp()
                }
            )
        }

        composable(Screen.Home.route) {
            HomeScreen(
                navigateToProfile = {
                    navController.navigate(Screen.Profile.route)
                },
                navigateToSetting = {}
            ){
                navController.navigate(Screen.Login.route)
            }
        }

        composable(Screen.Profile.route) {
            ProfileScreen()
        }
    }
}