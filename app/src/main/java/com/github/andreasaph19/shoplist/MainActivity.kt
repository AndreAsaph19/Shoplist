package com.github.andreasaph19.shoplist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.andreasaph19.shoplist.ui.theme.ShoplistTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoplistTheme {
                MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
fun MyApp(modifier: Modifier = Modifier) {

    Surface(modifier) {
        Greetings()
    }
}

@Composable
private fun Greetings(
    modifier: Modifier = Modifier,
    names: List<Shop> = listaCompra
) {
    Column(modifier = modifier.padding(vertical = 4.dp)) {
        for (name in names) {
            Greeting(nome = name.nome, quant = name.quant, desc = name.desc)
        }
    }
}

@Composable
private fun Greeting(nome: String, quant: Int, desc: String) {

    val expanded = remember { mutableStateOf(false) }
    val extraPadding = if (expanded.value) 48.dp else 0.dp

    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(modifier = Modifier
                .weight(1f)
            ) {
                Text(text = nome)
                Text(if (expanded.value) "Quantidade: $quant" else " ")
                Text(if (expanded.value) "$desc" else " ")
            }
            Button(
                onClick = { expanded.value = !expanded.value }
            ) {
                Text(if (expanded.value) "Mostrar menos" else "Mostrar mais")
            }

        }
    }
}


@Preview(showBackground = true, widthDp = 320)
@Composable
fun DefaultPreview() {
    ShoplistTheme {
        Greetings()
    }
}

@Preview
@Composable
fun MyAppPreview() {
    ShoplistTheme() {
        MyApp(Modifier.fillMaxSize())
    }
}


data class Shop(
    val nome: String,
    val quant: Int,
    val desc: String
)

val listaCompra = listOf(
    Shop(nome = "Suco de Maracujá",
        quant = 19,
        desc = "O mais gostoso"),
    Shop(nome = "Air Jordan",
        quant = 15,
        desc = "o tênis mais bonito"),
    Shop(nome = "Chiclete Trident",
        quant = 27,
        desc = "o melhor para qualquer ocasião"),
    Shop(nome = "Toddy",
        quant = 108,
        desc = "o melhor que Nescau"),
    Shop(nome = "Creme de Cabelo",
        quant = 125,
        desc = "O melhor para seu cabelo")
)