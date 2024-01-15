package getUniqueTags

import com.google.gson.Gson

/* Find All Unique Tags

As a software dev at ScrimFlix, you're working on a feature
to let users browse TV shows by tag. The first step is to collect all
the tags from our data into a new array. Then we'll need
to filter out the duplicate tags.

Write a function that takes in the media data and returns
a flat array of unique tags.

Expected output:
["supernatural", "horror", "drama",
"fantasy", "reality", "home improvement", "comedy", "sci-fi", "adventure"]

*/

data class Show(
    val id: Int,
    val title: String,
    val duration: Int,
    val tags: List<String>
)


fun main() {
    val gson = Gson()
    val json = Show::class.java.getResourceAsStream("data.json")?.reader()?.readText()
    val mediaData = gson.fromJson(json, Array<Show>::class.java).toList()

    println(getUniqueTags(mediaData))
}


// Solution
fun getUniqueTags(mediaData: List<Show>): List<String> {
    val allTags = mediaData.flatMap { it.tags }
    return allTags.distinct()
}