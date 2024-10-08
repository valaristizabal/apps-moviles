package com.unieventos.ui.screens

import android.content.Context
import android.util.Patterns
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.unieventos.R
import com.unieventos.ui.components.TextFieldForm
@Composable
fun LoginScreen(onNavigationToSingUp: () -> Unit) {
    val context = LocalContext.current

    Scaffold { padding ->
        LoginForm(
            padding= padding,
            context= context,
            onNavigationToSingUp = onNavigationToSingUp
        )
    }
}

@Composable
fun LoginForm(
    padding: PaddingValues,
    context: Context,
    onNavigationToSingUp: () -> Unit
) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    var emailError by rememberSaveable {
        mutableStateOf(false)
    }

    var passwordError by rememberSaveable {
        mutableStateOf(false)
    }

    Scaffold { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.fondo_apps_moviles),
                contentDescription = stringResource(id = R.string.backgroundIconDescription),
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .padding(16.dp)
                        .background(
                            color = Color(0xFF201c2c),
                            shape = RoundedCornerShape(45.dp)
                        )
                        .padding(PaddingValues(horizontal = 24.dp, vertical = 60.dp))
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        TextFieldForm(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color.White),
                            value = email,
                            onValueChange = {
                                email = it
                            },
                            supportingText = stringResource(id = R.string.emailValidation),
                            label = stringResource(id = R.string.emailLabel),
                            onValidate = {
                                !Patterns.EMAIL_ADDRESS.matcher(email).matches()
                            },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                            isPassword = false
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        TextFieldForm(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color.White),
                            value = password,
                            onValueChange = {
                                password = it
                            },
                            supportingText = stringResource(id = R.string.passwordValidation),
                            label = stringResource(id = R.string.passwordLabel),
                            onValidate = {
                                password.length < 6
                            },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                            isPassword = true
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        Button(
                            enabled = email.isNotEmpty() && password.isNotEmpty() && !emailError && !passwordError,
                            onClick = {
                                // Acción de login
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF802cbc))
                        ) {
                            Text(text = stringResource(id = R.string.loginButton))
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        TextButton(
                            onClick = {
                                onNavigationToSingUp()

                            }
                        ) {
                            Text(
                                text = stringResource(id = R.string.forgottenPasswordTextButton),
                                color = Color.White
                            )
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        TextButton(
                            onClick = {
                            }
                        ) {
                            Text(
                                text = stringResource(id = R.string.newUserTextBuutton),
                                color = Color.White
                            )
                        }
                    }
                }
            }
        }
    }
}
