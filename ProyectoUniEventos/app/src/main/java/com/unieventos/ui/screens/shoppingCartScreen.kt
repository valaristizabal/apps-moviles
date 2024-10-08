package com.unieventos.ui.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.unieventos.R
import com.unieventos.ui.components.filterCatalogButtonForm
import com.unieventos.ui.components.navegationBarForm

@Composable
fun shoppingCartScreen(){
    var busquedad by rememberSaveable { mutableStateOf("") }
    val context = LocalContext.current
    val scrollState = remember { androidx.compose.foundation.ScrollState(0) }
    val searchOnClick = stringResource(id = R.string.searchOnClick)
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
                horizontalAlignment = Alignment.CenterHorizontally, //no tenemos vertical para que no lo centre
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .background(Color(0xFF4F2177))

                ) {
                    Text(
                        text = stringResource(id = R.string.cardText),
                        color = Color.White, // Color blanco
                        fontSize = 20.sp, // Tamaño de la fuente ajustado (puedes cambiarlo)
                        textAlign = TextAlign.Center, // Centra el texto
                        modifier = Modifier.fillMaxWidth() // Para asegurarse de que se centre horizontalmente
                    )

                }
                navegationBarForm()
            }
        }
    }
}