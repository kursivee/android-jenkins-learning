package kursivee.com.helloworld.login.presentation.login

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import kursivee.com.helloworld.common.service.NavigationService
import kursivee.com.helloworld.login.data.AppInitServiceImpl
import kursivee.com.helloworld.login.data.LoginServiceImpl
import kursivee.com.helloworld.login.domain.AppInitService
import kursivee.com.helloworld.login.domain.LoginService
import kursivee.com.helloworld.login.domain.entity.LoginUiState
import kursivee.com.helloworld.login.presentation.login.action.LoginRequestAction

class LoginViewModel : ViewModel() {
    private val mutableState: MutableLiveData<LoginUiState> = MutableLiveData()
    val state: LiveData<LoginUiState> = mutableState

    private val appInitService: AppInitService by lazy {
        AppInitServiceImpl()
    }

    private val loginService: LoginService by lazy {
        LoginServiceImpl()
    }

    fun init() {
        mutableState.value = appInitService.init()
    }

    fun login(action: LoginRequestAction) {
        loginService.login(action).run {
            navigationEvent?.let {
                NavigationService.goTo(it)
            }
        }
    }

}
