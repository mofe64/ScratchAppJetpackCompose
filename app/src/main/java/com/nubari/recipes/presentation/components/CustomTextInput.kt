package com.nubari.recipes.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.nubari.recipes.ui.theme.SubTextColor
import com.nubari.recipes.ui.theme.textFieldGray

@Composable
fun CustomTextInput(
    label: String,
    value: String,
    placeholder: String,
    modifier: Modifier = Modifier,
    hasError: Boolean = false,
    errorMessage: String = "error",
    isPassword: Boolean = false,
    textStyle: TextStyle = TextStyle(),
    singleLine: Boolean = false,
    onFocusChange: (FocusState) -> Unit,
    onValueChange: (String) -> Unit,
    icon: @Composable (() -> Unit)? = null,
) {
    val touched = remember {
        mutableStateOf(false)
    }
    OutlinedTextField(
        value = value,
        textStyle = textStyle,
        singleLine = singleLine,
        onValueChange = {
            touched.value = true
            onValueChange(it)
        },
        modifier = modifier.onFocusChanged {
            if (touched.value) onFocusChange(it);
        },
        label = {
            Text(
                text = label,
            )
        },
        isError = hasError,
        placeholder = {
            Text(
                text = placeholder, style = TextStyle(
                    textAlign = TextAlign.Center
                )
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = textFieldGray,
            unfocusedBorderColor = textFieldGray,
            focusedLabelColor = SubTextColor,
            errorBorderColor = Color.Red,
            errorLabelColor = Color.Red,
            errorLeadingIconColor = Color.Red
        ),
        leadingIcon = icon
    )
    if (hasError) {
        Text(
            text = errorMessage,
            color = Color.Red,
            modifier = Modifier.padding(start = 10.dp)
        )
    }
}