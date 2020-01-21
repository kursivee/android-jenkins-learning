package kursivee.com.helloworld.login.data

import kursivee.com.helloworld.login.domain.LoginService
import kursivee.com.helloworld.login.domain.entity.LoginResponse
import kursivee.com.helloworld.login.presentation.login.action.LoginRequestAction

class LoginServiceImpl: LoginService {
    override fun login(action: LoginRequestAction): LoginResponse {
        println("action: $action")
        return LoginResponse(
            true,
            "NAVIGATE_HOME"
        )
    }
}