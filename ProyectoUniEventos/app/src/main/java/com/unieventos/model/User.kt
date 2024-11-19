package com.unieventos.model

data class User(
    val id: String,
    val name: String,
    val role: Role,
    val email: String,
    val password: String,
    val idNumber: String,
    val city: String,
    val birthday: String,
    val address: String,
    val phoneNumber: String
)
