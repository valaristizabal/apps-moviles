package com.unieventos.model

import java.util.Date

data class Event(
    val id: String,
    val name: String,
    val description: String,
    val price: Double,
    val date: String,
    val city: String,
    val image: String,
    val category: String // Nueva propiedad para categorizar el evento
)
