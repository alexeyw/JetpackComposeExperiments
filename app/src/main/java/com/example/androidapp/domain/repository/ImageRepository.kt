package com.example.androidapp.domain.repository

import androidx.paging.PagingData
import com.example.androidapp.domain.model.ImageData
import kotlinx.coroutines.flow.Flow

interface ImageRepository {
    fun getImages(): Flow<PagingData<ImageData>>
}