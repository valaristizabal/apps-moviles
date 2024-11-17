package com.unieventos.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.unieventos.model.Event
import com.unieventos.ui.components.eventCardForm
import com.unieventos.ui.components.navegationBarForm
import com.unieventos.viewModel.EventosViewModel

@Composable
fun CatalogScreen(
    eventosViewModel: EventosViewModel,
    onNavigationToEventDetail: (String) -> Unit,
    onNavigationToProfile: () -> Unit,
    onNavigationToCart: () -> Unit,
    onNavigationToCalendar: () -> Unit
) {
    val events by eventosViewModel.eventos.collectAsState()
    var selectedCategory by remember { mutableStateOf<String?>(null) }

    Scaffold(
        topBar = {
            topBarHomeForm(
                categories = listOf("Conciertos", "Teatro", "Música"), // Categorías predefinidas
                onCategorySelected = { selectedCategory = it }
            )
        },
        bottomBar = {
            Box(modifier = Modifier.navigationBarsPadding()) {
                navegationBarForm(
                    onNavigationToProfile = onNavigationToProfile,
                    onNavigationToCart = onNavigationToCart,
                    onNavigationToCalendar = onNavigationToCalendar
                )
            }
        }
    ) { paddingValues ->
        val filteredEvents = events.filter { event ->
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
    events: List<Event>,
    onNavigationToEventDetail: (String) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 150.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(events) { event ->
            eventCardForm(
                event = event,
                onNavigationToEventDetail = onNavigationToEventDetail,

            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun topBarHomeForm(
    categories: List<String>,
    onCategorySelected: (String) -> Unit
) {
    TopAppBar(
        title = {
            Column {
                Text(text = "Unieventos")
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.padding(top = 8.dp)
                ) {
                    categories.forEach { category ->
                        CategoryButton(category, onCategorySelected)
                    }
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
        onClick = { onCategorySelected(category) },
        modifier = Modifier
            .background(Color(0xFF6200EE), shape = RoundedCornerShape(16.dp))
    ) {
        Text(text = category, color = Color.White)
    }
}
