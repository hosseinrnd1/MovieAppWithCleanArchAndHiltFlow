package com.example.moviesampleclean.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.moviesampleclean.data.movie.model.Data
import com.example.moviesampleclean.databinding.FragmentHomeBinding
import com.example.moviesampleclean.presentation.base.BaseFragment
import com.example.moviesampleclean.util.isOnline
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(){
    val viewModel:HomeViewModel by viewModels()

    @Inject
    lateinit var movieAdapter: MovieAdapter


    override fun constructViewBinding(): ViewBinding {
        return FragmentHomeBinding.inflate(layoutInflater)
    }

    override fun init(viewBinding: ViewBinding) {
        initUi()
        fetchMovies()
    }

    private fun initUi() {
        getViewBinding().rvHomeMovies.run {
            layoutManager=LinearLayoutManager(context,RecyclerView.VERTICAL,false)
            adapter=movieAdapter
        }
    }

    private fun fetchMovies() {
        if(isOnline(requireContext())){
            lifecycleScope.launch{
                repeatOnLifecycle(Lifecycle.State.STARTED){
                    viewModel.uiState.collect{
                        when(it){
                            is MovieUiState.Loading -> setProgressBarIndicator(true)
                            is MovieUiState.Loaded -> {
                                onLoaded(it.movies)
                                setProgressBarIndicator(false)}
                            is MovieUiState.Error -> showError(it.message)
                        }
                    }
                }
            }
        }

        else{
            Toast.makeText(context,"No Internet Connection",Toast.LENGTH_SHORT).show()
        }

    }

    private fun onLoaded(movies: List<Data>) {
        movieAdapter.movies=movies as ArrayList<Data>
    }

    private fun showError(message: String) {
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show()
    }

    }



