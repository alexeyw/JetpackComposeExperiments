package com.example.androidapp.presentation.masonry

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import coil3.compose.AsyncImage

@Composable
fun MasonryGridScreen(viewModel: MasonryViewModel = hiltViewModel()) {
    val items = viewModel.images.collectAsLazyPagingItems()
    val snackbarHostState = remember { SnackbarHostState() }
    val configuration = LocalConfiguration.current
    val columns = configuration.screenWidthDp / 200

    LaunchedEffect(items.loadState.append) {
        val state = items.loadState.append
        if (state is LoadState.Error) {
            val result = snackbarHostState.showSnackbar(
                message = state.error.localizedMessage ?: "Error",
                actionLabel = "Retry"
            )
            if (result == SnackbarResult.ActionPerformed) {
                items.retry()
            }
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        MasonryGrid(
            items = items,
            columns = columns,
            modifier = Modifier.fillMaxSize()
        ) { image ->
            AsyncImage(
                model = image.url,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .border(width = Dp.Hairline, color = Color.Black)
            )
        }

        if (items.loadState.append is LoadState.Loading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.BottomCenter))
        }
        SnackbarHost(hostState = snackbarHostState)
    }
}