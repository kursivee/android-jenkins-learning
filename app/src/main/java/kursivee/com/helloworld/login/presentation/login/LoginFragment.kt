package kursivee.com.helloworld.login.presentation.login

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.login_fragment.*

import kursivee.com.helloworld.R

class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.login_fragment, container, false).also {
            viewModel = ViewModelProviders.of(this)[LoginViewModel::class.java]
            viewModel.init()
            viewModel.state.observe(viewLifecycleOwner, Observer { state ->
                with(state!!) {
                    backgroundComponent?.let {
                        it.color?.let { color ->
                            cl_fragment.setBackgroundColor(
                                Color.parseColor(color)
                            )
                        }
                    }
                    usernameComponent?.let {
                        et_username.visibility = View.VISIBLE
                        et_username.hint = it.title
                        et_username.setText(state.username)
                    }
                    passwordComponent?.let {
                        et_password.visibility = View.VISIBLE
                        et_password.hint = it.title
                        et_password.setText(state.password)
                    }
                    loginButton?.let { component ->
                        btn_login.visibility = View.VISIBLE
                        btn_login.text = component.title
                        component.onClickEvent?.let { event ->
                            btn_login.setOnClickListener {
                                dispatch(event)
                            }
                        }
                    }
                }
            })
        }
    }

    private fun dispatch(event: String) {
        when(event) {
            "LOGIN_EVENT" -> viewModel.login(et_username.text.toString(), et_password.text.toString())
        }
    }
}
