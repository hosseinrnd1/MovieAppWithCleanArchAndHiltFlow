package com.example.moviesampleclean.presentation.base

import com.example.moviesampleclean.presentation.base.BaseView
import android.content.Context
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.children
import org.greenrobot.eventbus.EventBus

abstract class BaseActivity: BaseView, AppCompatActivity(){
    override val rootView: CoordinatorLayout?
        get() {
            val viewGroup=findViewById(android.R.id.content) as ViewGroup
            if(viewGroup !is CoordinatorLayout){
                viewGroup.children.forEach {
                    if(it is CoordinatorLayout)
                        return it
                }
                throw IllegalStateException("RootView must be Instance of Coordinator layout")

            }else{
                return viewGroup
            }
        }
    override val viewContext: Context?
        get() = this
    

}