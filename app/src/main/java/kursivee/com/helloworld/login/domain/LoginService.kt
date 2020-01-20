package kursivee.com.helloworld.login.domain

import kursivee.com.helloworld.login.domain.entity.LoginResponse

interface LoginService {
    fun login(username: String, password: String): LoginResponse
}