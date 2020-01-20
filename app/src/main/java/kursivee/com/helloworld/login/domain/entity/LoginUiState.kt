package kursivee.com.helloworld.login.domain.entity

import kursivee.com.helloworld.common.component.BackgroundComponent
import kursivee.com.helloworld.common.component.ButtonComponent
import kursivee.com.helloworld.common.component.InputComponent
import kursivee.com.helloworld.common.component.NavigationComponent

data class LoginUiState(
    val backgroundComponent: BackgroundComponent? = null,
    val usernameComponent: InputComponent? = null,
    val passwordComponent: InputComponent? = null,
    val loginButton: ButtonComponent? = null,
    val username: String = "",
    val password: String = ""
)