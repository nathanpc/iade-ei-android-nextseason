package pt.iade.ei.nextseason.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
fun ReviewStars(
    item: ContentItem
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (i in 1..5) {
            Image(
                painter = painterResource(
                    if (i <= item.reviewsAverage().toInt())
                        R.drawable.star_filled
                    else
                        R.drawable.star
                ),
                contentDescription = "${item.reviewsAverage()} stars"
            )
        }

        Text(
            text = "${item.reviews.size} reviews",
            modifier = Modifier.padding(
                start = 15.dp
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ReviewStarsPreview() {
    ReviewStars(
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