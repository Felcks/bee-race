package com.vivacious.beerace.race.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ClipEntry
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vivacious.beerace.core.presentation.theme.BeeRaceTheme
import com.vivacious.beerace.race.domain.models.Bee
import com.vivacious.beerace.race.presentation.R
import com.vivacious.beerace.race.presentation.RacePreviewUiDataProvider

@Composable
fun BeeImageAtom(bee: Bee, size: Int, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(size.dp)
            .clip(CircleShape)
            .background(HexToJetpackColor.getColor(bee.color))

    ) {
        Image(
            painter = painterResource(R.drawable.bee),
            contentDescription = null,
            modifier = Modifier
                .size((size / 2).dp)
                .align(Alignment.Center)
        )
    }
}

@Composable
fun WinnerBeeMolecule(bee: Bee, modifier: Modifier = Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier) {
        Text("Winner", fontSize = 24.sp, fontWeight = FontWeight.SemiBold)
        Spacer(Modifier.padding(top = 24.dp))
        BeeImageAtom(bee, 64)
        Spacer(Modifier.padding(top = 12.dp))
        BeePositionAtom(bee, 1)
    }
}

@Composable
fun BeePositionAtom(
    bee: Bee,
    position: Int,
    modifier: Modifier = Modifier,
    alignment: Alignment.Horizontal = Alignment.CenterHorizontally
) {
    Column(horizontalAlignment = alignment, modifier = modifier) {
        Text("${position}st", fontSize = 16.sp)
        Text(bee.name, color = Color.Gray, fontSize = 14.sp)
    }
}

@Composable
fun RaceBeeMolecule(bee: Bee, position: Int, modifier: Modifier = Modifier) {
    Column {
        Spacer(modifier = Modifier.padding(top = 16.dp))

        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row {
                Spacer(Modifier.padding(start = 16.dp))
                BeeImageAtom(bee, 48)
                Spacer(Modifier.padding(start = 16.dp))
                BeePositionAtom(bee, position, alignment = Alignment.Start)
            }

            Text("M", modifier = Modifier.padding(end = 16.dp))
        }

        Spacer(modifier = Modifier.padding(top = 16.dp))

        HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp))
    }

}

@Preview
@Composable
private fun BeeImageAtomPreview() {
    BeeRaceTheme {
        BeeImageAtom(RacePreviewUiDataProvider().bees.first(), 64)
    }
}


@Preview
@Composable
private fun WinnerBeeMoleculePreview() {
    BeeRaceTheme {
        WinnerBeeMolecule(RacePreviewUiDataProvider().bees.first())
    }
}

@Preview
@Composable
private fun BeePositionAtomPreview() {
    BeeRaceTheme {
        WinnerBeeMolecule(RacePreviewUiDataProvider().bees.first())
    }
}