package com.sri.composeworks

import androidx.annotation.DrawableRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.sri.composeworks.R.*

@OptIn(ExperimentalFoundationApi::class)
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
            InterestsSection(Color.Cyan)
            /* CourseSection(
                 // function require list of courses and
                 // one course contain 5 attributes
                 courses = listOf(
                     Course(
                         title = "geek of the year",
                         R.drawable.ic_headphone,
                         // these are colors.......
                         BlueViolet1,
                         BlueViolet2,
                         BlueViolet3
                     ),
                     // below are the copies of the objects
                     // and you can add as many as you want
                     Course(
                         title = "How does AI Works",
                         R.drawable.ic_videocam,
                         LightGreen1,
                         LightGreen2,
                         LightGreen3
                     ),
                     Course(
                         title = "Advance python Course",
                         R.drawable.ic_play,
                         skyblue1,
                         skyblue2,
                         skyblue3
                     ),
                     Course(
                         title = "Advance Java Course",
                         R.drawable.ic_headphone,
                         Beige1,
                         Beige2,
                         Beige3
                     ),
                     Course(
                         title = "prepare for aptitude test",
                         R.drawable.ic_play,
                         OrangeYellow1,
                         OrangeYellow2,
                         OrangeYellow3
                     ),
                     Course(
                         title = "How does AI Works",
                         R.drawable.ic_videocam,
                         LightGreen1,
                         LightGreen2,
                         LightGreen3
                     ),
                 )
             )*/
            // this is the final one that is bottomMenu

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.BottomCenter
            ) {
                BottomMenu(
                    items = listOf(
                        // having 5 instances
                        BottomMenuContent("Home", drawable.ic_home),
                        BottomMenuContent("explore", drawable.ic_search),
                        BottomMenuContent("Sri", drawable.ic_moon),
                        BottomMenuContent("videos", drawable.ic_action_bank),
                        BottomMenuContent("Profile", drawable.ic_profile),
                    )
                )
            }
            
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
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
fun TopicsSection(topics: List<String>) {
    var selectedChipIndex by remember {
        mutableIntStateOf(0)
    }
    LazyRow() {
        items(topics.size) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(10.dp)
                    .clickable {
                        selectedChipIndex = it
                    }
                    .clip(RoundedCornerShape(15.dp))
                    .background(
                        if (selectedChipIndex == it) Color.Gray
                        else Color.LightGray
                    )
                    .padding(15.dp)
            ) {
                Text(text = topics[it], color = Color.Black)
            }
        }
    }
}

@Composable
fun InterestsSection(color: Color = Color.Blue) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color)
            .padding(horizontal = 15.dp, vertical = 20.dp)
            .fillMaxWidth()
    ) {
        Column {
            Text(text = "Coroutines", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Retrofit", style = MaterialTheme.typography.bodySmall)
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(Color.Green)
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_play),
                contentDescription = "Play",
                tint = Color.Black,
                modifier = Modifier.size(16.dp)
            )

        }
    }
}

data class Course(
    val title: String,
    @DrawableRes val iconId: Int,
    val lightColor: Color,
    val mediumColor: Color,
    val darkColor: Color
)

@ExperimentalFoundationApi
@Composable
// here we have just passed the list of courses
fun CourseSection(courses: List<Course>) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "courses",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(15.dp)
        )
        // we have used lazyVertically grid
        LazyVerticalGrid(
            columns = GridCells.Fixed(2), // it basically tells no. of cells in a row
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
            modifier = Modifier.fillMaxHeight()
        ) {
            items(courses.size) {
                // here we have to define how one of these item is look like
                // we will tell after defining item design
                // let me comment it for now and after
                // creating you just have to remove

                // CourseItem(course = courses[it])
            }
        }
    }
}


