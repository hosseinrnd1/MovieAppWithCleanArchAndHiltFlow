package com.example.moviesampleclean.presentation.profile

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import com.example.moviesampleclean.databinding.FragmentHomeBinding
import com.example.moviesampleclean.databinding.FragmentProfileBinding
import com.example.moviesampleclean.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProfileFragment : BaseFragment<FragmentProfileBinding>() {
    val viewModel:ProfileViewModel by viewModels()

    override fun constructViewBinding(): ViewBinding {
        return FragmentProfileBinding.inflate(layoutInflater)
    }

    override fun init(viewBinding: ViewBinding) {
       getViewBinding().btnLogin.setOnClickListener {
              val userName=getViewBinding().userNameTIE.text.toString()
              val password=getViewBinding().passwordTIE.text.toString()

           lifecycleScope.launch {
               viewModel.saveUserName(userName,password)
           }
       }

        getViewBinding().btnGetPassword.setOnClickListener {
            lifecycleScope.launch {
                getViewBinding().passwordTV.text=viewModel.getUserName(getViewBinding().userNameKeyTIE.text.toString())
            }
        }
    }
}