package pt.iade.ei.nextseason.ui.components

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pt.iade.ei.nextseason.DetailActivity
import pt.iade.ei.nextseason.R
import pt.iade.ei.nextseason.models.ContentItem
import pt.iade.ei.nextseason.models.Review
import java.net.URI
import java.time.LocalDateTime
import java.time.ZoneOffset
import kotlin.math.roundToInt

@Composable
fun RatedContentListItem(
    item: ContentItem
) {
    val context = LocalContext.current
    Card(
        modifier = Modifier.padding(
            vertical = 10.dp,
            horizontal = 5.dp
        ),
        onClick = {
            Toast.makeText(context, "Hello ${item.title}!", Toast.LENGTH_SHORT).show()
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("item", item)
            context.startActivity(intent)
        }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(10.dp)
        ) {
            ContentVote(item)

            Image(
                painter = painterResource(R.drawable.poster_placeholder),
                contentDescription = "Poster Image",
                modifier = Modifier
                    .height(80.dp)
                    .padding(start = 10.dp)
            )

            Column(
                modifier = Modifier.padding(
                    start = 10.dp
                )
            ) {
                Text(
                    text = item.title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = item.description,
                    maxLines = 2,
                    minLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                ReviewStars(item)
            }
        }
    }
}

@Preview()
@Composable
fun RatedContentListItemPreview() {
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