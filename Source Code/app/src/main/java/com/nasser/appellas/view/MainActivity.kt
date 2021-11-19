package com.nasser.appellas.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nasser.appellas.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.homepage_fragment)
    }
}