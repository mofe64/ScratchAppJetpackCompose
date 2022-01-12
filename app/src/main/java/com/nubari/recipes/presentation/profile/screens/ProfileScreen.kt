package com.nubari.recipes.presentation.profile.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import com.nubari.recipes.R
import com.nubari.recipes.presentation.application.components.MainAppBar
import com.nubari.recipes.presentation.components.MealImageTile
import com.nubari.recipes.presentation.components.NavigationBarAvoidingBox
import com.nubari.recipes.presentation.profile.viewmodels.ProfileViewModel
import com.nubari.recipes.presentation.util.Screen
import com.nubari.recipes.ui.theme.SubTextColor
import com.skydoves.landscapist.glide.GlideImage
import kotlinx.coroutines.launch

@ExperimentalFoundationApi
@ExperimentalPagerApi
@Composable
fun ProfileScreen(
    navController: NavController,
    profileViewModel: ProfileViewModel = viewModel()
) {
    val state = profileViewModel.state.value
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            MainAppBar(
                navController = navController,
                title = {
                    Text(
                        text = "My Kitchen",
                        style = MaterialTheme.typography.h4,
                        fontWeight = FontWeight(700)
                    )
                }
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = ""
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = "Settings",
                            color = MaterialTheme.colors.primary,
                            style = MaterialTheme.typography.h6
                        )
                    }
                }
                Spacer(modifier = Modifier.width(20.dp))
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
        ) {
            Row(
                modifier = Modifier
                    .height(90.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Row(modifier = Modifier.fillMaxWidth(.8f)) {
                    Box(
                        modifier = Modifier
                            .clip(CircleShape)
                            .width(90.dp)
                            .height(90.dp)
                    ) {
                        GlideImage(
                            imageModel = R.drawable.login_banner,
                            contentDescription = "profile picture",
                            contentScale = ContentScale.FillBounds

                        )
                    }
                    Spacer(modifier = Modifier.width(20.dp))
                    Column(modifier = Modifier.padding(top = 7.dp)) {
                        Text(text = "Nick Evans")
                        Text(text = "Potato Master")
                        Spacer(modifier = Modifier.height(10.dp))
                        Row {
                            Text(text = "584 followers")
                            Spacer(modifier = Modifier.width(10.dp))
                            Text(text = "23k likes")
                        }
                    }
                }

                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Outlined.Edit,
                        contentDescription = "Edit Button"
                    )
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
            Spacer(
                modifier = Modifier
                    .padding(top = 10.dp, bottom = 10.dp)
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(
                        Color.DarkGray.copy(
                            alpha = .4f
                        )
                    )
            )
            val tabData = listOf(
                "Recipes" to state.myRecipes.size,
                "Saved" to state.savedRecipes.size,
                "Following" to state.followers.size,
            )
            val pagerState = rememberPagerState(
                initialPage = 0,
            )
            val tabIndex = pagerState.currentPage
            val coroutineScope = rememberCoroutineScope()
            Column(
                Modifier
                    .fillMaxHeight()
            ) {
                TabRow(
                    selectedTabIndex = tabIndex,
                    indicator = { tabPositions ->
                        TabRowDefaults.Indicator(
                            Modifier
                                .pagerTabIndicatorOffset(pagerState, tabPositions)
                                .height(7.dp)
                                .clip(RoundedCornerShape(5.dp, 5.dp)),
                            color = MaterialTheme.colors.primary
                        )
                    },
                    backgroundColor = Color.Transparent,
                ) {
                    tabData.forEachIndexed { index, pair ->
                        Tab(
                            selected = tabIndex == index,
                            onClick = {
                                coroutineScope.launch {
                                    pagerState.animateScrollToPage(index)
                                }
                            },
                            text = {
                                Column(
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                ) {
                                    Text(
                                        text = pair.second.toString(),
                                        fontWeight = FontWeight(700),
                                        fontSize = 18.sp
                                    )
                                    Spacer(modifier = Modifier.height(10.dp))
                                    Text(
                                        text = pair.first,
                                        fontWeight = FontWeight(400),
                                        fontSize = 14.sp
                                    )
                                    Spacer(modifier = Modifier.height(10.dp))
                                }
                            },
                            modifier = Modifier.height(70.dp),
                            selectedContentColor = Color.Black,
                            unselectedContentColor = SubTextColor
                        )
                    }
                }
                HorizontalPager(
                    count = tabData.size,
                    state = pagerState,
                    modifier = Modifier.weight(1f)
                ) { index ->
                    NavigationBarAvoidingBox {
                        LazyVerticalGrid(
                            cells = GridCells.Fixed(2),
                            contentPadding = PaddingValues(8.dp),
                            verticalArrangement = Arrangement.spacedBy(10.dp),
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            when (index) {
                                0 -> {
                                    items(state.myRecipes) { recipe ->
                                        MealImageTile(
                                            name = recipe.name,
                                            image = recipe.image,
                                            modifier = Modifier.clickable {
                                                navController
                                                    .navigate(
                                                     route=Screen.MyRecipesScreen.route +"?category=${recipe.name}"
                                                    )
                                            }
                                        )
                                    }
                                }
                                1 -> {
                                    items(state.savedRecipes) { recipe ->
                                        MealImageTile(
                                            name = recipe.name,
                                            image = recipe.image,
                                        )
                                    }
                                }
                                2 -> {
                                    items(state.followers) { follower ->
                                        Text(text = follower)
                                    }
                                }
                            }

                        }
                    }
                }
            }
        }
    }
}