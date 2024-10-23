package pt.iade.ei.nextseason

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import pt.iade.ei.nextseason.models.ContentItem
import pt.iade.ei.nextseason.models.Review
import pt.iade.ei.nextseason.ui.components.RatedContentListItem
import pt.iade.ei.nextseason.ui.theme.NextSeasonTheme
import java.net.URI
import java.time.LocalDateTime
import java.time.ZoneOffset

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainView()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainView() {
    NextSeasonTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text("Next Season")
                    },
                    colors = topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.primary,
                    )
                )
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier.padding(innerPadding)
            ) {
                Text(
                    text = "Featured Items",
                    fontSize = 27.sp
                )
                // Muito importante! So facam listas assim:
                LazyColumn {
                    items(ContentItemListExample()) { item ->
                        RatedContentListItem(
                            item = item
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainViewPreview() {
    MainView()
}

fun ContentItemListExample(): List<ContentItem> {
    return listOf(
        ContentItem(
            id = 123,
            title = "Everybody Hates Chris",
            description = "Everybody in Broklyn for some reason hates Chris.",
            cover = URI.create("http://static.tvmaze.com/uploads/images/original_untouched/5/14969.jpg"),
            releaseDate = LocalDateTime.ofEpochSecond(
                1002019236,
                0,
                ZoneOffset.UTC),
            duration = 12345678,
            genre = "Comedy",
            votes = 1234,
            reviews = listOf(
                Review(
                    id = 97,
                    user = "chris.julius.rock",
                    comment = "Best series ever! Explains my life.",
                    publishedDate = LocalDateTime.ofEpochSecond(
                        1002029236,
                        0,
                        ZoneOffset.UTC),
                    rating = 5
                ),
                Review(
                    id = 100,
                    user = "chris.hater",
                    comment = "I hate Chris!",
                    publishedDate = LocalDateTime.ofEpochSecond(
                        1002029336,
                        0,
                        ZoneOffset.UTC),
                    rating = 1
                )
            )
        ),
        ContentItem(
            id = 234,
            title = "My Wife and Kids",
            description = "My Wife and Kids is an American television sitcom that aired on ABC " +
            "from March 28, 2001 to May 17, 2005 with a total of 123 half-hour episodes spanning " +
                    "five seasons. The series, produced by Touchstone Television in association " +
                    "with Wayans Bros. Entertainment and Impact Zone, stars Damon Wayans (also " +
                    "creator alongside veteran television writer/producer Don Reo) as Michael " +
                    "Kyle, the patriarch of a black family in Stamford, Connecticut.",
            cover = URI.create("https://image.tmdb.org/t/p/original/eyQsN8bU27fdIs2D66gFmcIo0dM.jpg"),
            releaseDate = LocalDateTime.ofEpochSecond(
                1002019236,
                0,
                ZoneOffset.UTC),
            duration = 12345678,
            genre = "Comedy",
            votes = 432,
            reviews = listOf()
        )
    )
}