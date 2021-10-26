package com.nasser.appellas.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.nasser.appellas.R
import com.nasser.appellas.databinding.BottomNavigationDrawerFragmentBinding

class BottomNavigationDrawerFragment: Fragment() {

    private lateinit var mBinding: BottomNavigationDrawerFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        mBinding = BottomNavigationDrawerFragmentBinding.inflate(inflater, container, false)

        setUpNavigationDrawer()

        return mBinding.root
    }

    private fun setUpNavigationDrawer() {
        mBinding.navigationView.setNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.settings -> {
                    Toast.makeText(requireContext(), "Settings", Toast.LENGTH_SHORT).show()
                    return@setNavigationItemSelectedListener true
                }
                else ->{
                    Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show()
                    return@setNavigationItemSelectedListener true
                }
            }
        }
    }


}