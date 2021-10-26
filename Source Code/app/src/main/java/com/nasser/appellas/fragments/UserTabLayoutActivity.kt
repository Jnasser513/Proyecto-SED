package com.nasser.appellas.fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.nasser.appellas.R
import com.nasser.appellas.databinding.BottomNavigationMenuBinding
import com.nasser.appellas.fragments.adapters.UserViewPagerAdapter

class UserTabLayoutActivity: AppCompatActivity() {

    private lateinit var mBinding: BottomNavigationMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = BottomNavigationMenuBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        setUpTabs()
    }

    private fun setUpTabs() {
        val mAdapter = UserViewPagerAdapter(supportFragmentManager)
        mAdapter.addFragment(BlogFragment())
        mAdapter.addFragment(AdvisoryFragment())
        mAdapter.addFragment(InformativeMapFragment())
        mAdapter.addFragment(InformationPageFragment())
        mBinding.viewPager.adapter = mAdapter
        mBinding.userBottomTabLayout.setupWithViewPager(mBinding.viewPager)

        mBinding.userBottomTabLayout.getTabAt(0)!!.setIcon(R.drawable.ic_blogging)
        mBinding.userBottomTabLayout.getTabAt(1)!!.setIcon(R.drawable.ic_consulta)
        mBinding.userBottomTabLayout.getTabAt(2)!!.setIcon(R.drawable.ic_mapa)
        mBinding.userBottomTabLayout.getTabAt(3)!!.setIcon(R.drawable.ic_informacion)
    }
}