package com.polish.usedaggerhilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.polish.usedaggerhilt.viewmodel.POSTViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val TAG = "MAIN_ACTIVITY"

    /**
     * this is to instantiate the viewModel
     */
    private val viewModel:POSTViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
            setup the navigation controller
         */
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_FragmentId) as NavHostFragment
        NavigationUI.setupWithNavController(main_activity_bottom_nav, navHostFragment.navController)

    }
}

