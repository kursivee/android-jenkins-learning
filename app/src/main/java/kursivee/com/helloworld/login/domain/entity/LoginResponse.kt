package kursivee.com.helloworld.login.domain.entity

data class LoginResponse(
    val success: Boolean? = false,
    val navigationEvent: String? = null
)