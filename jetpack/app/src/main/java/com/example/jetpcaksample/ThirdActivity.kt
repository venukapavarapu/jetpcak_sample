package com.example.jetpcaksample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.example.jetpcaksample.data.GridItems
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
                    Column {
                        makeGrids()
                        makeStaggeredGrids()
                    }
                    
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


@OptIn(ExperimentalFoundationApi::class)
@Preview(showSystemUi = true)
@Composable
fun makeStaggeredGrids(){

    val data = (1..20).map { 
        GridItems(height = Random.nextInt(100,200).dp,
        color = Color(Random.nextLong(0xFFFFFFFF)).copy(alpha = 1f))
    }
    val state = rememberLazyStaggeredGridState()

    LazyVerticalStaggeredGrid(columns = StaggeredGridCells.Fixed(2) , state = state,
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.spacedBy(2.dp),
        verticalArrangement = Arrangement.spacedBy(2.dp),
        content = {
        items(data.size){

            Box(
                Modifier
                    .padding(2.dp)
                    .fillMaxWidth()
                    .height(data[it].height)
                    .clip(RoundedCornerShape(10.dp))
                    .background(data[it].color),
            )
        }
    })
}