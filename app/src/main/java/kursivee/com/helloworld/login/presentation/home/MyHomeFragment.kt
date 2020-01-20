package kursivee.com.helloworld.login.presentation.home

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import kursivee.com.helloworld.R

class MyHomeFragment : Fragment() {

    companion object {
        fun newInstance() = MyHomeFragment()
    }

    private lateinit var viewModel: MyHomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.my_home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MyHomeViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
