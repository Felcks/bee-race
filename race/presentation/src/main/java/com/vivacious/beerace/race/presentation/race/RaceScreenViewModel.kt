package com.vivacious.beerace.race.presentation.race

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vivacious.beerace.core.domain.wrapper.Resource
import com.vivacious.beerace.race.domain.usecases.GetRaceDurationUseCase
import com.vivacious.beerace.race.domain.usecases.GetRaceStatusUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class RaceScreenViewModel @Inject constructor(
    private val getRaceStatusUseCase: GetRaceStatusUseCase,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private var startTime: Int? = null

    private val _uiState: MutableStateFlow<RaceScreenUIState> = MutableStateFlow(RaceScreenUIState())
    val uiState = _uiState.asStateFlow()

    init {
        startTime = savedStateHandle["startTime"]
        _uiState.value = uiState.value.copy(currentTime = startTime)
        startTimer()
    }

    fun handleScreenEvents(event: RaceScreenEvent) {
        when (event) {
            else -> {}
        }
    }

    private suspend fun loadRaceStatus() {
        withContext(Dispatchers.IO) {
            getRaceStatusUseCase.invoke()
                .collect { response ->
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

    private fun startTimer() {
        viewModelScope.launch(Dispatchers.Default) {
            do {
                loadRaceStatus()
                delay(1000)
                _uiState.value = _uiState.value.copy(currentTime = _uiState.value.currentTime?.minus(1))
            }
            while ((_uiState.value.currentTime ?: 0) > 0)

            _uiState.value = _uiState.value.copy(winner = _uiState.value.status?.bees?.first())
        }
    }
}