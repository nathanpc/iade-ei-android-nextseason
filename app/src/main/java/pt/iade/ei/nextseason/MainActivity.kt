package pt.iade.ei.nextseason

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pt.iade.ei.nextseason.ui.components.RatedContentListItem
import pt.iade.ei.nextseason.ui.theme.NextSeasonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NextSeasonTheme {
                RatedContentListItem(
                    title = "Everybody Hates Chris",
                    description = "Everybody in Broklyn for some reason hates Chris.",
                    rating = 4.6f,
                    numReviews = 130234
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
                title = "Everybody Hates Chris",
                description = "Everybody in Broklyn for some reason hates Chris.",
                rating = 4.6f,
                numReviews = 130234
            )

            RatedContentListItem(
                title = "Everybody Hates Chris",
                description = "Everybody in Broklyn for some reason hates Chris.",
                rating = 4.6f,
                numReviews = 130234
            )

            RatedContentListItem(
                title = "Everybody Hates Chris",
                description = "Everybody in Broklyn for some reason hates Chris.",
                rating = 4.6f,
                numReviews = 130234
            )
        }
    }
}