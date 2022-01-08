package com.nubari.recipes.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.nubari.recipes.presentation.auth.AuthenticationWrapper
import com.nubari.recipes.presentation.auth.viewModels.AuthViewModel
import com.nubari.recipes.ui.theme.RecipesTheme

class MainActivity : ComponentActivity() {
    private val viewModel: AuthViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecipesTheme {
                AuthenticationWrapper(viewModel = viewModel)
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RecipesTheme {
        Greeting("Android")
    }
}