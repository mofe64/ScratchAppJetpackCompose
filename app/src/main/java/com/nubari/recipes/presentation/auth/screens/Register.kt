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
import com.nubari.recipes.presentation.auth.events.RegistrationEvent
import com.nubari.recipes.presentation.auth.viewModels.AuthViewModel
import com.nubari.recipes.presentation.auth.viewModels.RegisterViewModel
import com.nubari.recipes.presentation.components.CustomTextInput
import com.nubari.recipes.ui.theme.SubTextColor


@Composable
fun Register(
    registerViewModel: RegisterViewModel = viewModel(),
    authViewModel: AuthViewModel = viewModel()
) {
    val scaffoldState = rememberScaffoldState()
    val fullNameState = registerViewModel.fullName.value
    val emailState = registerViewModel.email.value
    val passwordState = registerViewModel.password.value
    val formValidity = remember {
        mutableStateOf(true)
    }
    val loading = authViewModel.state.value.isProcessing
    formValidity.value = emailState.isValid && passwordState.isValid
    com.google.accompanist.insets.ui.Scaffold(
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
                        contentDescription = "Scratch Logo",
                        modifier = Modifier.padding(top = 20.dp)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Start",
                        style = MaterialTheme.typography.h4,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "From Scratch",
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
                    text = "Create An Account to continue",
                    style = MaterialTheme.typography.subtitle1,
                    color = Color.DarkGray,
                )
                Spacer(modifier = Modifier.height(20.dp))
                CustomTextInput(
                    textStyle = MaterialTheme.typography.body1,
                    label = "Full Name",
                    value = fullNameState.text,
                    onFocusChange = {
                        registerViewModel.createEvent(
                            RegistrationEvent.ChangedNameFocus(it)
                        )
                    },
                    onValueChange = {
                        val value = it
                        registerViewModel.createEvent(
                            RegistrationEvent.EnteredName(value)
                        )
                    },
                    placeholder = "Enter Your Full name",
                    modifier = Modifier.fillMaxWidth(),
                    hasError = !emailState.isValid,
                    errorMessage = "Full name cannot be empty"
                )
                Spacer(modifier = Modifier.height(7.dp))
                CustomTextInput(
                    textStyle = MaterialTheme.typography.body1,
                    label = "Email",
                    value = fullNameState.text,
                    onFocusChange = {
                        registerViewModel.createEvent(
                            RegistrationEvent.ChangedEmailFocus(it)
                        )
                    },
                    onValueChange = {
                        val value = it
                        registerViewModel.createEvent(
                            RegistrationEvent.EnteredEmail(value)
                        )
                    },
                    placeholder = "Enter Your Email",
                    modifier = Modifier.fillMaxWidth(),
                    hasError = !emailState.isValid,
                    errorMessage = "Please Enter a Valid Email"
                )
                Spacer(modifier = Modifier.height(7.dp))
                CustomTextInput(
                    textStyle = MaterialTheme.typography.body1,
                    label = "Password",
                    value = passwordState.text,
                    onFocusChange = {
                        registerViewModel.createEvent(
                            RegistrationEvent.ChangedPasswordFocus(it)
                        )
                    },
                    onValueChange = {
                        val value = it
                        registerViewModel.createEvent(
                            RegistrationEvent.EnteredPassword(value)
                        )
                    },
                    placeholder = "Enter Your Password",
                    modifier = Modifier.fillMaxWidth(),
                    hasError = !passwordState.isValid,
                    errorMessage = "Password Cannot be less than 5 characters"
                )
                Spacer(modifier = Modifier.height(20.dp))
                Button(
                    onClick = {
                        authViewModel.createEvent(
                            AuthEvent.Register(
                                fullNameState.text,
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
                            text = "Create Account",
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
                        text = "Already have an account?",
                        textAlign = TextAlign.Center,
                        fontSize = 15.sp,
                        color = SubTextColor,
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    TextButton(onClick = {
                        authViewModel.createEvent(
                            AuthEvent.SwitchToLogin
                        )
                    }) {
                        Text(
                            text = "Login Here",
                            fontSize = 18.sp
                        )
                    }
                }
            }

        }
    }
}

