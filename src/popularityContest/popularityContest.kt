package popularityContest

/* Popularity Contest

Iggy the Influencer and Toby the Tiktoker are dying to know
who's more popular on social media.

Toby's TikToks get an average of 400 likes. On average, how many
likes do Iggy's Instagram posts get?

In data.json you'll find a list of Iggy's recent posts.
Use reduce() to write a function that returns the average number of likes.
To find the average, add up the total number of likes, then divide
by the total number of posts.
*/

val posts = listOf(
    mapOf("post" to "A lot of you have asked about my morning skin care routine...", "likes" to 348),
    mapOf("post" to "New Year, new me. #blessed", "likes" to 102),
    mapOf("post" to "Sunday by the pool 🌴 #vibes #mood #hotdoglegs", "likes" to 544),
    mapOf("post" to "Here are my top 5 #notsponsored unbiased dry shampoo recs...", "likes" to 745),
    mapOf(
        "post" to "Last day in Hawaii! The tans will fade but the memories will last forever #holidays #foreverhawaii #blessed #followme",
        "likes" to 412
    ),
    mapOf("post" to "Leg day #summerbody2022 #gymshark #beachworkout", "likes" to 275)
)

fun main() {
    println(calcAverageLikes(posts))
}

// Solution
fun calcAverageLikes(data: List<Map<String, Any>>): Double {
    val totalPosts = data.size
    val totalLikes = data.map {
        it["likes"] as Int
    }
        .reduce { acc, likes ->
            acc + likes
        }
    return totalLikes.toDouble() / totalPosts
}
