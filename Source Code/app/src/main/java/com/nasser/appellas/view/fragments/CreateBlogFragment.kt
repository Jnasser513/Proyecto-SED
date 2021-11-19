package com.nasser.appellas.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.nasser.appellas.R
import com.nasser.appellas.databinding.CreateBlogFragmentBinding

class CreateBlogFragment: Fragment() {

    private lateinit var mBinding: CreateBlogFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.create_blog_fragment, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mBinding.actionReturn.setOnClickListener { goBlog() }
        mBinding.actionShare.setOnClickListener { goBlog() }
    }

    private fun goBlog() {
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(android.R.id.content, BlogFragment.newInstance())
            ?.addToBackStack(null)
            ?.commit()
    }

    companion object {
        fun newInstance() = CreateBlogFragment()
    }

}