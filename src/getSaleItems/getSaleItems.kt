package getSaleItems

import com.google.gson.Gson
import getFreePodcasts.Podcast

/*
   It's the day after Halloween 🎃 and all the candy is on sale!
   
   To buy up all the candy, use map() and filter() to put all the
   candy into a `shoppingCart` array. 
   
   The new array should contain only the item and the price, like
   this: 
   
   Expected output: 
   [
       {item: "🍭", price: 2.99},
       {item: "🍫", price: 1.99}, 
       {item: "🍬", price: 0.89}
    ]
*/

data class Candy(
    val item: String,
    val type: String,
    val price: Double
)

fun main() {
    val gson = Gson()
    val json = Candy::class.java.getResourceAsStream("data.json")?.reader()?.readText()
    val candies = gson.fromJson(json, Array<Candy>::class.java).toList()

    println(getSaleItems(candies))
}

// Solution
fun getSaleItems(data: List<Candy>): List<Map<String, Any>> {
    return data.filter { it.type == "sweet" }.map { mapOf("item" to it.item, "price" to it.price) }
}