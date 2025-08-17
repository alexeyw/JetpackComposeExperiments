package com.example.androidapp.domain.usecase

import androidx.paging.PagingData
import com.example.androidapp.domain.model.ImageData
import com.example.androidapp.domain.repository.ImageRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.flow.flowOf
import org.junit.Assert.assertSame
import org.junit.Test

class GetImagesUseCaseTest {
    private val repository: ImageRepository = mockk()
    private val useCase = GetImagesUseCase(repository)

    @Test
    fun `invoke should delegate to repository`() {
        val expected = flowOf<PagingData<ImageData>>(PagingData.empty())
        every { repository.getImages() } returns expected

        val result = useCase()

        assertSame(expected, result)
        verify(exactly = 1) { repository.getImages() }
    }
}