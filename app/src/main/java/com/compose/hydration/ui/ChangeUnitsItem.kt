package com.compose.hydration.ui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.compose.hydration.HydrationViewModel
import com.compose.hydration.R
import com.compose.hydration.ui.theme.HydrationChallengeTheme

@Composable
fun ChangeUnitsItem(modifier: Modifier, viewModel: HydrationViewModel) {
    val state = viewModel.uiState.collectAsState().value
    val keys = listOf("ml", "oz")
    val options = keys.zip(stringArrayResource(id = R.array.setting_options_units))
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(color = MaterialTheme.colors.surface)
    ) {
        SectionSpacer(modifier = modifier)
        options.forEach { option ->
            Surface(
                modifier = modifier
                    .heightIn(min = 56.dp).clickable {
                        viewModel.changeUnitType(option.first)
                    }
            ) {
                Row(
                    modifier = modifier.background(MaterialTheme.colors.secondary),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = option.second,
                        style = MaterialTheme.typography.body1,
                        modifier = modifier
                            .weight(1f)
                            .padding(16.dp)
                    )
                    if(state.units.equals(option.first)) {
                        Image(
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_checkmark_goal),
                            contentDescription = null,
                            modifier = Modifier.size(40.dp).padding(end = 16.dp),
                        )
                    }
                }
            }
            Divider(modifier = modifier, color = MaterialTheme.colors.onSurface.copy(alpha = 0.3f))
        }
    }
}

@Preview
@Composable
fun Preview_ChangeUnitsItem() {
    HydrationChallengeTheme {
        ChangeUnitsItem(modifier = Modifier, viewModel = viewModel())
    }
}