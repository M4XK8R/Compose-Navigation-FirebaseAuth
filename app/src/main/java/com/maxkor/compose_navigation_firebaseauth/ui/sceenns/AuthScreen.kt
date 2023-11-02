package com.maxkor.compose_navigation_firebaseauth.ui.sceenns

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.maxkor.compose_navigation_firebaseauth.R
import com.maxkor.compose_navigation_firebaseauth.data.FireAuthHelper
import kotlinx.coroutines.launch

@Composable
fun AuthScreen(navController: NavHostController, goToNextScreen: (() -> Unit)? = null) {

    val context = LocalContext.current

    val fireAuthHelper = FireAuthHelper(context, goToNextScreen)

    val launcher =
        rememberLauncherForActivityResult(
            ActivityResultContracts.StartIntentSenderForResult()
        ) { result ->
            fireAuthHelper.handleLauncherResult(result)
        }

    val scope = rememberCoroutineScope()

    Box(contentAlignment = Alignment.Center) {

        Column {

            IconButton(
                onClick = {
                    scope.launch {
                        fireAuthHelper.signIn(launcher)
                    }
                    //                    navController.navigate(Routes.AfterAuthScreen.route)
                }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_google_48),
                    contentDescription = "Google auth image",
                    modifier = Modifier.size(256.dp)
                )
            }

            Text(text = "Auth", fontSize = 22.sp)
        }

        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 24.dp)
        ) {
            Text(text = "Back to Main Screen", fontSize = 22.sp)
        }

    }
}
