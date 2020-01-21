package kursivee.com.helloworld.login.domain

import kursivee.com.helloworld.login.domain.entity.LoginResponse
import kursivee.com.helloworld.login.presentation.login.action.LoginRequestAction

interface LoginService {
    fun login(action: LoginRequestAction): LoginResponse
}