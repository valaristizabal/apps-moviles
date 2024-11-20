package com.unieventos.ui.screens

import android.util.Patterns
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.unieventos.R
import com.unieventos.model.Role
import com.unieventos.model.User
import com.unieventos.ui.components.TextFieldForm
import com.unieventos.ui.components.dropdownMenuForm
import com.unieventos.viewModel.UserViewModel
import java.text.SimpleDateFormat
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserRegistrationScreen(
    userViewModel: UserViewModel = viewModel(),
    onBackClick: () -> Unit
) {
    val cities = listOf("Armenia", "Pereira", "Manizales", "Medellín", "Bogotá")

    var fullName by rememberSaveable { mutableStateOf("") }
    var idNumber by rememberSaveable { mutableStateOf("") }
    var city by rememberSaveable { mutableStateOf("") }
    var birthday by rememberSaveable { mutableStateOf("") }
    var showDatePicker by rememberSaveable { mutableStateOf(false) }
    var address by rememberSaveable { mutableStateOf("") }
    var phoneNumber by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var isSaving by remember { mutableStateOf(false) }

    // Estado del DatePicker
    val datePickerState = rememberDatePickerState()

    // Firebase Firestore instance
    val db = FirebaseFirestore.getInstance()

    // Función para manejar el guardado del usuario
    fun handleSave() {
        if (fullName.isNotEmpty() && idNumber.isNotEmpty() && city.isNotEmpty() &&
            birthday.isNotEmpty() && address.isNotEmpty() && phoneNumber.isNotEmpty() &&
            email.isNotEmpty() && password.isNotEmpty()
        ) {
            isSaving = true // Mostrar progreso
            val newUser = User(
                id = "id-${System.currentTimeMillis()}",
                name = fullName,
                role = Role.CLIENT,
                email = email,
                password = password,
                idNumber = idNumber,
                city = city,
                birthday = birthday,
                address = address,
                phoneNumber = phoneNumber
            )

            // Guardar en Firebase Firestore
            db.collection("users")
                .document(newUser.id) // El ID del documento será único
                .set(newUser)
                .addOnSuccessListener {
                    isSaving = false // Ocultar progreso
                    // Limpiar los campos después de guardar
                    fullName = ""
                    idNumber = ""
                    city = ""
                    birthday = ""
                    address = ""
                    phoneNumber = ""
                    email = ""
                    password = ""
                }
                .addOnFailureListener { exception ->
                    isSaving = false // Ocultar progreso
                    println("Error al guardar el usuario en Firestore: ${exception.message}")
                }
        } else {
            println("Todos los campos son obligatorios")
        }
    }

    Scaffold { padding ->
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.fondo_apps_moviles),
                contentDescription = stringResource(id = R.string.backgroundIconDescription),
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Botón "Regresar"
                Button(
                    onClick = { onBackClick() },
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

                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .padding(16.dp)
                        .background(
                            color = Color(0xFF201c2c),
                            shape = RoundedCornerShape(45.dp)
                        )
                        .verticalScroll(rememberScrollState())
                        .padding(PaddingValues(horizontal = 24.dp, vertical = 60.dp))
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        // Campos de texto para ingresar la información del usuario
                        TextFieldForm(
                            modifier = Modifier.fillMaxWidth(),
                            value = fullName,
                            onValueChange = { fullName = it },
                            supportingText = "Ingrese un nombre válido",
                            label = "Nombre completo",
                            onValidate = { fullName.isEmpty() },
                            isPassword = false,
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        TextFieldForm(
                            modifier = Modifier.fillMaxWidth(),
                            value = idNumber,
                            onValueChange = { idNumber = it },
                            supportingText = stringResource(id = R.string.idNumberValidation),
                            label = stringResource(id = R.string.idNumberLabel),
                            onValidate = { idNumber.length < 1 },
                            isPassword = false,
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        dropdownMenuForm(
                            value = city,
                            onValueChange = { city = it },
                            items = cities
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        TextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = birthday,
                            onValueChange = {},
                            readOnly = true,
                            placeholder = { Text(text = stringResource(id = R.string.birthdayPlaceHolder)) },
                            trailingIcon = {
                                IconButton(onClick = { showDatePicker = true }) {
                                    Icon(
                                        imageVector = Icons.Rounded.DateRange,
                                        contentDescription = stringResource(id = R.string.birthdayIconDescription)
                                    )
                                }
                            }
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        TextFieldForm(
                            modifier = Modifier.fillMaxWidth(),
                            value = address,
                            onValueChange = { address = it },
                            supportingText = stringResource(id = R.string.addressValidation),
                            label = stringResource(id = R.string.addressLabel),
                            onValidate = { address.length < 1 },
                            isPassword = false,
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        TextFieldForm(
                            modifier = Modifier.fillMaxWidth(),
                            value = phoneNumber,
                            onValueChange = { phoneNumber = it },
                            supportingText = stringResource(id = R.string.phoneNumberValidation),
                            label = stringResource(id = R.string.phoneNumberLabel),
                            onValidate = { phoneNumber.length < 1 },
                            isPassword = false,
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        TextFieldForm(
                            modifier = Modifier.fillMaxWidth(),
                            value = email,
                            onValueChange = { email = it },
                            supportingText = stringResource(id = R.string.emailValidation),
                            label = stringResource(id = R.string.emailLabel),
                            onValidate = { !Patterns.EMAIL_ADDRESS.matcher(email).matches() },
                            isPassword = false,
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        TextFieldForm(
                            modifier = Modifier.fillMaxWidth(),
                            value = password,
                            onValueChange = { password = it },
                            supportingText = stringResource(id = R.string.passwordValidation),
                            label = stringResource(id = R.string.passwordLabel),
                            onValidate = { password.length < 6 },
                            isPassword = true,
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        Button(
                            onClick = { handleSave() },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF802cbc))
                        ) {
                            Text(text = stringResource(id = R.string.signUpButton))
                        }

                        if (showDatePicker) {
                            DatePickerDialog(
                                onDismissRequest = { showDatePicker = false },
                                confirmButton = {
                                    TextButton(onClick = {
                                        val selectedDate = datePickerState.selectedDateMillis
                                        if (selectedDate != null) {
                                            val date = Date(selectedDate)
                                            val formattedDate = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(date)
                                            birthday = formattedDate
                                        }
                                        showDatePicker = false
                                    }) {
                                        Text(text = stringResource(id = R.string.confirmButton))
                                    }
                                },
                                dismissButton = {
                                    TextButton(onClick = { showDatePicker = false }) {
                                        Text(text = stringResource(id = R.string.cancelButton))
                                    }
                                }
                            ) {
                                DatePicker(state = datePickerState)
                            }
                        }
                    }
                }
            }
        }
    }
}
