package com.unieventos.ui.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.unieventos.ui.screens.CatalogScreen
import com.unieventos.ui.screens.ForgottenPasswordScreen
import com.unieventos.ui.screens.LoginScreen
import com.unieventos.ui.screens.UserRegistrationScreen
import com.unieventos.ui.screens.eventDetailsScreen
import com.unieventos.ui.screens.makePurchaseScreen
import com.unieventos.ui.screens.myProfileScreen
import com.unieventos.ui.screens.shoppingCartScreen
import com.unieventos.viewModel.EventosViewModel

@Composable
fun Navigation( eventosViewModel: EventosViewModel) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = RouterScreen.catalogScreen::class.java.simpleName
    ) {
        composable(RouterScreen.LoginScreen::class.java.simpleName) {
            LoginScreen(
                onNavigationToSingUp = {
                    navController.navigate(RouterScreen.UserRegistrationScreen::class.java.simpleName)
                },
                onNavigationToForgottenPassword = {
                    navController.navigate(RouterScreen.ForgottenPasswordScreen::class.java.simpleName)
                },
                onNavigationToHome = {
                    navController.navigate(RouterScreen.catalogScreen::class.java.simpleName) {
                        popUpTo(0) { inclusive = true }
                        launchSingleTop = true
                    }
                }
            )
        }

        composable(RouterScreen.ForgottenPasswordScreen::class.java.simpleName) {
            ForgottenPasswordScreen()
        }

        composable(RouterScreen.UserRegistrationScreen::class.java.simpleName) {
            UserRegistrationScreen()
        }

        composable(RouterScreen.catalogScreen::class.java.simpleName) {
            CatalogScreen(

                onNavigationToEventDetail = { eventId ->
                    navController.navigate("eventDetails/$eventId")
                },
                onCategorySelected = { category ->
                    // Aquí puedes agregar el manejo de categorías
                },
                onNavigationToProfile = {
                    navController.navigate(RouterScreen.myProfileScreen::class.java.simpleName)
                },
                onNavigationToCart = {
                    navController.navigate(RouterScreen.shoppingCartScreen::class.java.simpleName)
                },
                onNavigationToCalendar = {
                    navController.navigate(RouterScreen.catalogScreen::class.java.simpleName)
                }
            )
        }

        composable("eventDetails/{eventId}") { backStackEntry ->
            val eventId = backStackEntry.arguments?.getString("eventId")
            if (eventId != null) {
                // Define la acción que deseas realizar al hacer clic en "Comprar"
                val onBuyClicked: () -> Unit = {
                    // Aquí puedes agregar la lógica de compra, por ejemplo, navegar a otra pantalla
                    // o mostrar un mensaje.
                    println("Comprar evento con ID: $eventId")
                }

                // Pasa la función onBuyClicked a la pantalla de detalles del evento
                eventDetailsScreen(eventId = eventId, onBuyClicked = onBuyClicked)
            } else {
                Text("Error: Event ID not found")
            }
        }


        composable(RouterScreen.shoppingCartScreen::class.java.simpleName) {
            shoppingCartScreen(
                onNavigationToMakeApurchase = {
                    navController.navigate(RouterScreen.makePurchaseScreen::class.java.simpleName)
                },
                onNavigationToProfile = {
                    navController.navigate(RouterScreen.myProfileScreen::class.java.simpleName)
                },
                onNavigationToCart = {
                    navController.navigate(RouterScreen.shoppingCartScreen::class.java.simpleName)
                },
                onNavigationToCalendar = {
                    navController.navigate(RouterScreen.catalogScreen::class.java.simpleName)
                }
            )
        }

        composable(RouterScreen.makePurchaseScreen::class.java.simpleName) {
            makePurchaseScreen(
                onNavigationToCart = {
                    navController.navigate(RouterScreen.shoppingCartScreen::class.java.simpleName)
                },
                onNavigationToProfile = {
                    navController.navigate(RouterScreen.myProfileScreen::class.java.simpleName)
                },
                onNavigationToCalendar = {
                    navController.navigate(RouterScreen.catalogScreen::class.java.simpleName)
                }
            )
        }

        composable(RouterScreen.myProfileScreen::class.java.simpleName) {
            myProfileScreen(
                onNavigationToCart = {
                    navController.navigate(RouterScreen.shoppingCartScreen::class.java.simpleName)
                },
                onNavigationToCalendar = {
                    navController.navigate(RouterScreen.catalogScreen::class.java.simpleName)
                },
                onNavigationToProfile = {
                    navController.navigate(RouterScreen.myProfileScreen::class.java.simpleName)
                }
            )
        }
    }
}

