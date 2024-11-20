package pt.iade.ei.nextseason.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pt.iade.ei.nextseason.R
import pt.iade.ei.nextseason.models.ContentItem
import pt.iade.ei.nextseason.models.Review
import java.net.URI
import java.time.LocalDateTime
import java.time.ZoneOffset

@Composable
fun ContentVote(
    item: ContentItem
) {
    // var votes = item.votes
    var votes by remember { mutableIntStateOf(item.votes) }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Up vote.
        Surface(
            onClick = {
                item.votes++
                votes++
                // ItemController.Update()
            },
            color = Color.Transparent
        ) {
            Image(
                painter = painterResource(R.drawable.keyboard_arrow_up),
                contentDescription = "Up vote"
            )
        }

        // Votes label.
        Text(
            text = votes.toString()
        )

        // Down vote.
        Surface(
            onClick = {
                item.votes--
                votes--
                // ItemController.Update()
            },
            color = Color.Transparent
        ) {
            Image(
                painter = painterResource(R.drawable.keyboard_arrow_down),
                contentDescription = "Down vote"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContentVotePreview() {
    ContentVote(
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