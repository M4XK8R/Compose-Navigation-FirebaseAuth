package com.maxkor.compose_navigation_firebaseauth.ui.nav

sealed class Routes(val route: String) {
    object MainScreen : Routes("main")
    object AuthScreen : Routes("auth")
    object AfterAuthScreen : Routes("after_auth")
}
