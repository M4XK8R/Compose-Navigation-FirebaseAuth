package com.maxkor.compose_navigation_firebaseauth.data

import android.app.Activity
import android.content.Context
import android.util.Log
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.Identity
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await

private const val TAG = "global"

private const val CLIENT_ID =
    "545541722171-24t6bj8d3317rcugiah0lpao6u8iqvvk.apps.googleusercontent.com"

class FireAuthHelper(
    private val context: Context,
    private val goToNextScreen: (() -> Unit)? = null
) {

    private val auth = Firebase.auth
    private val oneTapClient = Identity.getSignInClient(context)

    suspend fun signIn(
        launcher: ActivityResultLauncher<IntentSenderRequest>
    ) {
        val signInRequest = BeginSignInRequest.builder()
            .setGoogleIdTokenRequestOptions(
                BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                    .setSupported(true)
                    .setServerClientId(CLIENT_ID)
                    // Only show accounts previously used to sign in.
                    .setFilterByAuthorizedAccounts(false)
                    .build()
            )
            // Automatically sign in when exactly one credential is retrieved.
            .setAutoSelectEnabled(false)
            .build()

        try {
            val result = oneTapClient
                .beginSignIn(signInRequest)
                .await()

            val intentSenderRequest = IntentSenderRequest
                .Builder(result.pendingIntent)
                .build()

            launcher.launch(intentSenderRequest)

        } catch (e: Exception) {
            // No saved credentials found
            Log.d(TAG, e.message.toString())
        }
    }

    fun handleLauncherResult(result: ActivityResult) {

        if (result.resultCode != Activity.RESULT_OK) {

            if (result.data?.action == ActivityResultContracts
                    .StartIntentSenderForResult
                    .ACTION_INTENT_SENDER_REQUEST
            ) {
                val exception = result.data?.getSerializableExtra(
                    ActivityResultContracts
                        .StartIntentSenderForResult
                        .EXTRA_SEND_INTENT_EXCEPTION
                ) as Error

                Log.e(
                    TAG, "Couldn't start One Tap UI:" +
                            " ${exception.localizedMessage}"
                )
            }
            return
        }

        val credential = oneTapClient
            .getSignInCredentialFromIntent(result.data)

        val idToken = credential.googleIdToken
        if (idToken != null) {
            // Got an ID token from Google. Use it to authenticate with your backend.
            Log.d(TAG, idToken)

            val firebaseCredential = GoogleAuthProvider
                .getCredential(idToken, null)

            auth.signInWithCredential(firebaseCredential)
                .addOnCompleteListener(context as Activity) { task ->
                    if (task.isSuccessful) {
                        Log.d(TAG, "signInWithCredential:success")
                        goToNextScreen?.invoke()
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(
                            TAG, "signInWithCredential:failure",
                            task.exception
                        )
                        TODO()
                    }
                }
        } else {
            Log.d(TAG, "Null Token")
        }
    }

}




