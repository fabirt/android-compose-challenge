package com.fabirt.bloom.ui.login

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun LoginTextField(
    modifier: Modifier,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    hintText: String,
    labelText: String,
    onValueChanged: (String) -> Unit
) {
    var value by rememberSaveable { mutableStateOf("") }
    val color = MaterialTheme.colors.onBackground

    // Modifies text selection colors (by default it will take the primary color from MaterialTheme)
    val selectionColors = rememberTextSelectionColors(MaterialTheme.colors.copy(primary = color))

    CompositionLocalProvider(LocalTextSelectionColors provides selectionColors) {
        SelectionContainer {
            OutlinedTextField(
                value = value,
                placeholder = { Text(text = hintText) },
                label = { Text(text = labelText) },
                onValueChange = {
                    value = it
                    onValueChanged(it)
                },
                keyboardOptions = keyboardOptions,
                visualTransformation = visualTransformation,
                textStyle = MaterialTheme.typography.body1.copy(
                    color = color
                ),
                keyboardActions = keyboardActions,
                modifier = modifier,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = color,
                    unfocusedBorderColor = color,
                    cursorColor = color,
                    focusedLabelColor = color,
                    unfocusedLabelColor = color
                )
            )
        }
    }
}

@Composable
internal fun rememberTextSelectionColors(colors: Colors): TextSelectionColors {
    val primaryColor = colors.primary

    return remember(primaryColor) {
        TextSelectionColors(
            handleColor = primaryColor,
            backgroundColor = primaryColor.copy(alpha = 0.16f),
        )
    }
}