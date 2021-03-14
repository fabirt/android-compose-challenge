package com.fabirt.bloom.ui.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.fabirt.bloom.R
import com.fabirt.bloom.ui.components.StadiumShapeButton
import com.google.accompanist.insets.systemBarsPadding

@Composable
fun LoginScreen(
    navController: NavHostController
) {
    Scaffold(backgroundColor = MaterialTheme.colors.background) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .systemBarsPadding(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            StadiumShapeButton(
                text = stringResource(id = R.string.log_in),
                textColor = MaterialTheme.colors.onSecondary,
                backgroundColor = MaterialTheme.colors.secondary,
                onClick = { /*TODO*/ }
            )
        }
    }
}
