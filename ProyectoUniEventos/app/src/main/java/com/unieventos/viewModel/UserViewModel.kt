    package com.unieventos.viewModel

    import android.util.Log
    import androidx.lifecycle.ViewModel
    import kotlinx.coroutines.flow.MutableStateFlow
    import kotlinx.coroutines.flow.StateFlow
    import com.unieventos.model.User
    import com.unieventos.model.Role

    class UserViewModel : ViewModel() {
        // Lista mutable para manejar usuarios
        private val _users = MutableStateFlow<List<User>>(emptyList())
        val users: StateFlow<List<User>> get() = _users

        // Usuario autenticado
        private val _loggedInUser = MutableStateFlow<User?>(null)
        val loggedInUser: StateFlow<User?> get() = _loggedInUser

        // Inicialización de usuarios
        init {
            // Agregar usuarios predeterminados (quemados)
            _users.value = listOf(
                User(
                    id = "123",
                    name = "Juan",
                    role = Role.ADMIN,
                    email = "admin@unieventos.com",
                    password = "admin123",
                    idNumber = "123456789",
                    city = "Armenia",
                    birthday = "1990-01-01",
                    address = "Calle 123",
                    phoneNumber = "123456789"
                ),
                User(
                    id = "124",
                    name = "Dan",
                    role = Role.CLIENT,
                    email = "dan@unieventos.com",
                    password = "cliente123",
                    idNumber = "987654321",
                    city = "Pereira",
                    birthday = "1995-05-15",
                    address = "Avenida 456",
                    phoneNumber = "98765"
                )
            )
        }

        // Función para agregar un usuario
        fun addUser(user: User) {
            _users.value = _users.value + user
            Log.d("UserViewModel", "Usuarios registrados: ${_users.value}")
        }

        // Función para eliminar un usuario
        fun removeUser(user: User) {
            _users.value = _users.value - user
        }

        // Función para realizar login
        fun login(email: String, password: String): Boolean {
            val user = _users.value.find { it.email == email && it.password == password }
            return if (user != null) {
                _loggedInUser.value = user
                true
            } else {
                false
            }
        }

        // Función para cerrar sesión
        fun logout() {
            _loggedInUser.value = null
        }
    }
