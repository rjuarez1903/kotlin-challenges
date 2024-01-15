package sortByDuration

import com.google.gson.Gson
import total.Product

/* Welcome Aboard ITMaster Airlines

Our ITMaster Airlines in-flight entertainment package
includes a variety of podcasts. We need to add a feature that suggests
podcasts to our patrons based on whether a flight is short or long.

Your sort function should take two arguments: the podcast data and
flight length. If the flight is 60 minutes or less, sort the podcast list
from shortest to longest. If it's anything else, sort from longest
to shortest.

Your function shouldn't return anything. Instead log a numbered list
of the title and duration of
each podcast to the console, like this:

1. Crime Fan, 150 minutes
2. Mythical Creatures, 99 minutes
3. Crime Crime Crime, 70 minutes
4. Coding Corner, 55 minutes
5. ITMaster Podcast, 50 minutes
6. Something about Witches, 35 minutes

*/

data class Podcast(
    val title: String,
    val duration: Int,
    val tags: List<String>,
    val hosts: List<String>,
    val genre: String,
    val rating: Int,
    val paid: Boolean
)

fun main() {
    val gson = Gson()
    val json = Podcast::class.java.getResourceAsStream("data.json")?.reader()?.readText()
    val podcasts = gson.fromJson(json, Array<Podcast>::class.java).toList()

    sortByDuration(podcasts, 60)
}

// Solution
fun sortByDuration(data: List<Podcast>, flightLength: Int) {
    val sortedPodcasts = if (flightLength <= 60) {
        data.sortedBy { it.duration }
    } else {
        data.sortedByDescending { it.duration }
    }

    sortedPodcasts.forEachIndexed { index, podcast ->
        println("${index + 1}. ${podcast.title}, ${podcast.duration} minutes")
    }
}