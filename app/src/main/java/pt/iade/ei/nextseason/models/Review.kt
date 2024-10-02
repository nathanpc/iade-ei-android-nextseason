package pt.iade.ei.nextseason.models

import java.time.LocalDateTime

data class Review(
    var id: Int?,
    val user: String,
    val comment: String,
    val rating: Int,
    val publishedDate: LocalDateTime
)
