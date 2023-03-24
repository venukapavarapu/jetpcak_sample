package com.example.jetpcaksample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.example.jetpcaksample.ui.theme.JetpcakSampleTheme
import kotlin.random.Random

class ThirdActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpcakSampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    makeGrids()
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun makeGrids(){

    val list = (1..20).map { it.toString() }

    LazyVerticalGrid(columns = GridCells.Fixed(3), contentPadding = PaddingValues(10.dp,), content = {
        items(list.size){
            Card(modifier = Modifier.padding(4.dp),
            backgroundColor = Color(red=Random.nextInt(256), green = Random.nextInt(300),blue = Random.nextInt(300))) {
                Text(text = list[it], color = Color.Black, textAlign = TextAlign.Center,
                modifier = Modifier.padding(10.dp))
            }
        }
    })
}