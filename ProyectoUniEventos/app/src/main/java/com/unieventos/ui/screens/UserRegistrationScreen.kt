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
fun UserRegistrationScreen(userViewModel: UserViewModel = viewModel()) {
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

    // Estado del DatePicker
    val datePickerState = rememberDatePickerState()

    // Función para manejar el guardado del usuario
    fun handleSave() {
        if (fullName.isNotEmpty() && idNumber.isNotEmpty() && city.isNotEmpty() &&
            birthday.isNotEmpty() && address.isNotEmpty() && phoneNumber.isNotEmpty() &&
            email.isNotEmpty() && password.isNotEmpty()) {

            // Crear el usuario
            val newUser = User(
                id = "id-${System.currentTimeMillis()}", // Generar un ID único
                name = fullName,
                role = Role.CLIENT, // Aquí puedes asignar un rol específico
                email = email,
                password = password,
                idNumber = idNumber,
                city = city,
                birthday = birthday,
                address = address,
                phoneNumber = phoneNumber
            )

            // Llamar a la función addUser del ViewModel
            userViewModel.addUser(newUser)

            // Limpiar los campos después de guardar
            fullName = ""
            idNumber = ""
            city = ""
            birthday = ""
            address = ""
            phoneNumber = ""
            email = ""
            password = ""
        } else {
            // Aquí podrías agregar un mensaje de error si los campos no están completos
            // Como un Snackbar que indique que todos los campos deben ser llenados.
        }
    }

    Scaffold { padding ->
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
                    .padding(padding)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .padding(16.dp) //para el alrededor de box
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
                            supportingText = stringResource(id = R.string.fullNameValidation),
                            label = stringResource(id = R.string.fullnameLabel),
                            onValidate = { fullName.length < 1 },
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
