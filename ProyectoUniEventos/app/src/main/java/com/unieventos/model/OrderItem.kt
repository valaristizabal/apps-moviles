package com.unieventos.model

data class OrderItem(
    val id: String,
    val idEvent: Event,
    val numberTickets: Int,
    val localeName: String,

)
