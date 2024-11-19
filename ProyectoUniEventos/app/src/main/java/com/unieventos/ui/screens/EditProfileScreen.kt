package com.unieventos.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.unieventos.viewModel.ProfileViewModel
import com.unieventos.ui.components.TextFieldForm
import com.unieventos.ui.components.navegationBarForm

@Composable
fun EditProfileScreen(profileViewModel: ProfileViewModel = viewModel()) {
    Scaffold(
        bottomBar = {
            // Barra de navegación al final de la pantalla
            Box(modifier = Modifier.navigationBarsPadding()) { // Asegura que respete los botones del sistema
                navegationBarForm(
                    onNavigationToProfile = { /* Acción para perfil */ },
                    onNavigationToCart = { /* Acción para carrito */ },
                    onNavigationToCalendar = { /* Acción para calendario */ }
                )
            }
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding) // Asegura que el contenido no se solape con la barra de navegación
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 16.dp) // Ajuste adicional para separar del top
                    .background(Color(0xFF201c2c)),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top // Cambié el verticalArrangement a Top para evitar que se centre
            ) {
                Text(
                    text = "Editar Perfil",
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.White,
                    modifier = Modifier.padding(16.dp)
                )
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
                        verticalArrangement = Arrangement.Top
                    ) {
                        TextFieldForm(
                            modifier = Modifier.fillMaxWidth(),
                            value = profileViewModel.fullName,
                            onValueChange = { profileViewModel.fullName = it },
                            supportingText = "Nombre no válido",
                            label = "Nombre Completo",
                            onValidate = { !profileViewModel.isFullNameValid() },
                            keyboardOptions = KeyboardOptions.Default,
                            isPassword = false
                        )
                        Spacer(modifier = Modifier.height(20.dp))

                        TextFieldForm(
                            modifier = Modifier.fillMaxWidth(),
                            value = profileViewModel.address,
                            onValueChange = { profileViewModel.address = it },
                            supportingText = "Dirección no válida",
                            label = "Dirección",
                            onValidate = { !profileViewModel.isAddressValid() },
                            keyboardOptions = KeyboardOptions.Default,
                            isPassword = false
                        )
                        Spacer(modifier = Modifier.height(20.dp))

                        TextFieldForm(
                            modifier = Modifier.fillMaxWidth(),
                            value = profileViewModel.phoneNumber,
                            onValueChange = { profileViewModel.phoneNumber = it },
                            supportingText = "Teléfono no válido",
                            label = "Número de Teléfono",
                            onValidate = { !profileViewModel.isPhoneNumberValid() },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                            isPassword = false
                        )
                        Spacer(modifier = Modifier.height(20.dp))

                        TextFieldForm(
                            modifier = Modifier.fillMaxWidth(),
                            value = profileViewModel.email,
                            onValueChange = { profileViewModel.email = it },
                            supportingText = "Correo no válido",
                            label = "Correo Electrónico",
                            onValidate = { !profileViewModel.isEmailValid() },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                            isPassword = false
                        )
                        Spacer(modifier = Modifier.height(20.dp))

                        TextFieldForm(
                            modifier = Modifier.fillMaxWidth(),
                            value = profileViewModel.password,
                            onValueChange = { profileViewModel.password = it },
                            supportingText = "Contraseña no válida",
                            label = "Contraseña",
                            onValidate = { !profileViewModel.isPasswordValid() },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                            isPassword = true
                        )
                        Spacer(modifier = Modifier.height(20.dp))

                        Button(
                            onClick = { /* Guardar cambios */ },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF802cbc))
                        ) {
                            Text(text = "Guardar Cambios")
                        }
                    }
                }
            }
        }
    }
}

