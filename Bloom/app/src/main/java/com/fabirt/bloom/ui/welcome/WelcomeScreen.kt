package com.fabirt.bloom.ui.welcome

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fabirt.bloom.ui.components.StadiumShapeButton
import com.fabirt.bloom.ui.theme.BloomTheme
import com.fabirt.bloom.ui.theme.White
import com.google.accompanist.insets.systemBarsPadding

@Composable
fun WelcomeScreen() {
    Scaffold(
        backgroundColor = MaterialTheme.colors.primary
    ) {
        Box(Modifier.systemBarsPadding()) {
            Icon(
                painter = painterResource(id = BloomTheme.data.welcomeBg),
                contentDescription = null,
                tint = White,
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Icon(
                    painter = painterResource(id = BloomTheme.data.welcomeIllos),
                    contentDescription = null,
                    tint = BloomTheme.data.welcomeIllosColor,
                    modifier = Modifier
                        .padding(
                            top = 72.dp,
                            bottom = 48.dp
                        )
                        .absoluteOffset(88.dp, 0.dp)
                )

                Spacer(Modifier.weight(1f))

                Icon(
                    painter = painterResource(id = BloomTheme.data.logo),
                    contentDescription = null
                )
                Text(
                    text = "Beautiful home garden solutions",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.subtitle1,
                    modifier = Modifier.padding(top = 8.dp, bottom = 40.dp)
                )

                StadiumShapeButton(
                    text = "Create account",
                    textColor = MaterialTheme.colors.onSecondary,
                    backgroundColor = MaterialTheme.colors.secondary
                ) {
                    // TODO
                }
                Spacer(modifier = Modifier.height(8.dp))

                StadiumShapeButton(
                    text = "Log in",
                    textColor = MaterialTheme.colors.secondary,
                ) {
                    // TODO
                }

                Spacer(modifier = Modifier.height(40.dp))
            }
        }

    }

}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun WelcomeScreenPreview() {
    BloomTheme {
        WelcomeScreen()
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun WelcomeScreenDarkPreview() {
    BloomTheme(darkTheme = true) {
        WelcomeScreen()
    }
}
