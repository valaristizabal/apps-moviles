package com.unieventos.ui.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.unieventos.R
import com.unieventos.ui.components.TextFieldForm
import com.unieventos.ui.components.filterCatalogButtonForm
import com.unieventos.ui.components.navegationBarForm

@Composable
fun catalogScreen() {
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
                horizontalAlignment = Alignment.End, //no tenemos vertical para que no lo centre
            ) {
                Row(
                    modifier = Modifier
                        .padding(16.dp)

                ) {
                    TextField(
                        modifier = Modifier
                            .background(Color.White, shape = RoundedCornerShape(16.dp)),

                        value = busquedad,
                        singleLine = true,
                        onValueChange = { valor ->
                            busquedad = valor
                        },
                        label = {
                            Text(text = stringResource(id = R.string.searchLabel))
                        }
                    )
                    Spacer(modifier = Modifier.width(8.dp))

                    IconButton(

                        onClick = {
                            Toast.makeText(context, searchOnClick, Toast.LENGTH_SHORT).show()
                        })
                    {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = stringResource(id = R.string.searchLabel),
                            tint = Color.White,
                            modifier = Modifier.size(32.dp)
                        )
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFF201c2c))
                        .horizontalScroll(scrollState),
                    horizontalArrangement = Arrangement.Center
                ) {
                    filterCatalogButtonForm(
                        textButton = stringResource(id = R.string.concertFilter),
                        messageOnClick = stringResource(id = R.string.messageOnClickFilter)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    filterCatalogButtonForm(
                        textButton = stringResource(id = R.string.theaterFilter),
                        messageOnClick = stringResource(id = R.string.messageOnClickFilter)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    filterCatalogButtonForm(
                        textButton = stringResource(id = R.string.sportsFilter),
                        messageOnClick = stringResource(id = R.string.messageOnClickFilter)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    filterCatalogButtonForm(
                        textButton = stringResource(id = R.string.cinemaFilter),
                        messageOnClick = stringResource(id = R.string.messageOnClickFilter)
                    )
                }

                navegationBarForm()
            }
        }
    }
}

