package com.unieventos.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.unieventos.R
import com.unieventos.ui.components.eventCardForm
import com.unieventos.ui.components.navegationBarForm

@Composable
fun recentTransactionsScreen(
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
                horizontalAlignment = Alignment.Start, //no tenemos vertical para que no lo centre
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFF4F2177))

                ) {
                    Text(
                        text = stringResource(id = R.string.recentTransactionsText),
                        color = Color.White,
                        fontSize = 30.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    )

                }
                Row(
                    horizontalArrangement = Arrangement.Start
                ) {
                    eventCardForm(
                        eventName = "Reputation",
                        eventDate = "12 oct 2024",
                        painterResource = painterResource(id = R.drawable.reputation),
                        textButton = "Botón de transacciones recientes ns que va aqu+i",
                        onclick  = onNavigationToCart //aquí se cambia el método de navegación por el correspondiente dan
                    )

                }

                navegationBarForm(
                    onNavigationToProfile = onNavigationToProfile,
                    onNavigationToCart = onNavigationToCart
                )
            }
        }
    }
}