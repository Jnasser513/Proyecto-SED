package com.nasser.appellas.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.nasser.appellas.R
import com.nasser.appellas.databinding.LoginFragmentBinding

class LoginFragment: Fragment() {

    private lateinit var mBinding: LoginFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.login_fragment, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mBinding.loginSignupText.setOnClickListener {
            goRegister()
        }

        mBinding.loginForgotText.setOnClickListener {
            goRecoveryPassword()
        }

        mBinding.actionLogin.setOnClickListener {
            goHomePageFragment()
        }
    }

    private fun goRegister() {
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(android.R.id.content, RegisterFragment.newInstance())
            ?.addToBackStack(null)
            ?.commit()
    }

    private fun goRecoveryPassword() {
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(android.R.id.content, ChangePasswordFragment.newInstance())
            ?.addToBackStack(null)
            ?.commit()
    }

    private fun goHomePageFragment() {
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(android.R.id.content, HomePageFragment.newInstance())
            ?.addToBackStack(null)
            ?.commit()
    }

    companion object {
        fun newInstance() = LoginFragment()
    }

}