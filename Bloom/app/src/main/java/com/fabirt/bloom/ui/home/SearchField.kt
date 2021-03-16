package com.fabirt.bloom.ui.home

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import com.fabirt.bloom.R
import com.fabirt.bloom.ui.common.BloomTextField

@Composable
fun SearchField(
    modifier: Modifier = Modifier
) {
    BloomTextField(
        hintText = stringResource(R.string.search),
        leadingIcon = { Icon(Icons.Rounded.Search, contentDescription = null) },
        onValueChanged = { /*TODO*/ },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Search,
            capitalization = KeyboardCapitalization.Sentences,
            keyboardType = KeyboardType.Text
        ),
        keyboardActions = KeyboardActions(
            onAny = {}
        ),
        modifier = modifier
    )
}
