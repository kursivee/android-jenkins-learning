package kursivee.com.helloworld.login.data

import kursivee.com.helloworld.common.action.RequestAction
import kursivee.com.helloworld.common.component.*
import kursivee.com.helloworld.login.domain.AppInitService
import kursivee.com.helloworld.login.domain.entity.LoginUiState

class AppInitServiceImpl: AppInitService {
    /**
     * Sample
     *
     {
        "rows": [
            {
                "type": "background",
                "imageUrl": "background.png"
            },
            {
                "type": "row:username",
                "title": "Username"
            },
            {
                "type": "row:password",
                "title": "Password"
            },
            {
                "type": "row:button",
                "title": "Login",
                "actions": [
                    "onClick": {
                        "type": "REQUEST",
                        "name": "LOGIN_ACTION",
                        "host": "DEV",
                        "endpoint": "/login"
                    }
                ]
            }
        ]
     }
     */
    override fun init(): LoginUiState {
        return LoginUiState(
            listOf(
                BackgroundComponent(color = "#eeeeee"),
                UsernameComponent("Username"),
                PasswordComponent("Password"),
                ButtonComponent("Login",
                    RequestAction("LOGIN_ACTION", "DEV", "/login")
                )
            )
        )
    }
}