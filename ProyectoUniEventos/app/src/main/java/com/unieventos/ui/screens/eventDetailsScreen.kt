package com.unieventos.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.unieventos.R
import com.unieventos.viewModel.EventosViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun eventDetailsScreen(
    eventosViewModel: EventosViewModel = viewModel(), // Usamos viewModel() para obtener una instancia
    eventId: String,
    onBuyClicked: () -> Unit
) {
    // Observamos la lista de eventos desde el ViewModel
    val eventsList = eventosViewModel.getEventsList()

    // Buscamos el evento con el ID proporcionado
    val event = eventsList.find { it.id == eventId }

    Scaffold { padding ->
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
                    .background(Color(0xFF201c2c)),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                if (event != null) {
                    // Muestra los detalles del evento
                    EventContent(image = event.image)

                    // Ajusta el padding en los textos
                    Text(
                        text = "Event name: ${event.name}",
                        modifier = Modifier.padding(8.dp),
                        color = Color.White
                    )
                    Text(
                        text = "Description: ${event.description}",
                        modifier = Modifier.padding(8.dp),
                        color = Color.White
                    )
                    Text(
                        text = "Price: $${event.price}",
                        modifier = Modifier.padding(8.dp),
                        color = Color.White
                    )
                    Text(
                        text = "Date: ${event.date}",
                        modifier = Modifier.padding(8.dp),
                        color = Color.White
                    )
                    Text(
                        text = "City: ${event.city}",
                        modifier = Modifier.padding(8.dp),
                        color = Color.White
                    )

                    Button(
                        onClick = {
                            if (event != null) {
                                eventosViewModel.addToCart(event) // Agregar el evento al carrito
                            }
                            onBuyClicked() // Opcional: manejar navegación después de añadir
                        },
                        modifier = Modifier.padding(16.dp),
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF6200EE),
                            contentColor = Color.White
                        )
                    ) {
                        Text(text = "Add to cart")
                    }

                } else {
                    Text(
                        text = "Event not found",
                        modifier = Modifier.padding(8.dp),
                        color = Color.White
                    )
                }
            }
        }
    }
}

@Composable
fun EventContent(image: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .padding(16.dp)
            .background(Color(0xFF10002B), shape = RoundedCornerShape(45.dp))
            .verticalScroll(rememberScrollState())
            .padding(PaddingValues(horizontal = 24.dp, vertical = 60.dp))
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = rememberImagePainter(data = image), // Carga de imagen con Coil
                contentDescription = stringResource(id = R.string.albumImgDescription),
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop // Ajusta el modo de escalado según necesites
            )
            Spacer(modifier = Modifier.height(20.dp))

            // Otros elementos de contenido pueden ir aquí
        }
    }
}
