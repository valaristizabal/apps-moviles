package com.unieventos.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.unieventos.ui.screens.ForgottenPasswordScreen
import com.unieventos.ui.screens.LoginScreen
import com.unieventos.ui.screens.UserRegistrationScreen
import com.unieventos.ui.screens.catalogScreen
import com.unieventos.ui.screens.cinemaFilterScreen
import com.unieventos.ui.screens.deportsFilterScreen
import com.unieventos.ui.screens.eventDetailsScreen
import com.unieventos.ui.screens.makePurchaseScreen
import com.unieventos.ui.screens.myProfileScreen
import com.unieventos.ui.screens.shoppingCartScreen
import com.unieventos.ui.screens.theaterFilterScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = RouterScreen.LoginScreen::class.java.name
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
                        popUpTo(0) {
                            inclusive = true
                        }
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
            catalogScreen(
                onNavigationToCart = {
                    navController.navigate(RouterScreen.shoppingCartScreen::class.java.name)
                },
                onNavigationToProfile = {
                    navController.navigate(RouterScreen.myProfileScreen::class.java.name)
                },
                onNavigationToCalendar = {
                    navController.navigate(RouterScreen.catalogScreen::class.java.name)
                },
                onNavigationToEventDetail = {
                    navController.navigate(RouterScreen.eventDetailScreen::class.java.name)
                },
                onNavigationSport = {
                    navController.navigate(RouterScreen.deportsFilterScreen::class.java.name)
                },
                onNavigationToTheater = {
                    navController.navigate(RouterScreen.theaterFilterScreen::class.java.name)
                },
                onNavigationToCinema = {
                    navController.navigate(RouterScreen.cinemaFilterScreen::class.java.name)
                }
            )
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

        composable(RouterScreen.eventDetailScreen::class.java.name) {
            eventDetailsScreen(
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

        composable(RouterScreen.deportsFilterScreen::class.java.name) {
            deportsFilterScreen(
                onNavigationToCart = {
                    navController.navigate(RouterScreen.shoppingCartScreen::class.java.name)
                },
                onNavigationToProfile = {
                    navController.navigate(RouterScreen.myProfileScreen::class.java.name)
                },
                onNavigationToCalendar = {
                    navController.navigate(RouterScreen.catalogScreen::class.java.name)
                },
                onNavigationToEventDetail = {
                    navController.navigate(RouterScreen.eventDetailScreen::class.java.name)
                },
                onNavigationSport = {
                    navController.navigate(RouterScreen.deportsFilterScreen::class.java.name)
                },
                onNavigationToTeatro = {
                    navController.navigate(RouterScreen.theaterFilterScreen::class.java.name)
                },
                onNavigationToCine = {
                    navController.navigate(RouterScreen.cinemaFilterScreen::class.java.name)
                }
            )
        }

        composable(RouterScreen.theaterFilterScreen::class.java.name) {
            theaterFilterScreen(
                onNavigationToCart = {
                    navController.navigate(RouterScreen.shoppingCartScreen::class.java.name)
                },
                onNavigationToProfile = {
                    navController.navigate(RouterScreen.myProfileScreen::class.java.name)
                },
                onNavigationToCalendar = {
                    navController.navigate(RouterScreen.catalogScreen::class.java.name)
                },
                onNavigationToEventDetail = {
                    navController.navigate(RouterScreen.eventDetailScreen::class.java.name)
                },
                onNavigationSport = {
                    navController.navigate(RouterScreen.deportsFilterScreen::class.java.name)
                },

            )
        }
        composable(RouterScreen.cinemaFilterScreen::class.java.name) {
            cinemaFilterScreen(
                onNavigationToCart = {
                    navController.navigate(RouterScreen.shoppingCartScreen::class.java.name)
                },
                onNavigationToProfile = {
                    navController.navigate(RouterScreen.myProfileScreen::class.java.name)
                },
                onNavigationToCalendar = {
                    navController.navigate(RouterScreen.catalogScreen::class.java.name)
                },
                onNavigationToEventDetail = {
                    navController.navigate(RouterScreen.eventDetailScreen::class.java.name)
                },
                onNavigationSport = {
                    navController.navigate(RouterScreen.deportsFilterScreen::class.java.name)
                }

            )

        }
    }
}
