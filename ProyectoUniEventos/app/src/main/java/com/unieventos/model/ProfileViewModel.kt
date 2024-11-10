package com.unieventos.model

import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ProfileViewModel : ViewModel() {
    var fullName by mutableStateOf("")
    var address by mutableStateOf("")
    var phoneNumber by mutableStateOf("")
    var email by mutableStateOf("")
    var password by mutableStateOf("")

    fun isFullNameValid() = fullName.isNotEmpty()
    fun isAddressValid() = address.isNotEmpty()
    fun isPhoneNumberValid() = phoneNumber.isNotEmpty()
    fun isEmailValid() = Patterns.EMAIL_ADDRESS.matcher(email).matches()
    fun isPasswordValid() = password.length >= 6
}