package com.unieventos.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.unieventos.ui.components.navegationBarForm

@Composable
fun editEventScreen(){
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
                horizontalAlignment = Alignment.End, //no tenemos vertical para que no lo centre
            ) {
                Row(
                    modifier = Modifier
                        .padding(16.dp)

                ){

                    navegationBarForm()
                }
            }
        }
    }
}