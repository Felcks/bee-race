package com.vivacious.beerace.race.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vivacious.beerace.core.domain.wrapper.Resource
import com.vivacious.beerace.race.domain.usecases.GetRaceDurationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getRaceDurationUseCase: GetRaceDurationUseCase
): ViewModel() {

    private val _uiState: MutableStateFlow<HomeScreenUIState> = MutableStateFlow(HomeScreenUIState())
    val uiState = _uiState.asStateFlow()

    fun handleScreenEvents(event: HomeScreenEvent) {
        when (event) {
            HomeScreenEvent.StartBeeRace -> startBeeRace()
            HomeScreenEvent.ResetTimer -> resetTimer()
        }
    }

    private fun resetTimer() {
        _uiState.value = _uiState.value.copy(newRaceTimeInSeconds = null)
    }

    private fun startBeeRace() {
        viewModelScope.launch(Dispatchers.IO) {
            getRaceDurationUseCase.invoke()
                .collect {  response ->
                    when (response) {
                        is Resource.Error -> _uiState.value =
                            _uiState.value.copy(error = "Failed to load")

                        Resource.Loading -> {} //_uiState.value = _uiState.value.copy(loading = true)
                        is Resource.Success -> _uiState.value = _uiState.value.copy(newRaceTimeInSeconds = response.data.timeInSeconds)
                    }
                }
        }
    }
}