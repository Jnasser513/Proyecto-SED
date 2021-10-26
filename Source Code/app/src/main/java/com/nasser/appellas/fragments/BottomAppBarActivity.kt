package com.nasser.appellas.fragments

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.nasser.appellas.R
import com.nasser.appellas.databinding.BottomAppBarBinding

class BottomAppBarActivity: AppCompatActivity() {

    private lateinit var mBinding: BottomAppBarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = BottomAppBarBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        setSupportActionBar(mBinding.bottomAppBar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.bottom_app_bar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.settings
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setUpNavigationListener() {
        mBinding.bottomAppBar.setNavigationOnClickListener {
            
        }
    }

}