package kursivee.com.helloworld.login.domain.entity

import kursivee.com.helloworld.common.component.*

data class LoginUiState(
    val components: List<Component>? = null,
    val username: String = "",
    val password: String = ""
)