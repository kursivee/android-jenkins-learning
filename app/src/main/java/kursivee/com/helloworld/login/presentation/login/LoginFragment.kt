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
import kursivee.com.helloworld.common.action.RequestAction
import kursivee.com.helloworld.common.component.*
import kursivee.com.helloworld.login.domain.entity.LoginUiState
import kursivee.com.helloworld.login.presentation.login.action.LoginRequestAction

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
                    components?.forEach {
                        render(it, state)
                    }
                }
            })
        }
    }

    private fun render(component: Component, state: LoginUiState) {
        when(component) {
            is BackgroundComponent -> {
                component.color?.let { color ->
                    cl_fragment.setBackgroundColor(
                        Color.parseColor(color)
                    )
                }
            }
            is UsernameComponent -> {
                et_username.visibility = View.VISIBLE
                et_username.hint = component.title
                et_username.setText(state.username)
            }
            is PasswordComponent -> {
                et_password.visibility = View.VISIBLE
                et_password.hint = component.title
                et_password.setText(state.password)
            }
            is ButtonComponent -> {
                btn_login.visibility = View.VISIBLE
                btn_login.text = component.title
                component.action?.let { action ->
                    when(action) {
                        is RequestAction -> {
                            btn_login.setOnClickListener {
                                viewModel.login(
                                    LoginRequestAction(action.endpoint!!, action.host!!, et_username.text.toString(), et_password.text.toString())
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
