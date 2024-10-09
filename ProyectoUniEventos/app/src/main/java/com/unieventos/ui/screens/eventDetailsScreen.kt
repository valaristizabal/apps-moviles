package com.unieventos.ui.screens

import androidx.compose.foundation.Image
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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.unieventos.R
import com.unieventos.ui.components.TextFieldForm
import com.unieventos.ui.components.navegationBarForm
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun eventDetailsScreen(
    onNavigationToCart: () -> Unit,
    onNavigationToProfile: () -> Unit
){
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
                        Image(
                            painter = painterResource(id = R.drawable.reputation), // Reemplaza 'tu_imagen' con el nombre de tu recurso drawable
                            contentDescription = stringResource(id = R.string.albumImgDescription), // Añade una descripción accesible para la imagen
                            modifier = Modifier
                                .fillMaxWidth(), // O ajusta según necesites el tamaño
                            contentScale = ContentScale.Fit // Esto ajusta la forma en que se escalará la imagen dentro del espacio
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        Text(text = stringResource(id = R.string.eventDescriptionText),
                            color = Color.White)

                        Spacer(modifier = Modifier.height(20.dp))

                        Text(text = stringResource(id = R.string.eventNameText),
                            color = Color.White,
                        textAlign = TextAlign.Start
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        Text(text = stringResource(id = R.string.eventDateText),
                            color = Color.White,
                            textAlign = TextAlign.Start)

                        Spacer(modifier = Modifier.height(20.dp))

                        Text(text = stringResource(id = R.string.eventPriceText),
                            color = Color.White,
                            textAlign = TextAlign.Start)

                    }
                }
                navegationBarForm(
                    onNavigationToProfile = onNavigationToProfile,
                    onNavigationToCart = onNavigationToCart

                )
            }

        }
    }
}