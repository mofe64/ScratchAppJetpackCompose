package com.nubari.recipes.presentation.feed.components

import android.graphics.drawable.Drawable
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.nubari.recipes.R
import com.nubari.recipes.ui.theme.SubTextColor
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun FeedCard(
    name: String,
    image: Int,
) {
    val openDialog = remember {
        mutableStateOf(false)
    }
    Card(modifier = Modifier.height(400.dp)) {
        Column(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .fillMaxHeight(fraction = 0.6f)
                    .fillMaxWidth()
            ) {
                GlideImage(
                    imageModel = image,
                    contentDescription = "Feed Card Image",
                    modifier = Modifier.matchParentSize(),
                    contentScale = ContentScale.Crop
                )
                Surface(
                    modifier = Modifier
                        .fillMaxHeight(.27f)
                        .fillMaxWidth(),
                    color = Color.White.copy(alpha = 0.8f)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(start = 13.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .clip(CircleShape)
                                .width(40.dp)
                                .height(40.dp)
                        ) {
                            GlideImage(
                                imageModel = R.drawable.login_banner,
                                contentDescription = "profile picture",
                                contentScale = ContentScale.FillBounds

                            )
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Column() {
                            Text(
                                text = "Profile Name",
                                style = MaterialTheme.typography.subtitle1
                            )
                            Text(text = "2h ago", color = SubTextColor)
                        }
                    }
                }
            }
            Column(
                modifier = Modifier.padding(10.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = name,
                        style = MaterialTheme.typography.h5
                    )
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_like),
                            contentDescription = "Like button"
                        )
                    }
                }
                Text(
                    text = "Apparently we had reached a great " +
                            "height in the atmosphere,for the sky was …",
                    color = SubTextColor
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                    ) {
                        Text(text = "32 likes", color = SubTextColor)
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(text = "8 comments", color = SubTextColor)
                    }
                    OutlinedButton(
                        onClick = {
                            openDialog.value = true
                        },
                        border = BorderStroke(1.dp, MaterialTheme.colors.primary)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = "",
                                tint = MaterialTheme.colors.primary
                            )
                            Text(
                                text = "Save",
                                color = MaterialTheme.colors.primary
                            )

                        }
                    }
                }
            }
        }
    }

    if (openDialog.value) {
        SaveFeedDialog {
            openDialog.value = false
        }
    }
}