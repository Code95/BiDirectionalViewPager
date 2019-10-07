package com.code95.rtlsampleproject.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.code95.rtlsampleproject.R
import kotlinx.android.synthetic.main.fragment_sample.*

private const val ARG_PARAM1 = "title"
private const val ARG_PARAM2 = "typeId"

class SampleFragment : Fragment() {

    private var title: String? = null
    private var typeId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            title = it.getString(ARG_PARAM1)
            typeId = it.getInt(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sample, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (typeId == 1) {
            contentTV.text = title
        } else if (typeId == 2) {
            contentTV.text = title
        } else if (typeId == 3) {
            contentTV.text = title
        }
    }

    companion object {
        fun newInstance(title: String, typeId: Int) =
            SampleFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, title)
                    putInt(ARG_PARAM2, typeId)
                }
            }
    }
}
