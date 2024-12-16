package com.vivacious.beerace.race.presentation.race

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.vivacious.beerace.race.domain.models.Bee
import com.vivacious.beerace.race.presentation.components.RaceBeeMolecule

@Composable
fun RaceScreen(
    navigateToHomeScreen: (bee: Bee) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: RaceScreenViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold { innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {

            Box(
                modifier = Modifier
                    .background(Color.Black)
                    .fillMaxWidth()
                    .height(128.dp)
            ) {
                Text(
                    text = "${uiState.currentTime}s",
                    fontSize = 32.sp,
                    color = Color.White,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            Spacer(Modifier.padding(top = 32.dp))

            uiState.status?.let {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    itemsIndexed(it.bees) { index, bee ->
                        RaceBeeMolecule(bee, index + 1)

                    }
                }
            } ?: LoadingView(modifier = Modifier.fillMaxSize())

            LaunchedEffect(uiState.winner) {
                uiState.winner?.let {
                    navigateToHomeScreen(it)
                }
            }
        }
    }
}

@Composable
fun LoadingView(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        CircularProgressIndicator(
            modifier = Modifier
                .size(64.dp)
                .align(Alignment.Center)
        )
    }
}