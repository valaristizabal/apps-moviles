package com.unieventos.ui.screens

import android.util.Patterns
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.unieventos.R
import com.unieventos.ui.components.TextFieldForm

@Composable
fun ForgottenPasswordScreen(navController: NavController) {
    var email by rememberSaveable { mutableStateOf("") }
    var isValidEmail by rememberSaveable { mutableStateOf(true) }

    Scaffold { padding ->
        Box(modifier = Modifier.fillMaxSize()) {
            // Fondo de imagen
            Image(
                painter = painterResource(id = R.drawable.fondo_apps_moviles),
                contentDescription = "Imagen de fondo",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            // Contenido principal
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Botón "Regresar" en la parte superior
                Button(
                    onClick = { navController.navigateUp() },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Regresar",
                        color = Color.White
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Caja del formulario
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .background(
                            color = Color(0xFF201c2c),
                            shape = RoundedCornerShape(45.dp)
                        )
                        .padding(horizontal = 24.dp, vertical = 60.dp)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        // Campo de correo
                        TextFieldForm(
                            value = email,
                            onValueChange = {
                                email = it
                                isValidEmail = Patterns.EMAIL_ADDRESS.matcher(email).matches()
                            },
                            supportingText = if (!isValidEmail) "Correo no válido" else "",
                            label = "Correo",
                            onValidate = { !isValidEmail },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                            isPassword = false
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        // Botón de recuperación de contraseña
                        Button(
                            onClick = { /* Lógica de recuperación */ },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF802cbc)),
                            enabled = isValidEmail
                        ) {
                            Text(text = "Recuperar contraseña")
                        }
                    }
                }
            }
        }
    }
}
