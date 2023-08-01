package com.example.moviesampleclean.presentation.base

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.example.moviesampleclean.R
import com.example.moviesampleclean.util.exception.MovieException
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

interface BaseView {
    val rootView: CoordinatorLayout?
    val viewContext: Context?
    fun setProgressBarIndicator(mustShow: Boolean) {

        rootView?.let {
            viewContext?.let { context ->
                var loadingView = it.findViewById<View>(R.id.loadingView)
                if (loadingView == null && mustShow) {
                    loadingView =
                        LayoutInflater.from(viewContext).inflate(R.layout.loading_view, it, false)
                    it.addView(loadingView)
                }
                loadingView?.visibility = if (mustShow) View.VISIBLE else View.GONE


            }
        }

    }

    fun showEmptyState(layoutResId: Int): View? {
        rootView?.let {
            viewContext?.let { context ->
                var emptyState = it.findViewById<View>(R.id.emptyStateRootView)
                if (emptyState == null) {
                    emptyState = LayoutInflater.from(context).inflate(layoutResId, it, false)
                    it.addView(emptyState)
                }
                emptyState?.visibility = View.VISIBLE
                return emptyState

            }
        }
        return null

    }


}