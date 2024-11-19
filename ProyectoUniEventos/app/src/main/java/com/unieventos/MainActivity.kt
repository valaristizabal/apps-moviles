package com.unieventos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.unieventos.ui.navigation.Navigation
import com.unieventos.ui.theme.ProyectoUniEventosTheme
import com.unieventos.viewModel.EventosViewModel
import com.unieventos.viewModel.UserViewModel

class MainActivity : ComponentActivity() {

    // Usamos 'by viewModels()' para obtener la instancia del ViewModel gestionado por el ciclo de vida
    private val eventosViewModel: EventosViewModel by viewModels()
    private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProyectoUniEventosTheme {

                Navigation(
                    eventosViewModel = eventosViewModel,
                    userViewModel = userViewModel
                )
            }
        }
    }
}
