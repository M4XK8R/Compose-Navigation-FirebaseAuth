package com.maxkor.compose_navigation_firebaseauth.ui.sceenns

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maxkor.compose_navigation_firebaseauth.R
import com.maxkor.compose_navigation_firebaseauth.ui.theme.ComposeNavigationFirebaseAuthTheme

@Composable
fun AuthScreen() {

    Box(contentAlignment = Alignment.Center) {

        Column {

            IconButton(onClick = { /*TODO*/ }) {
                Image(
                    painter = painterResource(id = R.drawable.ic_google_48),
                    contentDescription = "Google auth image",
                    modifier = Modifier.size(256.dp)
                )
            }

            Text(text = "Auth", fontSize = 22.sp)
        }

        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 24.dp)
        ) {
            Text(text = "Back to Main Screen", fontSize = 22.sp)
        }

    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewAuth() {
    ComposeNavigationFirebaseAuthTheme {
        AuthScreen()
    }
}