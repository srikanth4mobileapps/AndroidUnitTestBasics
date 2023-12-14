package com.sri.composeworks

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.sri.composeworks.R.*
import com.sri.composeworks.ui.theme.ButtonGreen
import com.sri.composeworks.ui.theme.DarkerButtonGreen

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        Column {
            GreetingSection()
            TopicsSection(topics = listOf("Compose", "Coroutines", "Flows", "Kotlin"))
        }
    }
}

@Composable
fun GreetingSection(name: String = "Android Developers") {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Column(verticalArrangement = Arrangement.Center) {
            Text(
                text = "Welcome $name",
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = "Welcome $name",
                style = MaterialTheme.typography.bodyMedium
            )
        }
        Icon(
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = "Search",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
fun TopicsSection( topics: List<String>){
    var selectedChipIndex by remember {
        mutableIntStateOf(0)
    }
    LazyRow(){
        items(topics.size){
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(10.dp)
                    .clickable {
                        selectedChipIndex =it
                    }
                    .clip(RoundedCornerShape(15.dp))
                    .background( if (selectedChipIndex == it) Color.Gray
                    else Color.LightGray
                    )
                    .padding(15.dp)
            ) {
                Text(text = topics[it], color = Color.Black)
            }
        }
    }
}