package fr.eni.shop_info.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.viewModelFactory
import fr.eni.shop_info.bo.Article
import fr.eni.shop_info.ui.common.TopBar
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun CalculatriceScreen(
    modifier: Modifier = Modifier,
    article: Article,
) {

    Scaffold(
        // topBar = { TopBar() }
    ) {

        Column(
            modifier = modifier.padding(it)
        ) {
            Compteur()
        }
    }
}

@Preview
@Composable
fun Compteur ( vm : CompteurViewModel = viewModel()) {
    val compteur = vm.compteurState.collectAsState()
    Column(Modifier.fillMaxWidth(), horizontalAlignment= Alignment.CenterHorizontally) {
        Text(compteur.value.toString() ?: "0")
        Row {
            IconButton(onClick = { vm.increment()}) {
                Icon(imageVector = Icons.Default.KeyboardArrowUp, contentDescription = null)
            }
            IconButton(onClick = {vm.decrement()}) {
                Icon(imageVector = Icons.Default.KeyboardArrowDown, contentDescription = null)
            }

        }
    }
}

class CompteurViewModel: ViewModel() {
    private val _compteurState = MutableStateFlow(0)
    val compteurState = _compteurState.asStateFlow()

    fun increment () {
        val newValue = _compteurState.value + 1
        _compteurState.value = newValue
    }

    fun decrement () {
        val newValue = _compteurState.value - 1
        _compteurState.value = newValue
    }


}