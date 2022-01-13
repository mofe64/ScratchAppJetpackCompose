package com.nubari.recipes.presentation.recipes.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
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
import com.nubari.recipes.presentation.components.NavigationBarAvoidingBox
import com.nubari.recipes.presentation.recipes.components.ListTile
import com.nubari.recipes.presentation.recipes.viewmodels.RecipeDetailViewModel
import com.nubari.recipes.ui.theme.SubTextColor
import com.skydoves.landscapist.glide.GlideImage
import kotlinx.coroutines.launch

@ExperimentalPagerApi
@Composable
fun RecipeDetail(
    navController: NavController,
    recipeDetailViewModel: RecipeDetailViewModel = viewModel()
) {
    val state = recipeDetailViewModel.state.value
    Column() {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(fraction = 0.45f)
                .background(Color.Black)
        ) {
            GlideImage(
                imageModel = R.drawable.pizza,
                modifier = Modifier
                    .matchParentSize(),
                contentScale = ContentScale.Crop,
                alpha = .7f,
            )
            Column(
                modifier =
                Modifier
                    .align(Alignment.BottomStart)
                    .padding(20.dp)
            ) {
                Text(
                    text = "Engine-Cooked Honey Orange Pancake",
                    color = Color.White,
                    fontWeight = FontWeight(700),
                    fontSize = 27.sp
                )
            }
            MainAppBar(
                navController = navController,
                backgroundColor = Color.Transparent,
                modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                backIconColor = Color.White,
                backTextColor = Color.White,
            ) {
                OutlinedButton(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.outlinedButtonColors(
                        backgroundColor = Color.Black.copy(
                            alpha = .4f
                        )
                    ),
                    border = BorderStroke(1.dp, Color.White)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.PlayArrow,
                            contentDescription = "",
                            tint = Color.White
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = "Cook Now",
                            color = Color.White,
                            style = MaterialTheme.typography.h6
                        )
                    }
                }
            }
        }
        Column(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .width(103.dp)
                        .height(94.dp)
                ) {
                    GlideImage(
                        imageModel = R.drawable.prepimage1,
                        modifier = Modifier
                            .matchParentSize()

                    )
                }
                Box(
                    modifier = Modifier
                        .width(103.dp)
                        .height(94.dp)
                ) {
                    GlideImage(
                        imageModel = R.drawable.prepimage2,
                        modifier = Modifier
                            .matchParentSize()

                    )
                }
                Box(
                    modifier = Modifier
                        .width(103.dp)
                        .height(94.dp)
                        .background(Color.White)
                ) {
                    GlideImage(
                        imageModel = R.drawable.prepimage3,
                        modifier = Modifier
                            .matchParentSize()
                            .alpha(.3f)

                    )
                    Text(
                        text = "12+",
                        fontWeight = FontWeight(700),
                        fontSize = 20.sp,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }

            }
            val tabData = listOf(
                "Ingredients",
                "How to Cook",
                "Additional Info"
            )
            val pagerState = rememberPagerState(
                initialPage = 0,
            )
            val tabIndex = pagerState.currentPage
            val coroutineScope = rememberCoroutineScope()
            ScrollableTabRow(
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
                tabData.forEachIndexed { index, title ->
                    Tab(
                        selected = tabIndex == index,
                        onClick = {
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(index)
                            }
                        },
                        text = {
                            Text(
                                text = title,
                                fontWeight = FontWeight(700),
                                fontSize = 18.sp
                            )
                        },
                        modifier = Modifier.height(70.dp).fillMaxWidth(),
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
                    LazyColumn(
                        contentPadding = PaddingValues(10.dp),
                        modifier = Modifier.fillMaxSize()
                    ) {
                        when (index) {
                            0 -> {
                                items(state.recipe.ingredients) { ingredient ->
                                    ListTile(value = ingredient)
                                }
                            }
                            1 -> {
                                items(state.recipe.steps) { step ->
                                    ListTile(value = step)
                                }
                            }
                            2 -> {
                                items(state.recipe.additionalInfo) { info ->
                                    ListTile(value = info)
                                }
                            }
                        }
                    }
                }

            }
        }

    }
}