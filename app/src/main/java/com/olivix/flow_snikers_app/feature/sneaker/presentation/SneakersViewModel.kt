package com.olivix.flow_snikers_app.feature.sneaker.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.olivix.flow_snikers_app.feature.sneaker.domain.GetListSneakersUseCase
import com.olivix.flow_snikers_app.feature.sneaker.domain.Sneaker
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class SneakersViewModel(private val getListSneakersUseCase: GetListSneakersUseCase) : ViewModel() {

    private val _uiState = MutableLiveData(UiState())
    val uiState: LiveData<UiState> get() = _uiState

    fun loadSnikersList() {
        viewModelScope.launch(Dispatchers.IO) {
            val snk = getListSneakersUseCase()
            _uiState.postValue(UiState(sneakersLoaded = snk))
        }
    }

    data class UiState(
        val sneakersLoaded: List<Sneaker> = emptyList(),
    )
}