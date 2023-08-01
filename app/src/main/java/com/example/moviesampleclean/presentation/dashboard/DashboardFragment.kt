package com.example.moviesampleclean.presentation.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.moviesampleclean.databinding.FragamentDashboardBinding
import com.example.moviesampleclean.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : BaseFragment<FragamentDashboardBinding>() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun constructViewBinding(): ViewBinding {
        return FragamentDashboardBinding.inflate(layoutInflater)
    }

    override fun init(viewBinding: ViewBinding) {
        getViewBinding().dashboard.text="dashboard"
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}