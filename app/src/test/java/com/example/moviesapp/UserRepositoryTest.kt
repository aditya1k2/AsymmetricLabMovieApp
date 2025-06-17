package com.example.moviesapp

import com.example.moviesapp.learnTest.mockingApi.User
import com.example.moviesapp.learnTest.mockingApi.UserApi
import com.example.moviesapp.learnTest.mockingApi.UserRepository
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*

class UserRepositoryTest {

    private lateinit var mockApi: UserApi
    private lateinit var repository: UserRepository

    @Before
    fun setup() {
        mockApi = mock(UserApi::class.java) // mocking the API
        repository = UserRepository(mockApi)
    }

    @Test
    fun testGetUserName_returnsCorrectName() {
        // Arrange (mocking behavior)
        val fakeUser = User(name = "Aditya")
        `when`(mockApi.fetchUser()).thenReturn(fakeUser)

        // Act
        val result = repository.getUserName()

        // Assert
        assertEquals("Aditya", result)
    }
}
