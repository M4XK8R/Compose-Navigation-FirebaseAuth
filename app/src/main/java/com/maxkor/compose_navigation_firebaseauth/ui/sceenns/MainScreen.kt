package com.maxkor.compose_navigation_firebaseauth.ui.sceenns

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.maxkor.compose_navigation_firebaseauth.ui.nav.Routes

@Composable
fun MainScreen(navController: NavHostController) {

    Box(contentAlignment = Alignment.Center) {

        Column {

            Text(
                text = "Main Screen",
                fontSize = 26.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(40.dp))

            Button(
                onClick = { navController.navigate(Routes.AuthScreen.route) }
            ) {
                Text(text = "To Auth Screen", fontSize = 22.sp)
            }

        }

    }
}

