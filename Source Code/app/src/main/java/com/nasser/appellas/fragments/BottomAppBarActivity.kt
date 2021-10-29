package com.nasser.appellas.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.nasser.appellas.R
import com.nasser.appellas.databinding.BottomAppBarBinding

class BottomAppBarActivity: AppCompatActivity() {

    private lateinit var mBinding: BottomAppBarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = BottomAppBarBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        setUpListeners()
    }

    private fun setUpListeners() {
        setUpNavigationDrawerListener()
        setUpMenuClickListener()
    }

    private fun setUpNavigationDrawerListener() {
        val bottomSheetBehavior = BottomSheetBehavior.from(mBinding.navigationView)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN

        mBinding.bottomAppBar.setNavigationOnClickListener {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        }

        mBinding.navigationView.setNavigationItemSelectedListener { menuItem ->
            // Handle menu item selected
            menuItem.isChecked = true
            when(menuItem.itemId) {
                R.id.settings -> {
                    Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show()
                }
            }

            bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
            true
        }

        mBinding.scrim1.setOnClickListener {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
        }

        bottomSheetBehavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(bottomSheet: View, slideOffset: Float) {
            }
            override fun onStateChanged(bottomSheet: View, newState: Int) {
            }
        })
    }

    private fun setUpMenuClickListener() {
        mBinding.bottomAppBar.setOnMenuItemClickListener {
            when(it.itemId) {
                R.id.action_profile -> Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show()
            }
            true
        }
    }

}