package com.olivix.flow_snikers_app.feature.sneaker.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.olivix.flow_snikers_app.feature.sneaker.domain.GetListSneakersUseCase
import com.olivix.flow_snikers_app.feature.sneaker.domain.Sneaker
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel


@KoinViewModel
class SneakersViewModel(
    private val getListSneakersUseCase: GetListSneakersUseCase
) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

    private var fullList = emptyList<Sneaker>()
    var selectedTabIndex = 0
    private var currentBrand: String? = null
    private var isInitialLoad = true


    fun loadSnikersList() {

        if (isInitialLoad) {
            _uiState.value = UiState(isLoading = true, sneakersLoaded = emptyList())
        }
        if (fullList.isNotEmpty()) {
            _uiState.value = UiState(
                sneakersLoaded =
                    currentBrand?.let { b ->
                        if (b.equals("ALL", true)) fullList
                        else fullList.filter { it.brand.equals(b, ignoreCase = true) }
                    } ?: fullList,
                isLoading = false
            )
            return
        }

        viewModelScope.launch(Dispatchers.IO) {
            try {

                fullList = getListSneakersUseCase()
                isInitialLoad = false
                delay(1000)
                _uiState.postValue(
                    UiState(
                        sneakersLoaded = fullList, isLoading = false
                    )
                )
            } catch (e: Exception) {
                _uiState.postValue(
                    UiState(
                        sneakersLoaded = emptyList(), isLoading = false
                    )
                )
            }
        }
    }


    fun filterSneakersByBrand(brand: String?, tabIndex: Int) {
        selectedTabIndex = tabIndex
        currentBrand = brand
        val filtered = if (brand.isNullOrBlank() || brand.equals("ALL", ignoreCase = true)) {
            fullList
        } else {
            fullList.filter { it.brand.equals(brand, ignoreCase = true) }
        }
        _uiState.value = UiState(sneakersLoaded = filtered, isLoading = false)
    }

    data class UiState(
        val sneakersLoaded: List<Sneaker> = emptyList(), val isLoading: Boolean = false
    )
}

