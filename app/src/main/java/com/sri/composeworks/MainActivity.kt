package com.sri.composeworks

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sri.composeworks.ui.theme.ComposeWorkTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeWorkTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White//MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android jetpack compose")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val activity = LocalContext.current as Activity

    Column(modifier = Modifier
        .fillMaxSize(1f)
        .background(Color.Green)
        .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Let's start working together with $name!",
            modifier = Modifier
                .border(5.dp, Color.Yellow)
                .padding(20.dp)

        )
        Text(
            text = "Yes $name!",
            modifier = Modifier
                .padding(20.dp)
                .border(5.dp, Color.Black)
                .padding(20.dp)
                .clickable {
                    Toast
                        .makeText(activity, "Ok Fine", Toast.LENGTH_SHORT)
                        .show()
                }
        )
        Row {
            Text(
                text = "No00",
                modifier = Modifier
                    .padding(20.dp)
                    .border(5.dp, Color.Red)
                    .padding(20.dp)
                    .clickable {
                        Toast
                            .makeText(activity, "Duck you", Toast.LENGTH_SHORT)
                            .show()
                    }

            )
            Text(
                text = "No",
                modifier = Modifier
                    .padding(20.dp)
                    .border(5.dp, Color.Red)
                    .padding(20.dp)
                    .clickable {
                        Toast
                            .makeText(activity, "here also Duck you bro", Toast.LENGTH_SHORT)
                            .show()
                    }

            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeWorkTheme {
        Greeting("Android")
    }
}