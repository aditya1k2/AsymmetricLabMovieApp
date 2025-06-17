package com.example.moviesapp.learnTest.mockingApi

class UserRepository(private val api: UserApi) {
    fun getUserName(): String {
        return api.fetchUser().name
    }
}