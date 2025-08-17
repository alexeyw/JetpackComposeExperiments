package com.example.androidapp.domain.usecase

import androidx.paging.PagingData
import com.example.androidapp.domain.model.ImageData
import com.example.androidapp.domain.repository.ImageRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetImagesUseCase @Inject constructor(
    private val repository: ImageRepository
) {
    operator fun invoke(): Flow<PagingData<ImageData>> = repository.getImages()
}