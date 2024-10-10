package com.unieventos.ui.components

import android.widget.Toast
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

@Composable
fun filterCatalogButtonForm(
    textButton: String,
    onClick: () -> Unit,


){
    val context = LocalContext.current
    Button(onClick = {
        onClick()
         },
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF7b2cbf))
    ) {
        Text(text = textButton)
    }
}