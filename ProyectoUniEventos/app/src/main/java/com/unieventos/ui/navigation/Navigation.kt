package com.unieventos.ui.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.unieventos.ui.screens.CatalogScreen
import com.unieventos.ui.screens.ForgottenPasswordScreen
import com.unieventos.ui.screens.LoginScreen
import com.unieventos.ui.screens.UserRegistrationScreen
import com.unieventos.ui.screens.eventDetailsScreen
import com.unieventos.ui.screens.makePurchaseScreen
import com.unieventos.ui.screens.myProfileScreen
import com.unieventos.ui.screens.shoppingCartScreen


@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = RouterScreen.catalogScreen::class.java.name
    ) {
        composable(RouterScreen.LoginScreen::class.java.name) {
            LoginScreen(
                onNavigationToSingUp = {
                    navController.navigate(RouterScreen.UserRegistrationScreen::class.java.name)
                },
                onNavigationToForgottenPassword = {
                    navController.navigate(RouterScreen.ForgottenPasswordScreen::class.java.name)
                },
                onNavigationToHome = {
                    navController.navigate(RouterScreen.catalogScreen::class.java.name) {
                        popUpTo(0) { inclusive = true }
                        launchSingleTop = true
                    }
                }
            )
        }

        composable(RouterScreen.ForgottenPasswordScreen::class.java.name) {
            ForgottenPasswordScreen()
        }

        composable(RouterScreen.UserRegistrationScreen::class.java.name) {
            UserRegistrationScreen()
        }

        composable(RouterScreen.catalogScreen::class.java.name) {
            CatalogScreen(
                onNavigationToEventDetail = { eventId ->
                    navController.navigate("eventDetails/$eventId")
                },
                onCategorySelected = { category ->
                    // Aquí puedes agregar el manejo de categorías
                },
                onNavigationToProfile = {
                    // Navega a la pantalla de perfil
                    navController.navigate("profile")
                },
                onNavigationToCart = {
                    // Navega a la pantalla del carrito
                    navController.navigate("cart")
                },
                onNavigationToCalendar = {
                    // Navega a la pantalla del calendario
                    navController.navigate("calendar")
                }
            )
        }


        composable("eventDetails/{eventId}") { backStackEntry ->
            val eventId = backStackEntry.arguments?.getString("eventId")
            if (eventId != null) {
                eventDetailsScreen(eventId = eventId)
            } else {
                Text("Error: Event ID not found")
            }
        }


        composable(RouterScreen.shoppingCartScreen::class.java.name) {
            shoppingCartScreen(
                onNavigationToMakeApurchase = {
                    navController.navigate(RouterScreen.makePurchaseScreen::class.java.name)
                },
                onNavigationToProfile = {
                    navController.navigate(RouterScreen.myProfileScreen::class.java.name)
                },
                onNavigationToCart = {
                    navController.navigate(RouterScreen.shoppingCartScreen::class.java.name)
                },
                onNavigationToCalendar = {
                    navController.navigate(RouterScreen.catalogScreen::class.java.name)
                }
            )
        }

        composable(RouterScreen.makePurchaseScreen::class.java.name) {
            makePurchaseScreen(
                onNavigationToCart = {
                    navController.navigate(RouterScreen.shoppingCartScreen::class.java.name)
                },
                onNavigationToProfile = {
                    navController.navigate(RouterScreen.myProfileScreen::class.java.name)
                },
                onNavigationToCalendar = {
                    navController.navigate(RouterScreen.catalogScreen::class.java.name)
                }
            )
        }

        composable(RouterScreen.myProfileScreen::class.java.name) {
            myProfileScreen(
                onNavigationToCart = {
                    navController.navigate(RouterScreen.shoppingCartScreen::class.java.name)
                },
                onNavigationToCalendar = {
                    navController.navigate(RouterScreen.catalogScreen::class.java.name)
                },
                onNavigationToProfile = {
                    navController.navigate(RouterScreen.myProfileScreen::class.java.name)
                }
            )
        }

        composable("eventDetails/{eventId}") { backStackEntry ->
            val eventId = backStackEntry.arguments?.getString("eventId") ?: ""
            eventDetailsScreen(eventId = eventId)
        }

        composable(RouterScreen.eventDetailsScreen::class.java.name) {


        }

        composable(RouterScreen.theaterFilterScreen::class.java.name) {


        }

        composable(RouterScreen.cinemaFilterScreen::class.java.name) {

        }
    }
}
