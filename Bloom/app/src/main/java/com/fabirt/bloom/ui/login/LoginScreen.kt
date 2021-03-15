package com.fabirt.bloom.ui.login

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusOrder
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.fabirt.bloom.R
import com.fabirt.bloom.navigation.Destinations
import com.fabirt.bloom.ui.common.StadiumShapeButton
import com.fabirt.bloom.ui.theme.BloomTheme
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.systemBarsPadding

@ExperimentalComposeUiApi
@Composable
fun LoginScreen(
    navController: NavHostController? = null
) {
    val commonModifier = Modifier
        .padding(horizontal = 16.dp)
        .fillMaxWidth()

    val emailFocusRequester = FocusRequester()
    val passwordFocusRequester = FocusRequester()
    val keyboardController = LocalSoftwareKeyboardController.current

    Scaffold(backgroundColor = MaterialTheme.colors.background) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .systemBarsPadding(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.login_with_email),
                style = MaterialTheme.typography.h1.copy(
                    color = MaterialTheme.colors.onBackground
                )
            )
            Spacer(Modifier.height(8.dp))

            LoginTextField(
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = { passwordFocusRequester.requestFocus() }
                ),
                modifier = commonModifier.focusOrder(emailFocusRequester),
                hintText = stringResource(R.string.email_hint),
                labelText = stringResource(R.string.email_label)
            ) {
                //
            }
            LoginTextField(
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = { keyboardController?.hideSoftwareKeyboard() }
                ),
                visualTransformation = PasswordVisualTransformation(),
                modifier = commonModifier.focusOrder(passwordFocusRequester),
                hintText = stringResource(R.string.password_hint),
                labelText = stringResource(R.string.password_label)
            ) {
                //
            }

            Spacer(Modifier.height(10.dp))

            Text(
                text = stringResource(R.string.terms_and_conditions),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.body2.copy(
                    color = MaterialTheme.colors.onBackground
                ),
                modifier = commonModifier
            )

            Spacer(Modifier.height(16.dp))

            StadiumShapeButton(
                text = stringResource(R.string.log_in),
                textColor = MaterialTheme.colors.onSecondary,
                backgroundColor = MaterialTheme.colors.secondary,
                onClick = {
                    navController?.navigate(Destinations.home)
                }
            )
        }
    }
}

@ExperimentalComposeUiApi
@Preview
@Composable
fun LoginScreenPreview() {
    BloomTheme {
        ProvideWindowInsets {
            LoginScreen()
        }
    }
}
