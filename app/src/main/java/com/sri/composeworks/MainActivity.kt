package com.sri.composeworks

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sri.composeworks.ui.theme.ComposeWorkTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeWorkTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxWidth(1f),
                  color = Color.White
                ) {
                    Column (verticalArrangement = Arrangement.Center){
                        Box ( modifier = Modifier
                            .padding(24.dp)){
                            val painter = painterResource(id = R.drawable.baseline_agriculture_24)
                            val description = "This is image"
                            val title = "This is ducking image"
                            ImageCard(painter = painter, contentDescription = description, title = title )
                        }
                        Box ( modifier = Modifier
                            .padding(24.dp)){
                            val painter = painterResource(id = R.drawable.round_airport_shuttle_24)
                            val description = "This is image"
                            val title = "This is ducking image"
                            ImageCard(painter = painter, contentDescription = description, title = title )
                        }
                    }

                 //   Greeting("Android jetpack compose")

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val activity = LocalContext.current as Activity

    Column(
        modifier = Modifier
            .fillMaxSize(0f)
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

@Composable
fun ImageCard(
    painter: Painter,
    contentDescription: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ) {
        Box(modifier = modifier.height(200.dp)) {
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop
            )
            Box(modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color.Black),
                        startY = 300f
                    )
                ))
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
                contentAlignment = Alignment.BottomStart) {
                Text(text = title, style = TextStyle(color = Color.White, fontSize = 16.sp))
            }
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