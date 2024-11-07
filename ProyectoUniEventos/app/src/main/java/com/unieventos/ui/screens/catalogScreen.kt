package com.unieventos.ui.screens

import android.widget.Toast
import androidx.compose.foundation.background

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.unieventos.model.Event
import com.unieventos.ui.components.eventCardForm
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.unieventos.ui.components.navegationBarForm

@Composable
fun CatalogScreen(
    onNavigationToEventDetail: (String) -> Unit,
    onCategorySelected: (String) -> Unit,
    onNavigationToProfile: () -> Unit,
    onNavigationToCart: () -> Unit,
    onNavigationToCalendar: () -> Unit
) {
    var selectedCategory by remember { mutableStateOf<String?>(null) }

    Scaffold(
        topBar = {
            topBarHomeForm { category ->
                selectedCategory = category // Cambia la categoría seleccionada
            }
        },
        bottomBar = {
            navegationBarForm(
                onNavigationToProfile = onNavigationToProfile,
                onNavigationToCart = onNavigationToCart,
                onNavigationToCalendar = onNavigationToCalendar
            )
        }
    ) { paddingValues ->
        val filteredEvents = getEventsList().filter { event ->
            selectedCategory == null || event.category == selectedCategory
        }

        ListEvents(
            paddingValues = paddingValues,
            events = filteredEvents,
            onNavigationToEventDetail = onNavigationToEventDetail
        )
    }
}



@Composable
fun ListEvents(
    paddingValues: PaddingValues,
    events: List<Event>, // Recibe la lista de eventos filtrados
    onNavigationToEventDetail: (String) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 150.dp),
        contentPadding = paddingValues
    ) {
        items(events) { event ->
            eventCardForm(
                event = event,
                onNavigationToEventDetail = onNavigationToEventDetail
            )
        }
    }
}



    @OptIn(ExperimentalMaterial3Api::class)
@Composable
fun topBarHomeForm(
    onCategorySelected: (String) -> Unit // Callback para manejar selección de categoría
) {
    TopAppBar(
        title = {
            Column {
                Text(text = "Unieventos")

                // Fila con botones de categorías
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp), // Espaciado entre botones
                    modifier = Modifier.padding(top = 8.dp)
                ) {
                    CategoryButton("Teatro", onCategorySelected)
                    CategoryButton("Cine", onCategorySelected)
                    CategoryButton("Deporte", onCategorySelected)
                    CategoryButton("Conciertos", onCategorySelected)
                }
            }
        }
    )
}

@Composable
fun CategoryButton(
    category: String,
    onCategorySelected: (String) -> Unit
) {
    TextButton(
        onClick = { onCategorySelected(category) }, // Llama al callback con la categoría seleccionada
        modifier = Modifier.background(Color(0xFF6200EE), shape = RoundedCornerShape(16.dp)) // Estilo de fondo y bordes
    ) {
        Text(text = category, color = Color.White)
    }
}


fun getEventsList(): List<Event> {
    return listOf(
        Event(
            id = "1",
            name = "Reputation Tour",
            description = "Un evento único en su tipo que celebra el famoso álbum 'Reputation' con una noche llena de energía, luces y música en vivo. ¡No te lo puedes perder!",
            price = 100.0,
            date = "15 Nov 2024",
            city = "Bogotá",
            image = "",
            category = "Conciertos" // Categoría
        ),
        Event(
            id = "2",
            name = "Everlong Tribute",
            description = "Un homenaje a una de las mejores canciones de rock de todos los tiempos. Ven y disfruta de un show lleno de emoción, guitarras y una gran interpretación en vivo.",
            price = 80.0,
            date = "20 Nov 2024",
            city = "Medellín",
            image = "",
            category = "Conciertos" // Categoría
        ),
        Event(
            id = "3",
            name = "Sabrina Carpenter Live",
            description = "Sabrina Carpenter llega a Colombia para dar un concierto inolvidable. Un show íntimo lleno de sus grandes éxitos y una conexión única con el público.",
            price = 120.0,
            date = "25 Nov 2024",
            city = "Cali",
            image = "",
            category = "Conciertos" // Categoría
        ),
        Event(
            id = "4",
            name = "Armenia Jazz Festival",
            description = "El famoso festival de jazz llega a Armenia con artistas de talla internacional y locales. Ven a disfrutar de un fin de semana lleno de música y cultura.",
            price = 50.0,
            date = "5 Dic 2024",
            city = "Armenia",
            image = "",
            category = "Música" // Categoría
        ),
        Event(
            id = "5",
            name = "Festival de Teatro Callejero",
            description = "Disfruta de las mejores obras de teatro al aire libre en el festival de teatro callejero. Perfecto para toda la familia y amantes del arte.",
            price = 20.0,
            date = "10 Dic 2024",
            city = "Cartagena",
            image = "",
            category = "Teatro" // Categoría
        ),
        Event(
            id = "6",
            name = "Paulo Londra",
            description = "El regreso de uno de los mejores competidores de quinto escalón está aquí.",
            price = 20.0,
            date = "24 Dic 2024",
            city = "Armenia",
            image = "",
            category = "Conciertos" // Categoría
        )
    )
}
