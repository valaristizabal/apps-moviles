package com.unieventos.ui.screens

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

@Composable
fun createCuponScreen(){
    var code by rememberSaveable {
        mutableStateOf("")
    }
    var discountPercentage by rememberSaveable {
        mutableStateOf(0)
    }
    var type by rememberSaveable {
        mutableStateOf("")
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
                        // Código
                        TextFieldForm(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color.White),
                            value = code,
                            onValueChange = { code = it },
                            supportingText = stringResource(id = R.string.codeValidation), // Cambia según tu validación
                            label = stringResource(id = R.string.codeLabel), // Cambia según tu etiqueta
                            onValidate = { code.isEmpty() },
                            keyboardOptions = KeyboardOptions.Default,
                            isPassword = false
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        // Porcentaje de descuento
                        TextFieldForm(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color.White),
                            value = discountPercentage.toString(),
                            onValueChange = {
                                discountPercentage = it.toIntOrNull() ?: 0 // Convierte el texto a un número
                            },
                            supportingText = stringResource(id = R.string.discountValidation), // Cambia según tu validación
                            label = stringResource(id = R.string.discountLabel), // Cambia según tu etiqueta
                            onValidate = { discountPercentage < 0 },
                            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                            isPassword = false
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        // Tipo
                        TextFieldForm(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color.White),
                            value = type,
                            onValueChange = { type = it },
                            supportingText = stringResource(id = R.string.typeValidation), // Cambia según tu validación
                            label = stringResource(id = R.string.typeLabel), // Cambia según tu etiqueta
                            onValidate = { type.isEmpty() },
                            keyboardOptions = KeyboardOptions.Default,
                            isPassword = false
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        Button(
                            onClick = { /*TODO*/ },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF802cbc))
                        ) {
                            Text(text = stringResource(id = R.string.saveButton))
                        }

                    }
                }
                navegationBarForm()
            }

        }

    }
}
