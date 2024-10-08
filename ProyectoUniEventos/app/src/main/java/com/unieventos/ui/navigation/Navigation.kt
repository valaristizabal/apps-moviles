package com.unieventos.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.unieventos.ui.screens.LoginScreen
import com.unieventos.ui.screens.UserRegistrationScreen
import com.unieventos.ui.screens.catalogScreen

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = RouterScreen.LoginScreen
    ){
        composable<RouterScreen.catalogScreen>{
            catalogScreen()
        }
        composable<RouterScreen.LoginScreen>{
            LoginScreen(
                onNavigationToSingUp = {
                    navController.navigate(RouterScreen.userRegistrationScreen)
                }

            )
        }
        composable<RouterScreen.userRegistrationScreen>{
            UserRegistrationScreen()
        }


    }
}