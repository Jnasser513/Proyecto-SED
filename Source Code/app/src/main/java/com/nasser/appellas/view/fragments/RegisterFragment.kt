package com.nasser.appellas.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.nasser.appellas.R
import com.nasser.appellas.databinding.RegisterFragmentBinding

class RegisterFragment: Fragment() {

    private lateinit var mBinding: RegisterFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.register_fragment, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mBinding.actionRegister.setOnClickListener { goLogin() }
        mBinding.registerSigninText.setOnClickListener { goLogin() }
        mBinding.registerReturnArrow.setOnClickListener { goLogin() }
    }

    private fun goLogin() {
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(android.R.id.content, LoginFragment.newInstance())
            ?.addToBackStack(null)
            ?.commit()
    }

    companion object {
        fun newInstance() = RegisterFragment()
    }

}