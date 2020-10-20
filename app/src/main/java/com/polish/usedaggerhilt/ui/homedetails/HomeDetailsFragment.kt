package com.polish.usedaggerhilt.ui.homedetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.polish.usedaggerhilt.R



/**
 * A simple [Fragment] subclass.
 * Use the [HomeDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeDetailsFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_details, container, false)
    }


}