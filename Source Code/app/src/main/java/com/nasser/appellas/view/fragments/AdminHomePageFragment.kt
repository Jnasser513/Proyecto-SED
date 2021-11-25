package com.nasser.appellas.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.nasser.appellas.R
import com.nasser.appellas.databinding.AdminHomepageFragmentBinding

class AdminHomePageFragment: Fragment() {

    private lateinit var mBinding: AdminHomepageFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.admin_homepage_fragment, container, false)
        return mBinding.root
    }

    companion object {
        fun newInstance() = AdminHomePageFragment()
    }

}