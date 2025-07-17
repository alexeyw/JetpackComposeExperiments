package com.example.androidapp.presentation.masonry

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import com.example.androidapp.domain.model.ImageData

@Composable
fun MasonryGrid(
    items: LazyPagingItems<ImageData>,
    columns: Int,
    modifier: Modifier = Modifier,
    itemContent: @Composable (ImageData) -> Unit
) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(columns),
        contentPadding = PaddingValues(4.dp),
        modifier = modifier
    ) {
        items(items.itemCount, key = { items[it]?.id ?: it }) { index ->
            val item = items[index]
            if (item != null) {
                itemContent(item)
            }
        }
    }
}