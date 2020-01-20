package kursivee.com.helloworld.login.data

import kursivee.com.helloworld.login.domain.LoginService
import kursivee.com.helloworld.login.domain.entity.LoginResponse

class LoginServiceImpl: LoginService {
    override fun login(username: String, password: String): LoginResponse {
        return LoginResponse(
            true,
            "NAVIGATE_REGISTER"
        )
    }
}