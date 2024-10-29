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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberDatePickerState
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
import com.unieventos.R
import com.unieventos.ui.components.TextFieldForm
import com.unieventos.ui.components.dropdownMenuForm
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserRegistrationScreen() {
    val cities = listOf("Armenia", "Pereira", "Manizales", "Medellín", "Bogotá")

    var fullName by rememberSaveable { mutableStateOf("") }
    var idNumber by rememberSaveable { mutableStateOf("") }
    var city by rememberSaveable { mutableStateOf("") }
    var birthday by rememberSaveable { mutableStateOf("") }
    var showDatePicker by rememberSaveable { mutableStateOf(false)}
    var datePickerState = rememberDatePickerState()
    var address by rememberSaveable { mutableStateOf("") }
    var phoneNumber by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }


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
                        TextFieldForm(
                            modifier = Modifier
                                .fillMaxWidth(),
                            value = fullName,
                            onValueChange = {
                                fullName = it
                            },
                            supportingText = stringResource(id = R.string.fullNameValidation),
                            label = stringResource(id = R.string.fullnameLabel),
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
                            value = idNumber,
                            onValueChange = {
                                idNumber = it
                            },
                            supportingText = stringResource(id = R.string.idNumberValidation),
                            label = stringResource(id = R.string.idNumberLabel),
                            onValidate = {
                                idNumber.length < 1
                            },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                            isPassword = false
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        //composable
                        dropdownMenuForm(
                            value = city,
                            onValueChange = {
                                city = it
                            },
                            items = cities)

                        Spacer(modifier = Modifier.height(20.dp))

                        TextField(
                            modifier = Modifier
                                .fillMaxWidth(),
                            value = birthday,
                            onValueChange = {},
                            readOnly = true,
                            placeholder = {
                                Text(text = stringResource(id = R.string.birthdayPlaceHolder))
                            },
                            //icon de los Section
                            trailingIcon = {
                                IconButton(onClick = { showDatePicker = true }) {
                                    Icon(
                                        imageVector = Icons.Rounded.DateRange,
                                        contentDescription = stringResource(id = R.string.birthdayIconDescription))
                                }
                            }
                        )
                        
                        Spacer(modifier = Modifier.height(20.dp))

                        TextFieldForm(
                            modifier = Modifier
                                .fillMaxWidth(),
                            value = address,
                            onValueChange = {
                                address = it
                            },
                            supportingText = stringResource(id = R.string.addressValidation),
                            label = stringResource(id = R.string.addressLabel),
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
                            supportingText = stringResource(id = R.string.phoneNumberValidation),
                            label = stringResource(id = R.string.phoneNumberLabel),
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
                                .fillMaxWidth(),
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
                            onClick = { /*TODO*/ },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF802cbc))
                        ) {
                            Text(text = stringResource(id = R.string.signUpButton))
                        }

                        if(showDatePicker){
                            DatePickerDialog(
                                onDismissRequest = {showDatePicker = false},
                                confirmButton = {
                                    TextButton(onClick = {
                                        val selectedDate = datePickerState.selectedDateMillis

                                        if(selectedDate != null){
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
                                    TextButton(onClick = {
                                        showDatePicker = false
                                    }) {
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