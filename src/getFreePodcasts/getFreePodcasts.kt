package getFreePodcasts

import com.google.gson.Gson

/* Find Free Podcasts

We have a list of podcasts and need the ability to filter by only
podcasts which are free.

Write a function that takes in the podcast data and returns a new
array of only those podcasts which are free.

Additionally, your new array should return only
objects containing only the podcast title, rating, and whether it is paid.

Expected output:
[
    {title: "ITMaster Podcast", rating: 10, paid: false},
    {title: "Something about Witches", rating: 8, paid: false},
    {title: "Coding Corner", rating: 9, paid: false}
]
*/

data class Podcast(
    val id: Int,
    val title: String,
    val duration: Int,
    val tags: List<String>,
    val hosts: List<String>,
    val rating: Int,
    val genre: String,
    val paid: Boolean
)

data class PodcastOutPut(
    val title: String,
    val rating: Int,
    val paid: Boolean
)

fun main() {
    val gson = Gson()
    val json = Podcast::class.java.getResourceAsStream("data.json")?.reader()?.readText()
    val podcasts = gson.fromJson(json, Array<Podcast>::class.java).toList()

    println(getFreePodcastsWithFilter(podcasts))
}

// Solution 1
fun getFreePodcastsWithFilter(data: List<Podcast>): List<PodcastOutPut> {
    return data.filter { !it.paid }
        .map { PodcastOutPut(it.title, it.rating, it.paid) }
}


// Solution 2
fun getFreePodcasts(data: List<Podcast>): List<PodcastOutPut> {
    val podcastOutputList = mutableListOf<PodcastOutPut>()
    for (podcast in data) {
        if (!podcast.paid) {
            val podcastOutput = PodcastOutPut(podcast.title, podcast.rating, podcast.paid)
            podcastOutputList.add(podcastOutput)
        }
    }
    return podcastOutputList
}