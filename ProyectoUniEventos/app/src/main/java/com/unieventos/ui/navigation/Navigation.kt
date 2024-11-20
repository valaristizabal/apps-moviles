package com.unieventos.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.unieventos.ui.screens.*
import com.unieventos.viewModel.EventosViewModel
import com.unieventos.viewModel.UserViewModel

@Composable
fun Navigation(eventosViewModel: EventosViewModel, userViewModel: UserViewModel) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = RouterScreen.LoginScreen::class.java.simpleName
    ) {
        // Pantalla de inicio de sesión
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
                        // Limpia el historial de navegación para evitar volver a la pantalla de inicio de sesión
                        popUpTo(RouterScreen.LoginScreen::class.java.simpleName) { inclusive = true }
                    }
                },
                userViewModel = userViewModel
            )
        }

        // Pantalla de recuperación de contraseña
        composable(RouterScreen.ForgottenPasswordScreen::class.java.simpleName) {
            ForgottenPasswordScreen(
                navController = navController
            )
        }

        // Pantalla de registro de usuario
        composable(RouterScreen.UserRegistrationScreen::class.java.simpleName) {
            UserRegistrationScreen(
                userViewModel = userViewModel,
                onBackClick = { navController.navigateUp() } // Navegar hacia atrás
            )
        }

        // Pantalla del catálogo
        composable(RouterScreen.catalogScreen::class.java.simpleName) {
            CatalogScreen(
                onNavigationToEventDetail = { eventId ->
                    navController.navigate("eventDetails/$eventId")
                },
                onNavigationToProfile = {
                    navController.navigate(RouterScreen.myProfileScreen::class.java.simpleName)
                },
                onNavigationToCart = {
                    navController.navigate(RouterScreen.shoppingCartScreen::class.java.simpleName)
                },
                onNavigationToCalendar = {
                    navController.navigate(RouterScreen.catalogScreen::class.java.simpleName)
                },
                eventosViewModel = eventosViewModel
            )
        }
    }
}



