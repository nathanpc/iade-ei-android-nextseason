package pt.iade.ei.nextseason.models

import java.net.URI
import java.time.LocalDateTime

data class ContentItem(
    var id: Int?,
    val title: String,
    val description: String,
    val cover: URI,
    var votes: Int = 0,
    val genre: String,
    val releaseDate: LocalDateTime,
    val duration: Int,
    val reviews: List<Review>
) {
    fun reviewsAverage(): Float {
        var sum = 0
        for (review in reviews) {
            sum += review.rating
        }

        return sum.toFloat() / reviews.size
    }
}
