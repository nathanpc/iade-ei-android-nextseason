package pt.iade.ei.nextseason.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.roundToInt

@Composable
fun RatedContentListItem(
    title: String,
    description: String,
    rating: Float,
    numReviews: Int
) {
    Column {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
        Text(
            text = description
        )

        Row {
            Text("${rating.roundToInt()} stars")
            Text(
                text = "$numReviews reviews",
                modifier = Modifier.padding(
                    start = 15.dp
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RatedContentListItemPreview() {
    RatedContentListItem(
        title = "Everybody Hates Chris",
        description = "Everybody in Broklyn for some reason hates Chris.",
        rating = 4.6f,
        numReviews = 130234
    )
}