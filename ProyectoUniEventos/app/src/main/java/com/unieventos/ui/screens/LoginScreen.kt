package com.unieventos.ui.screens

import android.util.Patterns
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.unieventos.R
import com.unieventos.ui.components.TextFieldForm

@Composable
fun LoginScreen() {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    var emailError by rememberSaveable {
        mutableStateOf(false)
    }

    var passwordError by rememberSaveable {
        mutableStateOf(false)
    }

    Scaffold { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.fondo_apps_moviles),
                contentDescription = "imagen de fondo",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .padding(16.dp) //para el alrededor de box
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
                            supportingText = "El correo debe estar en un formato válido",
                            label = "Correo",
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
                            supportingText = "La contraseña debe tener al menos 6 caracteres",
                            label = "Contraseña",
                            onValidate = {
                                password.length < 6
                            },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                            isPassword = true
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        Button(
                            enabled = email.isNotEmpty() && password.isNotEmpty() && !emailError && !passwordError,
                            onClick = { /*TODO*/ },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF802cbc))
                        ) {
                            Text(text = "LOGIN")
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        Text(
                            text = "Forget the password? Click here",
                            color = Color.White
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        Text(
                            text = "New user? Create an account here",
                            color = Color.White
                        )
                    }
                }

            }
        }
    }
}
