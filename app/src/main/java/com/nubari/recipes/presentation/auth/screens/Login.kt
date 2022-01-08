package com.nubari.recipes.presentation.auth.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nubari.recipes.R
import com.nubari.recipes.presentation.auth.AuthState
import com.nubari.recipes.ui.theme.LightGraySubColor
import com.nubari.recipes.ui.theme.SubTextColor
import com.nubari.recipes.ui.theme.textFieldGray


@Composable
fun Login() {

    var email by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(fraction = 0.37f)
                .clip(RoundedCornerShape(0.dp, 0.dp, 100.dp, 0.dp))
                .background(color = Color.Blue), //TODO(remove blue bg)
        ) {
            Image(
                painter = painterResource(id = R.drawable.login_banner),
                contentDescription = "Login Banner",
                modifier = Modifier.matchParentSize(),
                contentScale = ContentScale.FillBounds
            )
            Column(
                modifier = Modifier
                    .padding(
                        horizontal = 20.dp,
                        vertical = 30.dp
                    )
            ) {
                Image(
                    painter = painterResource(
                        id = R.drawable.ic_logo
                    ),
                    contentDescription = "Scratch Logo"
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Welcome Back!",
                    style = MaterialTheme.typography.h4,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Column(
            modifier = Modifier
                .padding(top = 20.dp, start = 20.dp, end = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Please login to continue",
                style = MaterialTheme.typography.subtitle1,
                color = Color.DarkGray,
            )
            Spacer(modifier = Modifier.height(20.dp))
            CustomTextInput(
                textStyle = MaterialTheme.typography.body1,
                label = "Email",
                value = email,
                onFocusChange = {},
                onValueChange = {
                    email = it
                },
                placeholder = "Enter Your Email",
                modifier = Modifier.fillMaxWidth(),
            )
            Spacer(modifier = Modifier.height(7.dp))
            CustomTextInput(
                textStyle = MaterialTheme.typography.body1,
                label = "Password",
                value = email,
                onFocusChange = {},
                onValueChange = {},
                placeholder = "Enter Your Password",
                modifier = Modifier.fillMaxWidth(),
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .clip(RoundedCornerShape(5.dp))
                    .fillMaxWidth()
                    .background(MaterialTheme.colors.primary)
                    .align(Alignment.CenterHorizontally)
                    ,
                contentPadding = PaddingValues(16.dp),
            ) {
                Text(
                    text = "Login",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            }
            Spacer(modifier = Modifier.height(25.dp))
            Text(
                text = "New to Scratch ?",
                textAlign = TextAlign.Center,
                fontSize = 15.sp,
                color = SubTextColor
            )
            Spacer(modifier = Modifier.height(10.dp))
            TextButton(onClick = { /*TODO*/ }) {
                Text(
                    text = "Create An Account Here",
                    fontSize = 18.sp
                )
            }

        }

    }


}

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
    OutlinedTextField(
        value = value,
        textStyle = textStyle,
        singleLine = singleLine,
        onValueChange = onValueChange,
        modifier = modifier.onFocusChanged {
            onFocusChange(it);
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