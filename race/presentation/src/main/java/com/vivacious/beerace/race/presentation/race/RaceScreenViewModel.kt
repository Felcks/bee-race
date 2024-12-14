package com.vivacious.beerace.race.presentation.race

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vivacious.beerace.core.domain.wrapper.Resource
import com.vivacious.beerace.race.domain.usecases.GetRaceDurationUseCase
import com.vivacious.beerace.race.domain.usecases.GetRaceStatusUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RaceScreenViewModel @Inject constructor(
    private val getRaceStatusUseCase: GetRaceStatusUseCase,
    savedStateHandle: SavedStateHandle,
): ViewModel() {

    private var startTime: Int? = null

    private val _uiState: MutableStateFlow<RaceScreenUIState> = MutableStateFlow(RaceScreenUIState())
    val uiState = _uiState.asStateFlow()

    init {
        startTime = savedStateHandle["startTime"]
        _uiState.value = uiState.value.copy(startTime = startTime)
        loadRaceStatus()
    }

    fun handleScreenEvents(event: RaceScreenEvent) {
        when (event) {
            else -> {}
        }
    }

    private fun loadRaceStatus() {
        viewModelScope.launch(Dispatchers.IO) {
            getRaceStatusUseCase.invoke()
                .collect {  response ->
                    when (response) {
                        is Resource.Error -> _uiState.value =
                            _uiState.value.copy(error = "Failed to load")
                        Resource.Loading -> {} //_uiState.value = _uiState.value.copy(loading = true)
                        is Resource.Success -> _uiState.value = _uiState.value.copy(
                            status = response.data
                        )
                    }
                }
        }
    }
}