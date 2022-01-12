package com.nubari.recipes.presentation.profile.screens

import androidx.compose.animation.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.nubari.recipes.R
import com.nubari.recipes.domain.Recipe
import com.nubari.recipes.presentation.application.components.MainAppBar
import com.nubari.recipes.presentation.components.NavigationBarAvoidingBox
import com.nubari.recipes.presentation.profile.components.RecipeCard
import com.nubari.recipes.presentation.profile.events.RecipesEvents
import com.nubari.recipes.presentation.profile.viewmodels.RecipesViewModel
import com.nubari.recipes.ui.theme.SubTextColor
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun Recipes(
    navController: NavController,
    recipesViewModel: RecipesViewModel = viewModel(),
    category: String
) {
    val state = recipesViewModel.state.value
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            MainAppBar(
                navController = navController,
                modifier = Modifier.padding(start = 20.dp, end = 20.dp)
            )
        }
    ) {
        NavigationBarAvoidingBox {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 20.dp, top = 5.dp, bottom = 10.dp, end = 10.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "My Recipes",
                        fontWeight = FontWeight(700),
                        style = MaterialTheme.typography.h5
                    )
                    TextButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Add Recipe",
                            tint = MaterialTheme.colors.primary
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = "Add New",
                            color = MaterialTheme.colors.primary
                        )
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            recipesViewModel.createEvent(RecipesEvents.ToggleListVisibility)
                        },
                    elevation = 6.dp
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "$category (${state.recipes.size})")
                        Icon(
                            imageVector = if (state.isListVisible) Icons.Default.ArrowDownward else Icons.Default.ArrowForward,
                            contentDescription = "Drop down toggle"
                        )
                    }
                }
                Spacer(modifier = Modifier.height(30.dp))
                AnimatedVisibility(
                    visible = state.isListVisible,
                    enter = fadeIn() + slideInVertically(),
                    exit = fadeOut() + slideOutVertically()
                ) {
                    LazyColumn(modifier = Modifier.fillMaxSize()) {
                        items(state.recipes) { item: Recipe ->
                            RecipeCard(recipe = item)
                            Spacer(modifier = Modifier.height(16.dp))
                        }
                    }
                }
            }
        }
    }
}