package com.unieventos.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun eventCardForm(
    eventName: String,
    eventDate: String,
    painterResource: Painter,
    onNavigationToCart: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth(0.55f) // Reduce el ancho para que sea un poco más pequeño
            .padding(8.dp) // Reduce el padding alrededor del Box
            .background(
                color = Color(0xFF10002B),
                shape = RoundedCornerShape(30.dp) // Reduce el radio de las esquinas
            )
            .padding(PaddingValues(horizontal = 16.dp, vertical = 12.dp)) // Ajusta el padding interno
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource,
                contentDescription = eventName,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp) // Ajusta la altura según sea necesario
                    .clip(RoundedCornerShape(45.dp)), // Clipping para esquinas redondeadas
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Event Name: $eventName",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 4.dp)
            )
            Text(
                text = "Date: $eventDate",
                color = Color.LightGray,
                modifier = Modifier.padding(vertical = 4.dp)
            )
            Button(
                onClick = {
                    onNavigationToCart()
                },
                modifier = Modifier.padding(vertical = 8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6200EE))
            ) {
                Text(text = "Añadir al carrito")
            }
        }
    }
}
