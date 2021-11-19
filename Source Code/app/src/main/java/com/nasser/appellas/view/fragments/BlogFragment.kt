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

    /*private fun setUpNavigation() {
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.page_blog -> {
                    /** Ir a pagina de Blogs **/
                    DrawableCompat.setTint(item.icon, R.color.white.toInt())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.page_advisory -> {
                    /** Ir a pagina de asesoria **/
                    DrawableCompat.setTint(item.icon, R.color.white.toInt())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.page_map -> {
                    /** Ir a pagina de mapa **/
                    DrawableCompat.setTint(item.icon, R.color.white.toInt())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.page_information -> {
                    /** Ir a pagina de informacion **/
                    DrawableCompat.setTint(item.icon, R.color.white.toInt())
                    return@OnNavigationItemSelectedListener true
                }
                else -> {
                    DrawableCompat.setTint(item.icon, R.color.primary_color.toInt())
                    return@OnNavigationItemSelectedListener false
                }
            }
        }
    }*/

    /*
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.bottom_navigation_menu, menu)

        for(i in 0 until menu.size()) {
            var menuItem = menu.getItem(i)

            val icon = menuItem.icon
            if(icon != null){
                DrawableCompat.setTint(icon, ContextCompat.getColor(requireContext(), R.color.primary_color))
            }
        }

        return super.onCreateOptionsMenu(menu, inflater)
    }*/

}
