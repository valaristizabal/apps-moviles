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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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

@Composable
fun createLocalityScreen(
    onNavigationToCart: () -> Unit,
    onNavigationToProfile: () -> Unit,
    onNavigationToCalendar: () -> Unit
){
    var name by rememberSaveable {
        mutableStateOf("")
    }
    var price by rememberSaveable {
        mutableStateOf(0.0)
    }
    var maxCapacity by rememberSaveable {
        mutableStateOf(0)
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
                        // Nombre
                        TextFieldForm(
                            modifier = Modifier.fillMaxWidth(),
                            value = name,
                            onValueChange = { name = it },
                            supportingText = stringResource(id = R.string.nameValidation),
                            label = stringResource(id = R.string.nameLabel),
                            onValidate = { name.isEmpty() },
                            keyboardOptions = KeyboardOptions.Default,
                            isPassword = false
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        // Precio

                        TextFieldForm(
                            modifier = Modifier
                                .fillMaxWidth(),
                            value = price.toString(),
                            onValueChange = {
                                price = it.toDoubleOrNull() ?: 0.0
                            }, // Convierte el texto a un número
                            supportingText = stringResource(id = R.string.numberZeroValidation),
                            label = stringResource(id = R.string.priceLocalityLabel),
                            onValidate = { price <= 0 },
                            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                            isPassword = false
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        // Capacidad máxima
                        TextFieldForm(
                            modifier = Modifier.fillMaxWidth(),
                            value = maxCapacity.toString(),
                            onValueChange = {
                                maxCapacity = it.toIntOrNull() ?: 0
                                            },
                            supportingText = stringResource(id = R.string.maxCapacityValidation),
                            label = stringResource(id = R.string.maxCapacityLabel),
                            onValidate = { maxCapacity <= 0 },
                            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
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
                navegationBarForm(
                    onNavigationToProfile = onNavigationToProfile,
                    onNavigationToCart = onNavigationToCart,
                    onNavigationToCalendar = onNavigationToCalendar
                )
            }

        }

    }
}
