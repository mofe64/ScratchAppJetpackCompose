package com.nubari.recipes.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nubari.recipes.R
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun MealImageTile(
    modifier: Modifier = Modifier,
    name: String,
    image: Int,
) {
    Card(
        modifier = modifier.height(180.dp),
        shape = RoundedCornerShape(10)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight(fraction = 0.75f)
                    .fillMaxWidth()
            ) {
                GlideImage(
                    imageModel = image,
                    contentDescription = "Meal Tile Image",
                    modifier = Modifier
                        .matchParentSize()
                        .clip(
                            RoundedCornerShape(
                                topStart = 10.dp,
                                topEnd = 10.dp
                            )
                        ),
                    contentScale = ContentScale.Crop
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = name,
                    fontWeight = FontWeight(400),
                    style = MaterialTheme.typography.body1,
                    fontSize = 16.sp
                )
            }

        }
    }
}