package com.maxkor.compose_navigation_firebaseauth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.maxkor.compose_navigation_firebaseauth.ui.sceenns.AfterAuthScreen
import com.maxkor.compose_navigation_firebaseauth.ui.sceenns.AuthScreen
import com.maxkor.compose_navigation_firebaseauth.ui.sceenns.MainScreen
import com.maxkor.compose_navigation_firebaseauth.ui.theme.ComposeNavigationFirebaseAuthTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeNavigationFirebaseAuthTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    MainScreen()
//                    AuthScreen()
                    AfterAuthScreen()
                }
            }
        }
    }
}
