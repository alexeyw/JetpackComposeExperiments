package com.example.androidapp.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.androidapp.domain.model.ImageData
import com.example.androidapp.domain.repository.ImageRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ImageRepositoryImpl @Inject constructor() : ImageRepository {
    override fun getImages(): Flow<PagingData<ImageData>> = Pager(
        config = PagingConfig(pageSize = 20),
        pagingSourceFactory = { FakeImagePagingSource() }
    ).flow
}