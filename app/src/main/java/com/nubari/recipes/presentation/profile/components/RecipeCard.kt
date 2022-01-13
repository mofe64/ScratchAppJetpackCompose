package com.nubari.recipes.presentation.profile.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nubari.recipes.domain.Recipe
import com.nubari.recipes.ui.theme.SubTextColor
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun RecipeCard(
    recipe: Recipe,
    navigationFunc: () -> Unit
) {
    Card(modifier = Modifier.height(250.dp)) {
        Column(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .fillMaxHeight(fraction = 0.5f)
                    .fillMaxWidth()
            ) {
                GlideImage(
                    imageModel = recipe.image,
                    contentDescription = recipe.name,
                    modifier = Modifier
                        .matchParentSize()
                        .clip(
                            RoundedCornerShape(
                                topStart = 5.dp,
                                topEnd = 5.dp
                            )
                        ),
                    contentScale = ContentScale.Crop
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),

                ) {
                Text(
                    text = recipe.name,
                    fontWeight = FontWeight(600),
                    fontSize = 18.sp
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(

                    ) {
                        Text(text = "5 minutes", color = SubTextColor)
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(text = "4 Ingredients", color = SubTextColor)
                    }
                    OutlinedButton(
                        onClick = {
                            navigationFunc()
                        },
                        border = BorderStroke(1.dp, MaterialTheme.colors.primary)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Outlined.PlayArrow,
                                contentDescription = null,
                                tint = MaterialTheme.colors.primary
                            )
                            Text(text = "Cook")
                        }
                    }

                }
            }
        }
    }
}