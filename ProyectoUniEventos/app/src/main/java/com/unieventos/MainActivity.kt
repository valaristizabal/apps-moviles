package com.unieventos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.unieventos.ui.screens.EditProfileScreen
import com.unieventos.ui.screens.ForgottenPasswordScreen
import com.unieventos.ui.screens.LoginScreen
import com.unieventos.ui.screens.UserRegistrationScreen
import com.unieventos.ui.screens.catalogScreen
import com.unieventos.ui.screens.createCuponScreen
import com.unieventos.ui.screens.createEventsScreen
import com.unieventos.ui.screens.createLocalityScreen
import com.unieventos.ui.screens.editEventScreen
import com.unieventos.ui.screens.eventDetailsScreen
import com.unieventos.ui.screens.makePurchaseScreen
import com.unieventos.ui.screens.myProfileScreen
import com.unieventos.ui.screens.recentTransactionsScreen
import com.unieventos.ui.screens.shoppingCartScreen
import com.unieventos.ui.theme.ProyectoUniEventosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProyectoUniEventosTheme {
                createEventsScreen()
            }
        }
    }
}
