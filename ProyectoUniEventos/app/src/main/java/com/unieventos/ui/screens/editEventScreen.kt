package com.unieventos.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.unieventos.R
import com.unieventos.ui.components.TextFieldForm
import com.unieventos.ui.components.navegationBarForm
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun editEventScreen(
    onNavigationToCart: () -> Unit,
    onNavigationToProfile: () -> Unit,
    onNavigationToCalendar: () -> Unit
){
    var image by rememberSaveable {
        mutableStateOf("")
    }
    var eventName by rememberSaveable {
        mutableStateOf("")
    }
    var description by rememberSaveable {
        mutableStateOf("")
    }

    var dateEvent by rememberSaveable {
        mutableStateOf("")
    }
    var showDatePicker by rememberSaveable { mutableStateOf(false) }
    var datePickerState = rememberDatePickerState()

    var price by rememberSaveable {
        mutableStateOf(0.0)
    }
    Scaffold { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
                    .background(Color(0xFF201c2c)),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .padding(16.dp) //para el alrededor de box
                        .background(
                            color = Color(0xFF10002B),
                            shape = RoundedCornerShape(45.dp)
                        )
                        .verticalScroll(rememberScrollState())
                        .padding(PaddingValues(horizontal = 24.dp, vertical = 60.dp))
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        //nombre del evento
                        TextFieldForm(
                            modifier = Modifier
                                .fillMaxWidth(),
                            value = eventName,
                            onValueChange = { eventName = it },
                            supportingText = stringResource(id = R.string.eventNameValidation),
                            label = stringResource(id = R.string.eventNameLabel),
                            onValidate = { eventName.isEmpty() },
                            keyboardOptions = KeyboardOptions.Default,
                            isPassword = false
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        //descripcion
                        TextFieldForm(
                            modifier = Modifier
                                .fillMaxWidth(),
                            value = description,
                            onValueChange = { description = it },
                            supportingText = stringResource(id = R.string.descriptionValidation),
                            label = stringResource(id = R.string.descriptionLabel),
                            onValidate = { description.length < 10 }, // Ejemplo, longitud mínima de 10 caracteres
                            keyboardOptions = KeyboardOptions.Default,
                            isPassword = false
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        //precio
                        TextFieldForm(
                            modifier = Modifier
                                .fillMaxWidth(),
                            value = price.toString(),
                            onValueChange = {
                                price = it.toDoubleOrNull() ?: 0.0
                            }, // Convierte el texto a un número
                            supportingText = stringResource(id = R.string.numberZeroValidation),
                            label = stringResource(id = R.string.priceLabel),
                            onValidate = { price <= 0 },
                            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                            isPassword = false
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        //fecha del evento
                        TextField(
                            modifier = Modifier
                                .fillMaxWidth(),
                            value = dateEvent,
                            onValueChange = {},
                            readOnly = true,
                            placeholder = {
                                Text(text = stringResource(id = R.string.dateEventLabel))
                            },
                            //icon de los Section
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

                        Button(
                            onClick = {
                                onNavigationToCart()

                            },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF802cbc))
                        ) {
                            Text(text = stringResource(id = R.string.editButton))
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
                                            dateEvent = formattedDate
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
                navegationBarForm(
                    onNavigationToProfile = onNavigationToProfile,
                    onNavigationToCart = onNavigationToCart,
                    onNavigationToCalendar = onNavigationToCalendar

                )
            }

        }

    }
}