package kursivee.com.helloworld.login.presentation.login.action

data class LoginRequestAction(
    val endpoint: String,
    val host: String,
    val username: String,
    val password: String
)