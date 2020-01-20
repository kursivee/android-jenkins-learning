package kursivee.com.helloworld.login.domain

import kursivee.com.helloworld.login.domain.entity.LoginUiState

interface AppInitService {
    fun init(): LoginUiState
}