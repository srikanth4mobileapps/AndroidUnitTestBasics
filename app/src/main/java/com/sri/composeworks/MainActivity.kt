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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sri.composeworks.ui.theme.ComposeWorkTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val fontFamily = FontFamily(
                Font(R.font.caveat_regular, FontWeight.Normal),
                Font(R.font.caveat_bold, FontWeight.Bold),
                Font(R.font.caveat_medium, FontWeight.Medium),
                Font(R.font.caveat_semibold, FontWeight.SemiBold)
            )
            Box(
                modifier = Modifier
                    .fillMaxSize(1f)
                    .background(Color.White)
            ) {
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = Color.Black,
                                fontSize = 40.sp
                            )
                        ) {
                            append("Today i started with ")
                        }
                        withStyle(
                            style = SpanStyle(
                                color = Color.Red,
                                fontSize = 48.sp
                            )
                        ) {
                            append("Android Studio Hedgehog | 2023.1.1")
                        }
                        append("\n i'm working on Text styling, State, TextFields, Buttons, ")
                        withStyle(
                            style = SpanStyle(
                                color = Color.Green,
                                fontSize = 48.sp
                            )
                        ) {
                            append("SnackBar,Lists ")
                        }

                    },//"Today i started with Android Studio Hedgehog | 2023.1.1",
                    color = Color.Blue,
                    fontSize = 54.sp,
                    fontFamily = fontFamily,
                    textAlign = TextAlign.Center
                )

            }
        }
    }
}

