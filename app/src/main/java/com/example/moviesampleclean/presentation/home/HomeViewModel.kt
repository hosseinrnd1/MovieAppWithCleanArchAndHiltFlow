package com.example.moviesampleclean.presentation.home

import androidx.lifecycle.viewModelScope
import com.example.moviesampleclean.data.movie.model.Data
import com.example.moviesampleclean.data.movie.model.Movie
import com.example.moviesampleclean.data.networking.CoroutineDispatcherProvider
import com.example.moviesampleclean.domain.movie.usecase.GetMovies
import com.example.moviesampleclean.domain.movie.usecase.SyncMovies
import com.example.moviesampleclean.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getMovies: GetMovies,private val sycMovies: SyncMovies,private val coroutineDispatcherProvider: CoroutineDispatcherProvider) : BaseViewModel() {
    private val _uiState= MutableStateFlow<MovieUiState>(MovieUiState.Loading)
    val uiState:StateFlow<MovieUiState> = _uiState
    init {
        _uiState.value=MovieUiState.Loading

        viewModelScope.launch(coroutineDispatcherProvider.IO()){
            getMovies()
                .catch{
                    _uiState.value=MovieUiState.Error(it.message?:"Error")
                }
                .collect{
                    if(it.data.isNullOrEmpty()){
                        sycMovies()
                    }
                    _uiState.value=MovieUiState.Loaded(it.data)
                }




        }
    }
}

sealed class MovieUiState{
    object Loading : MovieUiState()
    class Loaded(val movies:List<Data>) : MovieUiState()
    class Error(val message:String) : MovieUiState()
}