package com.nubari.recipes.presentation.auth.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nubari.recipes.R
import com.nubari.recipes.presentation.auth.events.AuthEvent
import com.nubari.recipes.presentation.auth.events.LoginEvent
import com.nubari.recipes.presentation.auth.viewModels.AuthViewModel
import com.nubari.recipes.presentation.auth.viewModels.LoginViewModel
import com.nubari.recipes.presentation.components.CustomTextInput
import com.nubari.recipes.ui.theme.SubTextColor


@Composable
fun Login(
    loginViewModel: LoginViewModel = viewModel(),
    authViewModel: AuthViewModel = viewModel()
) {
//    val TAG = "Login"
    val scaffoldState = rememberScaffoldState()
    val emailState = loginViewModel.email.value
    val passwordState = loginViewModel.password.value
    val formValidity = remember {
        mutableStateOf(true)
    }
    val loading = authViewModel.state.value.isProcessing
    formValidity.value = emailState.isValid && passwordState.isValid
//    Log.i(TAG, "email state")
//    Log.i(TAG, emailState.isValid.toString())
//    Log.i(TAG, "password state")
//    Log.i(TAG, passwordState.isValid.toString())
    Scaffold(
        scaffoldState = scaffoldState
    ) {
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
                    value = emailState.text,
                    onFocusChange = {
                        loginViewModel.createEvent(
                            LoginEvent.ChangedEmailFocus(it)
                        )
                    },
                    onValueChange = {
                        val value = it
                        loginViewModel.createEvent(
                            LoginEvent.EnteredEmail(value)
                        )
                    },
                    placeholder = "Enter Your Email",
                    modifier = Modifier.fillMaxWidth(),
                    hasError = !emailState.isValid,
                    errorMessage = "Please enter a valid email"
                )
                Spacer(modifier = Modifier.height(7.dp))
                CustomTextInput(
                    textStyle = MaterialTheme.typography.body1,
                    label = "Password",
                    value = passwordState.text,
                    onFocusChange = {
                        loginViewModel.createEvent(
                            LoginEvent.ChangedPasswordFocus(it)
                        )
                    },
                    onValueChange = {
                        val value = it
                        loginViewModel.createEvent(
                            LoginEvent.EnteredPassword(value)
                        )
                    },
                    placeholder = "Enter Your Password",
                    modifier = Modifier.fillMaxWidth(),
                    hasError = !passwordState.isValid,
                    errorMessage = "Password Cannot be less than 5 characers"
                )
                Spacer(modifier = Modifier.height(20.dp))
                Button(
                    onClick = {
                        authViewModel.createEvent(
                            AuthEvent.Login(
                                emailState.text,
                                passwordState.text
                            )
                        )
                    },
                    modifier = Modifier
                        .clip(RoundedCornerShape(5.dp))
                        .fillMaxWidth()
                        .background(MaterialTheme.colors.primary)
                        .align(Alignment.CenterHorizontally),
                    contentPadding = PaddingValues(16.dp),
                    enabled = formValidity.value
                ) {
                    if (loading) {
                        CircularProgressIndicator(
                            color = Color.White,
                            strokeWidth = 2.dp
                        )
                    } else {
                        Text(
                            text = "Login",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                    }

                }
                Spacer(modifier = Modifier.height(25.dp))
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "New to Scratch ?",
                        textAlign = TextAlign.Center,
                        fontSize = 15.sp,
                        color = SubTextColor,
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    TextButton(onClick = {
                        authViewModel.createEvent(
                            AuthEvent.SwitchToRegister
                        )
                    }) {
                        Text(
                            text = "Create An Account Here",
                            fontSize = 18.sp
                        )
                    }
                }
            }

        }
    }
}

