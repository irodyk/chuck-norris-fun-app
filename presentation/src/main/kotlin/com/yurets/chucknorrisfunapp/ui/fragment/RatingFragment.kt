package com.yurets.chucknorrisfunapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yurets.chucknorrisfunapp.R
import com.yurets.chucknorrisfunapp.ui.abs.BaseFragment

class RatingFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            inflater.inflate(R.layout.fragment_rating, container, false)
}
