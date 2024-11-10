package com.unieventos.viewModel

import androidx.lifecycle.ViewModel
import com.unieventos.model.Event
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class EventosViewModel : ViewModel() {

    // Usar MutableStateFlow para emitir cambios de estado
    private val _eventos = MutableStateFlow(getEventsList())
    val eventos: StateFlow<List<Event>> = _eventos

    fun getEventById(eventId: String): Event? {
        return _eventos.value.find { it.id == eventId }
    }

    fun createEvent(event: Event) {
        // Añadir el evento a la lista
        _eventos.value = _eventos.value + event
    }

    fun deleteEvent(event: Event) {
        // Eliminar el evento de la lista
        _eventos.value = _eventos.value.filter { it.id != event.id }
    }

    fun updateEvent(event: Event) {
        // Buscar el evento en la lista y actualizarlo
        val updatedEvents = _eventos.value.map {
            if (it.id == event.id) event else it
        }
        _eventos.value = updatedEvents
    }

    fun searchEvents(query: String): List<Event> {
        return _eventos.value.filter { it.name.contains(query, ignoreCase = true) }
    }

    // Lista de eventos inicial
    private fun getEventsList(): List<Event> {
        return listOf(
            Event(
                id = "1",
                name = "Reputation Tour",
                description = "Un evento único en su tipo que celebra el famoso álbum 'Reputation' con una noche llena de energía, luces y música en vivo. ¡No te lo puedes perder!",
                price = 100.0,
                date = "15 Nov 2024",
                city = "Bogotá",
                image = "",
                category = "Conciertos"
            ),
            Event(
                id = "2",
                name = "Everlong Tribute",
                description = "Un homenaje a una de las mejores canciones de rock de todos los tiempos. Ven y disfruta de un show lleno de emoción, guitarras y una gran interpretación en vivo.",
                price = 80.0,
                date = "20 Nov 2024",
                city = "Medellín",
                image = "",
                category = "Conciertos"
            ),
            Event(
                id = "3",
                name = "Sabrina Carpenter Live",
                description = "Sabrina Carpenter llega a Colombia para dar un concierto inolvidable. Un show íntimo lleno de sus grandes éxitos y una conexión única con el público.",
                price = 120.0,
                date = "25 Nov 2024",
                city = "Cali",
                image = "",
                category = "Conciertos"
            ),
            Event(
                id = "4",
                name = "Armenia Jazz Festival",
                description = "El famoso festival de jazz llega a Armenia con artistas de talla internacional y locales. Ven a disfrutar de un fin de semana lleno de música y cultura.",
                price = 50.0,
                date = "5 Dic 2024",
                city = "Armenia",
                image = "",
                category = "Música"
            ),
            Event(
                id = "5",
                name = "Festival de Teatro Callejero",
                description = "Disfruta de las mejores obras de teatro al aire libre en el festival de teatro callejero. Perfecto para toda la familia y amantes del arte.",
                price = 20.0,
                date = "10 Dic 2024",
                city = "Cartagena",
                image = "",
                category = "Teatro"
            ),
            Event(
                id = "6",
                name = "Paulo Londra",
                description = "El regreso de uno de los mejores competidores de quinto escalón está aquí.",
                price = 20.0,
                date = "24 Dic 2024",
                city = "Armenia",
                image = "",
                category = "Conciertos"
            )
        )
    }
}
