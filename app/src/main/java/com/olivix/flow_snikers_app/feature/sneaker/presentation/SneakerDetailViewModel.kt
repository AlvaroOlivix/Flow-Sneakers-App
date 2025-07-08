package com.olivix.flow_snikers_app.feature.sneaker.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.olivix.flow_snikers_app.feature.sneaker.domain.GetSneakerUseCase
import com.olivix.flow_snikers_app.feature.sneaker.domain.Sneaker
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class SneakerDetailViewModel(private val getSneakerDetailUseCase: GetSneakerUseCase) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> get() = _uiState

    fun loadSneakerDetail(sneakerId: String) {
        _uiState.value = UiState(isLoading = true)
        viewModelScope.launch(Dispatchers.IO) {
            val sneakerL = getSneakerDetailUseCase(sneakerId)
            _uiState.postValue(UiState(sneakerLoaded = sneakerL))
        }
    }

    data class UiState(
        val isLoading: Boolean = false,
        val error: Boolean = false,
        val sneakerLoaded: Sneaker? = null

    )
}