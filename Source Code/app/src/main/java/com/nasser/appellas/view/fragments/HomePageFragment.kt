package com.nasser.appellas.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.nasser.appellas.R
import com.nasser.appellas.databinding.HomepageFragmentBinding

class HomePageFragment: Fragment() {

    private lateinit var mBinding: HomepageFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.homepage_fragment, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mBinding.homepageCardViewBlog.setOnClickListener { goBlog() }
        mBinding.homepageCardViewAdvisory.setOnClickListener { goAdvisory() }
        mBinding.homepageCardViewMap.setOnClickListener { goInformativeMap() }
        mBinding.homepageCardViewInformationPage.setOnClickListener { goInformativePage() }
    }

    private fun goInformativePage() {
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(android.R.id.content, InformationPageFragment.newInstance())
            ?.addToBackStack(null)
            ?.commit()
    }

    private fun goInformativeMap() {
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(android.R.id.content, InformativeMapFragment.newInstance())
            ?.addToBackStack(null)
            ?.commit()
    }

    private fun goAdvisory() {
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(android.R.id.content, AdvisoryFragment.newInstance())
            ?.addToBackStack(null)
            ?.commit()
    }

    private fun goBlog() {
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(android.R.id.content, BlogFragment.newInstance())
            ?.addToBackStack(null)
            ?.commit()
    }

    companion object{
        fun newInstance() = HomePageFragment()
    }

}