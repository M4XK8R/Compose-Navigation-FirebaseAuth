package com.maxkor.compose_navigation_firebaseauth.ui.nav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.maxkor.compose_navigation_firebaseauth.ui.sceenns.AfterAuthScreen
import com.maxkor.compose_navigation_firebaseauth.ui.sceenns.AuthScreen
import com.maxkor.compose_navigation_firebaseauth.ui.sceenns.MainScreen

@Composable
fun NavNav() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.MainScreen.route,
        builder = {
            composable(Routes.MainScreen.route) {
                MainScreen(navController)
            }
            composable(Routes.AuthScreen.route) {
                AuthScreen(navController, goToNextScreen = {
                    navController.navigate(Routes.AfterAuthScreen.route)
                })
            }
            composable(Routes.AfterAuthScreen.route) {
                AfterAuthScreen(navController)
            }
        }
    )
}