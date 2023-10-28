package com.maxkor.compose_navigation_firebaseauth.ui.sceenns

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.maxkor.compose_navigation_firebaseauth.R
import com.maxkor.compose_navigation_firebaseauth.ui.nav.Routes

@Composable
fun AfterAuthScreen(navController: NavHostController) {

    Box {

        Text(
            text = "Last Screen",
            fontSize = 26.sp,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 24.dp)
        )

        Column(modifier = Modifier.align(Alignment.Center)) {

            IconButton(
                onClick = {
                    navController.popBackStack(
                        route = Routes.MainScreen.route,
                        inclusive = false
                    )
                }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_keyboard_return_24),
                    contentDescription = "Return image",
                )
            }

            Text(text = "Return to Main Screen", fontSize = 22.sp)
        }

        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 24.dp)
        ) {
            Text(text = "Back to Auth Screen", fontSize = 22.sp)
        }

    }
}

