package com.example.samplecompose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.R

class SecondActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(), color = Color.White
            ) {
                CreateScreen()
            }
        }
    }

    @Preview(name = "Second", showSystemUi = true)
    @Composable
    private fun CreateScreen() {
        Column(
            horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.Top
        ) {
            Image(
                painter = painterResource(id = R.drawable.celeb),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(4f / 3f)
            )

            Spacer(modifier = Modifier.padding(10.dp))

            Text(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                text = "Compose is declarative and as such the only way to update it is by calling the same composable with new arguments. These arguments are representations of the UI state. Any time a state is updated a recomposition takes place. As a result, things like TextField don’t automatically update like they do in imperative XML based views." + " \n " + "              " + " A composable has to explicitly be told the new state in order for it to update accordingly.",
                color = Color.Black,
                fontWeight = FontWeight.Light,
                lineHeight = 20.sp
            )

            val textValue = remember { mutableStateOf("Hi") }
            TextField(
                value = textValue.value, onValueChange = {
                    textValue.value = it
                }, modifier = Modifier
                    .padding(all = 10.dp)
                    .fillMaxWidth()
            )

            val isDialogShow: MutableState<Boolean> = remember {
                mutableStateOf(false)
            }

            if (isDialogShow.value) {
                ShowAlert(text = "This alert dialog",
                    isShown = isDialogShow.value,
                    onDismiss = { isDialogShow.value = false })
            }

            Button(onClick = {
                isDialogShow.value = true
            }, modifier = Modifier
                .fillMaxWidth()
                .padding(all = 5.dp)) {
                Text(text = "Click to Show Dialog")
            }


        }
    }

    @Composable
    fun ShowAlert(
        text: String, isShown: Boolean, onDismiss: () -> Unit
    ) {
        AlertDialog(onDismissRequest = onDismiss, title = {
            Text(text = stringResource(id = R.string.app_name))
        }, text = {
            Text(text = text)
        }, confirmButton = {
            TextButton(onClick = onDismiss) {
                Text(text = "OK")
            }
        })
    }
}