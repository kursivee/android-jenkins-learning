package kursivee.com.helloworld

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kursivee.com.helloworld.common.service.NavigationService
import kursivee.com.helloworld.login.presentation.login.LoginFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        NavigationService.id = R.id.cl_container
        NavigationService.manager = supportFragmentManager
        supportFragmentManager.beginTransaction()
            .replace(R.id.cl_container,
                LoginFragment()
            )
            .commit()
    }
}
