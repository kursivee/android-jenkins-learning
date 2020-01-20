package kursivee.com.helloworld.common.service

import android.support.annotation.IdRes
import android.support.v4.app.FragmentManager
import kursivee.com.helloworld.login.presentation.home.MyHomeFragment
import kursivee.com.helloworld.login.presentation.registration.RegistrationFragment

object NavigationService {
    lateinit var manager: FragmentManager

    @IdRes var id: Int = -1

    fun goTo(event: String) {
        when(event) {
            "NAVIGATE_HOME" -> manager.beginTransaction()
                .replace(id, MyHomeFragment())
                .addToBackStack(null)
                .commit()

            "NAVIGATE_REGISTER" -> manager.beginTransaction()
                .replace(id, RegistrationFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}