package com.nubari.recipes.presentation.feed.components

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SaveFeedDialog(
    cookBooks: List<String>,
    closeDialog: () -> Unit
) {
    val isPressed = remember {
        mutableStateOf("")
    }
    AlertDialog(
        onDismissRequest = {
            closeDialog()
        },
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Save to", style = MaterialTheme.typography.h5)
                IconButton(onClick = { closeDialog() }) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Close save dialog"
                    )
                }
            }
        },
        text = {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp)
            ) {
                items(cookBooks) { cookBook ->
                    Box(
                        modifier = Modifier
                            .pointerInput(Unit) {
                                detectTapGestures(
                                    onPress = {
                                        try {
                                            isPressed.value = cookBook
                                            awaitRelease()
                                        } finally {
                                            // Todo(run func to add to cookbook at this point)
                                            isPressed.value = ""
                                        }
                                    }
                                )
                            }
                            .clip(RoundedCornerShape(10))
                            .background(
                                color = if (isPressed.value == cookBook)
                                    MaterialTheme.colors.secondary.copy(
                                        alpha = .3f
                                    ) else Color.Transparent

                            )
                            .fillMaxWidth()
                            .padding(top = 10.dp, bottom = 10.dp)
                    ) {
                        Text(text = cookBook, fontSize = 15.sp)
                    }
                    Spacer(modifier = Modifier.height(5.dp))

                }
            }
        },
        buttons = {
            TextButton(onClick = { /*TODO*/ }) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "",
                        tint = MaterialTheme.colors.primary
                    )
                    Text(
                        text = "Add New CookBook",
                        color = MaterialTheme.colors.primary,
                        style = MaterialTheme.typography.h6
                    )
                }
            }
        }
    )
}