package com.nasser.appellas.view.fragments

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.nasser.appellas.R
import com.nasser.appellas.databinding.BlogFragmentBinding

class BlogFragment: Fragment() {

    private lateinit var mBinding: BlogFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.blog_fragment, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mBinding.actionReturn.setOnClickListener { goHomePage() }
        mBinding.floatingActionNew.setOnClickListener { goCreateBlog() }
    }

    private fun goCreateBlog() {
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(android.R.id.content, CreateBlogFragment.newInstance())
            ?.addToBackStack(null)
            ?.commit()
    }

    private fun goHomePage() {
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(android.R.id.content, HomePageFragment.newInstance())
            ?.addToBackStack(null)
            ?.commit()
    }

    companion object {
        fun newInstance() = BlogFragment()
    }

}
