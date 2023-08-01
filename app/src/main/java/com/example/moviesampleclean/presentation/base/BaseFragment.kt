package com.example.moviesampleclean.presentation.base

import com.example.moviesampleclean.presentation.base.BaseView
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.moviesampleclean.util.exception.MovieException
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

abstract class BaseFragment<T> : Fragment(), BaseView {

    private var viewBinding:ViewBinding? = null

    override val rootView: CoordinatorLayout?
        get() = view as CoordinatorLayout
    override val viewContext: Context?
        get() = context

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewBinding=constructViewBinding()
        viewBinding?.let { init(it) }
        return viewBinding?.root
    }

    fun getViewBinding():T=viewBinding as T


    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding=null
    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun showError(movieException: MovieException){
        viewContext?.let {
            when(movieException.type){
                MovieException.Type.SIMPLE->{
                    Toast.makeText(it,movieException.serverMessage, Toast.LENGTH_SHORT).show()
                }
                MovieException.Type.DIALOG->{
                    Toast.makeText(it,movieException.serverMessage, Toast.LENGTH_SHORT).show()

                }
                MovieException.Type.AUTH->{
                    Toast.makeText(it,movieException.serverMessage, Toast.LENGTH_SHORT).show()

                }
            }
        }

    }







    abstract fun constructViewBinding():ViewBinding

    abstract fun init(viewBinding: ViewBinding)
}