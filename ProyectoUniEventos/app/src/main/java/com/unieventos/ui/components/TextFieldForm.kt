package com.unieventos.ui.components

import android.util.Patterns
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun TextFieldForm(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    supportingText: String,
    label: String,
    onValidate: (String) -> Boolean,
    keyboardOptions: KeyboardOptions,
    isPassword: Boolean
){

    var isError by rememberSaveable {
        mutableStateOf(false)
    }

    TextField(
        value = value,
        label = { Text(text = label) },
        singleLine = true,
        isError = isError,
        supportingText = {
            if(isError){
                Text(text = supportingText)
            }
        },
        visualTransformation = if(isPassword){PasswordVisualTransformation() } else {VisualTransformation.None},
        keyboardOptions = keyboardOptions,
        onValueChange = {
            onValueChange(it)
            isError = onValidate(it)
        },
        modifier = modifier
    )
}