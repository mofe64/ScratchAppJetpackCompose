package com.nubari.recipes.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.pager.ExperimentalPagerApi
import com.nubari.recipes.presentation.auth.components.AuthenticationWrapper
import com.nubari.recipes.presentation.auth.viewModels.AuthViewModel
import com.nubari.recipes.presentation.util.ApplicationSwitch
import com.nubari.recipes.ui.theme.RecipesTheme

class MainActivity : ComponentActivity() {
    @ExperimentalPagerApi
    override fun onCreate(savedInstanceState: Bundle?) {
        //display content edge to edge
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        setContent {
            RecipesTheme {
                // from the accompanist lib, gives us access to inset aware layout and inset values.
                ProvideWindowInsets {
                    ApplicationSwitch()
                }

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