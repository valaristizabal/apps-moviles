package com.unieventos.ui.navigation

import kotlinx.serialization.Serializable

sealed class RouterScreen {
    @Serializable
     data object catalogScreen : RouterScreen()
    @Serializable
     data object LoginScreen : RouterScreen()
    @Serializable
     data object UserRegistrationScreen : RouterScreen()
    @Serializable
    data object ForgottenPasswordScreen : RouterScreen()
    @Serializable
    data object shoppingCartScreen : RouterScreen()
    @Serializable
    data object makePurchaseScreen : RouterScreen()
    @Serializable
    data object myProfileScreen : RouterScreen()







}