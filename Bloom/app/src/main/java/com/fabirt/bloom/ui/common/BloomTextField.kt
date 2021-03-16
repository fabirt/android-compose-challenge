package com.fabirt.bloom.ui.common

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun BloomTextField(
    modifier: Modifier = Modifier,
    leadingIcon: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    hintText: String,
    label: @Composable (() -> Unit)? = null,
    onValueChanged: (String) -> Unit
) {
    var value by rememberSaveable { mutableStateOf("") }
    val color = MaterialTheme.colors.onBackground

    TextSelectionColorsProvider(colors = MaterialTheme.colors.copy(primary = color)) {
        SelectionContainer {
            OutlinedTextField(
                value = value,
                label = label,
                placeholder =  { Text(text = hintText) },
                leadingIcon = leadingIcon,
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