package com.unieventos.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.unieventos.ui.screens.ForgottenPasswordScreen
import com.unieventos.ui.screens.LoginScreen
import com.unieventos.ui.screens.UserRegistrationScreen
import com.unieventos.ui.screens.catalogScreen
import com.unieventos.ui.screens.shoppingCartScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = RouterScreen.LoginScreen
    ) {

        composable<RouterScreen.LoginScreen> {
            LoginScreen(
                onNavigationToSingUp = {
                    navController.navigate(RouterScreen.UserRegistrationScreen){

                    }
                },
                onNavigationToForgottenPassword = {
                    navController.navigate(RouterScreen.ForgottenPasswordScreen)
                },
                onNavigationToHome = {
                    navController.navigate(RouterScreen.catalogScreen){
                        popUpTo(0){
                            inclusive = true
                        }
                        launchSingleTop = true
                    }


                }
            )
        }
        composable<RouterScreen.ForgottenPasswordScreen> {
                ForgottenPasswordScreen ()
        }
        composable<RouterScreen.UserRegistrationScreen> {
            UserRegistrationScreen()
        }
        composable<RouterScreen.catalogScreen> {
            catalogScreen(
                onNavigationToCart = {
                    navController.navigate(RouterScreen.shoppingCartScreen)
                }

            )
        }
        composable<RouterScreen.shoppingCartScreen> {
            shoppingCartScreen(
                onNavigationToCart = {
                    navController.navigate(RouterScreen.catalogScreen)
                }
            )
        }


    }

}