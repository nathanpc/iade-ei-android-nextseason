package pt.iade.ei.nextseason.controllers

import android.content.res.Resources
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.extensions.jsonBody
import com.github.kittinunf.fuel.json.responseJson
import pt.iade.ei.nextseason.R
import pt.iade.ei.nextseason.models.ContentItem
import pt.iade.ei.nextseason.models.Review
import java.net.URI
import java.time.LocalDateTime
import java.time.ZoneOffset

class ContentItemController {
    val serverPath = Resources.getSystem().getString(R.string.server_path)

    fun List(
        onSuccess: (List<ContentItem>) -> Unit,
        onFailure: () -> Unit = { }
    ) {
        val contentItemList: ArrayList<ContentItem> = ArrayList()

        Fuel.get("$serverPath/movies/list")
            .responseJson { request, response, result ->
                println(request)
                println(response)
                val (bytes, error) = result
                if (bytes != null) {
                    // Buscar o array com ContentItems e contruir o seu array de objetos.
                    // TODO: foreach elemento do array retornado pelo backend:
                    // Exemplo apresentado com constantes, porem devera utilizar os dados vindos do
                    // JSON retornado pelo servidor.
                    contentItemList.add(ContentItem(
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
                    ))
                } else {
                    // Fazer algo aqui quando as coisas correrem mal e nao funcionarem.
                    onFailure()
                }

                onSuccess(contentItemList)
            }
    }

    fun GetByID(
        id: Int,
        onSuccess: (ContentItem) -> Unit,
        onFailure: () -> Unit = { }
    ) {
        Fuel.get("$serverPath/movie?id=$id")
        // TODO: Fazer todo o requestJson aqui.
    }

    fun SubmitReview(
        movieId: Int,
        review: Review,
        onSuccess: (ContentItem) -> Unit,
        onFailure: () -> Unit = { }
    ) {
        Fuel.post("$serverPath/review/post?movie_id=$movieId")
            .jsonBody("{ \"foo\" : \"bar\" }")  // TODO: enviar aqui Review como um JSON. (olhem para uma biblioteca chamada GSON)
            // TODO: Fazer todo o requestJson aqui.
    }
}