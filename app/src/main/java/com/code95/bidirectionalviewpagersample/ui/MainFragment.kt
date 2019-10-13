package com.code95.bidirectionalviewpagersample.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.code95.bidirectionalviewpagersample.R
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment() : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_main, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        section_label.text = arguments?.get("text") as String
    }

    companion object {
        fun NEW_INSTANCE(text: String?): MainFragment {
            val args = Bundle()
            args.putString("text", text)
            val f = MainFragment()
            f.setArguments(args)
            return f
        }
    }
}// Required empty public constructor