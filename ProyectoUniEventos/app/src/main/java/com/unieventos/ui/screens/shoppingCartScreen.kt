package com.unieventos.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.unieventos.R
import com.unieventos.ui.components.eventCardForm
import com.unieventos.ui.components.navegationBarForm
import com.unieventos.viewModel.EventosViewModel

@Composable
fun shoppingCartScreen(
    eventosViewModel: EventosViewModel = viewModel(),
    onNavigationToMakeApurchase: () -> Unit,
    onNavigationToCart: () -> Unit,
    onNavigationToProfile: () -> Unit,
    onNavigationToCalendar: () -> Unit
) {
    // Observamos el carrito
    val cartItems = eventosViewModel.cart.collectAsState().value

    Scaffold(
        bottomBar = {
            Box(modifier = Modifier.navigationBarsPadding()) {
                navegationBarForm(
                    onNavigationToProfile = onNavigationToProfile,
                    onNavigationToCart = onNavigationToCart,
                    onNavigationToCalendar = onNavigationToCalendar
                )
            }
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF201c2c)),
                horizontalAlignment = Alignment.Start,
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFF4F2177))
                ) {
                    Text(
                        text = "Shopping Cart",
                        color = Color.White,
                        fontSize = 30.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    )
                }

                // Mostrar los eventos en el carrito
                if (cartItems.isEmpty()) {
                    Text(
                        text = "Your cart is empty.",
                        color = Color.White,
                        modifier = Modifier.padding(16.dp)
                    )
                } else {
                    Column(modifier = Modifier.padding(16.dp)) {
                        cartItems.forEach { event ->
                            eventCardForm(
                                event = event, // Pasa el evento completo
                                onNavigationToEventDetail = { eventId ->
                                    // Maneja la navegación al detalle del evento
                                }
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Botón para finalizar la compra
                Button(
                    onClick = {
                        if (cartItems.isNotEmpty()) {
                            // Simular compra exitosa
                            onNavigationToMakeApurchase()
                        }
                    },
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    shape = androidx.compose.foundation.shape.RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF6200EE), // Color morado
                        contentColor = Color.White
                    )
                ) {
                    Text(text = "Complete Purchase")
                }
            }
        }
    }
}
