package com.example.androidapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.androidapp.domain.model.ImageData
import com.example.androidapp.domain.usecase.GetImagesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MasonryViewModel @Inject constructor(
    getImagesUseCase: GetImagesUseCase
) : ViewModel() {
    val images: Flow<PagingData<ImageData>> = getImagesUseCase().cachedIn(viewModelScope)
}