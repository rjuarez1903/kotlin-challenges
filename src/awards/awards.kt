package awards

import com.google.gson.Gson

/* Night at the Scrimbies

It's time for the Scrimbies, a prestigious award show for podcast hosts.
We need to assemble a list of podcast hosts, so we can start handing out awards.

Write a fun that takes in the podcast data and
returns a flat array of podcast hosts. There are quite a few ways to approach
this, but try solving the problem using reduce().

Once you have a flat array of hosts, write a second fun to randomly assign each host a prize
from the awards array.

Example output: ["🏆 Alex Booker", "⭐ Bob Smith", "💎 Camilla Lambert" ...]

*/

val awards = listOf("🏆", "⭐", "💎", "🥇", "👑")

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

    println(getHosts(podcasts));
    println(assignAwards(podcasts));
}

// Solution
fun getHosts(data: List<Podcast>): List<String> {
    val hosts = data.flatMap { it.hosts }
    return hosts.distinct()
}

fun assignAwards(data: List<Podcast>): List<String> {
    val hosts = getHosts(data).shuffled()

    val awardHosts = mutableListOf<String>()

    for ((index, host) in hosts.withIndex()) {
        val award = awards[index % awards.size]
        val awardString = "$award $host"
        awardHosts.add(awardString)
    }

    return awardHosts
}