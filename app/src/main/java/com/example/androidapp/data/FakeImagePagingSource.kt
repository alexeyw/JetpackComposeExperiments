package com.example.androidapp.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.androidapp.domain.model.ImageData
import kotlin.random.Random

class FakeImagePagingSource : PagingSource<Int, ImageData>() {
    override fun getRefreshKey(state: PagingState<Int, ImageData>): Int? = state.anchorPosition

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ImageData> {
        val page = params.key ?: 1
        val images = List(20) { index ->
            val id = (page - 1) * 20 + index
            val height = Random.nextInt(200, 500)
            ImageData(id, "https://picsum.photos/seed/$id/300/$height", height)
        }
        return LoadResult.Page(
            data = images,
            prevKey = if (page == 1) null else page - 1,
            nextKey = page + 1
        )
    }
}