package com.nasser.appellas

import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.navigation.NavigationView

class PruebaActivity:AppCompatActivity() {

    private lateinit var navigationView: NavigationView
    private lateinit var bottomAppBar: BottomAppBar
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var scrim: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.prueba)

        navigationView = findViewById(R.id.navigationView)
        bottomAppBar = findViewById(R.id.bottomAppBa)
        scrim = findViewById(R.id.scrim)
        drawerLayout = findViewById(R.id.prueba_drawer_layout)

        setSupportActionBar(bottomAppBar)

        val bottomSheetBehavior = BottomSheetBehavior.from(navigationView)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN

        bottomAppBar.setNavigationOnClickListener {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        }

        navigationView.setNavigationItemSelectedListener { menuItem ->
            // Handle menu item selected
            menuItem.isChecked = true

            supportActionBar?.setDisplayHomeAsUpEnabled(true)

            navigationView.setNavigationItemSelectedListener {
                when(it.itemId) {
                    R.id.settings -> {
                        Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show()
                    }
                }
                true
            }
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
            true
        }

        scrim.setOnClickListener {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
        }

        bottomSheetBehavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(bottomSheet: View, slideOffset: Float) {
            }
            override fun onStateChanged(bottomSheet: View, newState: Int) {
            }
        })
    }

    /*private lateinit var mBinding: PruebaBinding
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = PruebaBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        setUpNavClick()
    }

    private fun setUpNavClick(){
        toggle = ActionBarDrawerToggle(this, mBinding.pruebaDrawerLayout, R.string.open, R.string.close)
        mBinding.pruebaDrawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        mBinding.pruebaNavView.setNavigationItemSelectedListener{
            when(it.itemId){
                R.id.settings -> {
                    Toast.makeText(applicationContext, "Settings", Toast.LENGTH_SHORT).show()
                }
            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }

        return super.onOptionsItemSelected(item)
    }*/

}