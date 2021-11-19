package com.nasser.appellas.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.nasser.appellas.R
import com.nasser.appellas.databinding.UserProfileFragmentBinding

class UserProfileFragment: Fragment() {

    private lateinit var mBinding: UserProfileFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.user_profile_fragment, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mBinding.actionReturn.setOnClickListener { goHomePage() }
    }

    private fun goHomePage() {
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(android.R.id.content, HomePageFragment.newInstance())
            ?.addToBackStack(null)
            ?.commit()
    }

}