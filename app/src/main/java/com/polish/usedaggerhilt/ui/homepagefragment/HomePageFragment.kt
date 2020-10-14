package com.polish.usedaggerhilt.ui.homepagefragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.polish.usedaggerhilt.R
import com.polish.usedaggerhilt.model.POSTItem
import com.polish.usedaggerhilt.util.DataState
import com.polish.usedaggerhilt.viewmodel.POSTViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home_page.*

/*
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

 */

/**
 * A simple [Fragment] subclass.
 * Use the [HomePageFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class HomePageFragment : Fragment() {

    val TAG = "Home_Page_Fragment"

    /**
     * instantiate the viewModel
     */
    private val viewModel:POSTViewModel by viewModels()

    /*
    private var param1: String? = null
    private var param2: String? = null

     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

         */



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel.myPost.observe(viewLifecycleOwner, Observer { dataState ->
            when(dataState){
                is DataState.Success<List<POSTItem>> -> {
//                    Log.d(TAG, "result:${dataState.data}")
                }
                is DataState.Error -> {

                }
                is DataState.loading -> {

                }
            }
        })

        /**
         * let us observe the database source from the liveData
         */
        viewModel.databaseSource.observe(viewLifecycleOwner, Observer {
//            Log.d(TAG, "this is from the database: ${it}")
            val posts = it
            val sb = StringBuilder()
            for (post in posts){
                sb.append(post.title + "\n")

            }
            display_content_tv.text = sb.toString()
        })

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_page, container, false)
    }
    /*
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomePageFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomePageFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

     */
}