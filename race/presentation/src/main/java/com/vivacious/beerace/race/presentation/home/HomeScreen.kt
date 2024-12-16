package com.vivacious.beerace.race.presentation.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.vivacious.beerace.core.presentation.theme.BeeRaceTheme
import com.vivacious.beerace.race.domain.models.Bee
import com.vivacious.beerace.race.presentation.R
import com.vivacious.beerace.race.presentation.components.WinnerBeeMolecule

@Composable
fun HomeScreen(
    navigateToRaceScreen: (startTime: Int) -> Unit,
    winnerBee: Bee?,
    modifier: Modifier = Modifier,
    viewModel: HomeScreenViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    val newRaceTimeInMilleSeconds = uiState.newRaceTimeInSeconds
    LaunchedEffect(newRaceTimeInMilleSeconds) {
        newRaceTimeInMilleSeconds?.let {
            viewModel.handleScreenEvents(HomeScreenEvent.ResetTimer)
            navigateToRaceScreen(newRaceTimeInMilleSeconds)
        }
    }


    Scaffold { innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Spacer(Modifier.padding(top = 32.dp))

            Box(modifier = Modifier.height(256.dp)) {
                winnerBee?.let {
                    WinnerBeeMolecule(
                        it,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }

            Spacer(Modifier.padding(top = 64.dp))

            StartBeeRaceButtonAtom(
                false,
                onClick = {
                    viewModel.handleScreenEvents(HomeScreenEvent.StartBeeRace)
                },
            )
        }
    }
}


@Composable
fun StartBeeRaceButtonAtom(isRestart: Boolean, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(onClick) {
        val text = if (!isRestart) {
            stringResource(R.string.home_screen_start_button)
        } else {
            stringResource(R.string.home_screen_restart_button)
        }
        Text(text)
    }
}

@Preview
@Composable
private fun StartBeeRaceButtonAtomPreview() {
    BeeRaceTheme {
        StartBeeRaceButtonAtom(isRestart = false, {})
    }
}

@Preview
@Composable
private fun RestartBeeRaceButtonAtomPreview() {
    BeeRaceTheme {
        StartBeeRaceButtonAtom(isRestart = true, {})
    }
}