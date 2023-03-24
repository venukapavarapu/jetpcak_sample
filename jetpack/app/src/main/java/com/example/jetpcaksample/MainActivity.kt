package com.example.jetpcaksample

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpcaksample.ui.theme.JetpcakSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpcakSampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    MakeList(list = data)
                }
            }
        }
    }

    companion object{
        val data = listOf(
            Sample("venu","gopal"),
            Sample(),
            Sample(),
            Sample(),
            Sample(),
            Sample(),
            Sample()
        )
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MakeList(list : List<Sample>) {
    val tvShows = remember { list }

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = MaterialTheme.colors.primary,
                title = { Text(stringResource(R.string.app_name)) }
            )
        }
    ) {
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp)
        ) {
            itemsIndexed(list){index , item ->
                Greeting(name = item)
//            if(index < list.lastIndex)
//             Divider(color = Color.LightGray, thickness = 1.dp)
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, device = Devices.DEFAULT)
@Composable
fun Greeting(@PreviewParameter(NameProvider::class) name: Sample) {
    val context = LocalContext.current
    Card(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .padding(all = 5.dp)
        .clickable {
            Toast
                .makeText(context, name.name, Toast.LENGTH_SHORT)
                .show()

            context.startActivity(Intent(context,SecondActivity::class.java))
        },
        elevation = 5.dp,
        shape = MaterialTheme.shapes.medium){

        Row(
            modifier = Modifier
                .padding(all = 8.dp)
                .fillMaxWidth(),
        ) {
            Image(
                painter = painterResource(id = R.drawable.celeb),
                contentDescription = "celebrity image",
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.padding(horizontal = 10.dp))
            Column {

                Text(
                    text = name.name,
                    modifier = Modifier.padding(all = 1.dp),

                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.padding(2.dp))

                Text(
                    text = name.surname,
                    textAlign = TextAlign.Start,
                    color = Color.Black,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(all = 1.dp)
                )
            }
        }

    }
}


@Preview(showBackground = true, showSystemUi = true, device = Devices.DEFAULT)
@Composable
fun DefaultPreview() {
    JetpcakSampleTheme {
        Greeting(Sample())
    }
}

data class Sample(var name: String = "Venu Gopal", var surname: String = "Kapavarapu")

class NameProvider: PreviewParameterProvider<String> {
    override val values: Sequence<String> = sequenceOf(
        "John",
        "Albert Einstein"
    )
}