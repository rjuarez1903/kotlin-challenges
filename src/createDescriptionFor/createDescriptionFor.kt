package createDescriptionFor

import com.google.gson.Gson

/* 🌴 Save the Weekend 🌴

Your best friend is a copywriter who writes product descriptions
for a living. You want to use your hacking skills to help them
automate their job so you both can spend the weekend on a
tropical island.

Use array methods and the existing podcast data to write a function that
can generate a description for each podcast.

Add the description as a new property on each podcast object, and return
a new podcast array where each podcast has a description.

Each description should look like this:
[
    {
        id: 1,
        title: "Scrimba Podcast",
        ...
        description: "Scrimba Podcast is a 50 minute education podcast hosted
        by Alex Booker."
    }
    ...
]

If the podcast has more than one host, you can display only the first host.

Stretch goal: Display all three hosts in the description, seperated with commas:

Example description: "Coding Corner is a 55 minute education podcast hosted by Treasure Porth, Guil Hernandez, and Tom Chant."
*/

data class Podcast(
    val title: String,
    val duration: Int,
    val tags: List<String>,
    val hosts: List<String>,
    val genre: String,
    val rating: Int,
    val paid: Boolean,
    val description: String = "",
)

fun main() {
    val gson = Gson()
    val json = Podcast::class.java.getResourceAsStream("data.json")?.reader()?.readText()
    val podcasts = gson.fromJson(json, Array<Podcast>::class.java).toList()

    val podcastsWithDescriptions = createDescriptionsFor(podcasts)
    podcastsWithDescriptions.forEach { println(it) }
}


// Solution
fun createDescriptionsFor(data: List<Podcast>): List<Podcast> {
    return data.map { podcast ->
        val firstHost = if (podcast.hosts.isNotEmpty()) podcast.hosts[0] else "Unknown Host"
        val description = "${podcast.title} is a ${podcast.duration} minute ${podcast.genre} podcast hosted by $firstHost."
        podcast.copy(description = description)
    }
}