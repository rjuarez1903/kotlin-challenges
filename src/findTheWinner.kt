/* Pizza Night?
It's the weekend and you and your friends can't agree on
what to order for dinner, so you put it to a vote.

Write a function to find the food with the highest number of votes.

Your function should take in a food object and find the food
with the most votes. It should log the winner, along with
how many votes it received.

Example input: {"🐈 cats": 19, "🐕 dogs": 17}
Example output: The winner is 🐈 cats with 19 votes!
*/

val gameNightFood = mapOf(
    "🍕 pizza"  to 3,
    "🌮 tacos"  to 10,
    "🥗 salads" to 7,
    "🍝 pasta"  to 5
)

fun main() {
    println(findTheWinner(gameNightFood));
}


// Solution
fun findTheWinner(obj: Map<String, Int>): String {
    var winner = ""
    var maxVotes = 0
    for ((food, votes) in gameNightFood) {
        if (votes > maxVotes) {
            maxVotes = votes
            winner = food
        }
    }
    return "The winner is $winner with $maxVotes votes!"
}

