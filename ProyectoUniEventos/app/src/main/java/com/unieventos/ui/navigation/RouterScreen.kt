package com.unieventos.ui.navigation

import kotlinx.serialization.Serializable

sealed class RouterScreen {
    @Serializable
     data object catalogScreen : RouterScreen()
    @Serializable
     data object LoginScreen : RouterScreen()
    @Serializable
     data object userRegistrationScreen : RouterScreen()
}