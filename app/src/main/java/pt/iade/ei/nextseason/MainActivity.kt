package pt.iade.ei.nextseason

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
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
            NextSeasonTheme {
                RatedContentListItem(
                    item = ContentItem(
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
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainViewPreview() {
    NextSeasonTheme {
        Column {
            RatedContentListItem(
                item = ContentItem(
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
                )
            )
        }
    }
}