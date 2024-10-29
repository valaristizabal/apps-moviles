package com.unieventos.ui.screens

import android.util.Patterns
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.unieventos.R
import com.unieventos.ui.components.TextFieldForm

@Composable
fun EditProfileScreen() {
    var fullName by rememberSaveable { mutableStateOf("") }
    var address by rememberSaveable { mutableStateOf("") }
    var phoneNumber by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    Scaffold { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
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
                                .fillMaxWidth(),
                            value = fullName,
                            onValueChange = {
                                fullName = it
                            },
                            supportingText = "El nombre no pued estar vacío",
                            label = "Nombre completo",
                            onValidate = {
                                fullName.length < 1
                            },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                            isPassword = false
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        TextFieldForm(
                            modifier = Modifier
                                .fillMaxWidth(),
                            value = address,
                            onValueChange = {
                                address = it
                            },
                            supportingText = "La dirección no puede estar vacía",
                            label = "Dirección",
                            onValidate = {
                                address.length < 1
                            },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                            isPassword = false
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        TextFieldForm(
                            modifier = Modifier
                                .fillMaxWidth(),
                            value = phoneNumber,
                            onValueChange = {
                                phoneNumber = it
                            },
                            supportingText = "El número de teléfono no puede estar vacío",
                            label = "Número de teléfono",
                            onValidate = {
                                phoneNumber.length < 1
                            },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                            isPassword = false
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        TextFieldForm(
                            modifier = Modifier
                                .fillMaxWidth(),
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
                                .fillMaxWidth(),
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
                            onClick = { /*TODO*/ },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF802cbc))
                        ) {
                            Text(text = "SAVE CHANGE")
                        }
                    }
                }
            }
        }
    }
}