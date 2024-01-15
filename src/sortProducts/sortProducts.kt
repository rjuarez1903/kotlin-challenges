package sortProducts

/* Holiday Gift Shopping
   You're shopping for holiday gifts on a tight budget and want to find the cheapest items first.
   You have a map of products with emojis as keys and their corresponding prices as values.
   Write a function that takes this map and returns a list of products sorted by price, from cheapest to most expensive.

   Example input (productsMap):
   {
       "🍭": 2.99,
       "🍫": 0.99,
       "🏡": 40000000.0,
       "🧁": 0.99,
       "📚": 0.99,
       "⏰": 13.99,
       "🍬": 0.89,
       "🥎": 3.99,
       "🎸": 13.99,
       "🎨": 23.99,
       "💕": 0.0
   }

   Example output (listByCheapest):
   [
       ("💕", 0.0),
       ("🍬", 0.89),
       ("🍫", 0.99),
       ("🧁", 0.99),
       ("📚", 0.99),
       ("⏰", 13.99),
       ("🥎", 3.99),
       ("🎸", 13.99),
       ("🎨", 23.99),
       ("🍭", 2.99),
       ("🏡", 40000000.0)
   ]

   Your function should return a list of product-emoji and price pairs, sorted by price in ascending order.
   Each pair should be printed in the format: "emoji,price" using a loop.
*/


val productsMap = mapOf(
    "🍭" to 2.99,
    "🍫" to 0.99,
    "🏡" to 40000000.0,
    "🧁" to 0.99,
    "📚" to 0.99,
    "⏰" to 13.99,
    "🍬" to 0.89,
    "🥎" to 3.99,
    "🎸" to 13.99,
    "🎨" to 23.99,
    "💕" to 0.0
)

fun main() {
    val listByCheapest = sortProducts(productsMap)
    listByCheapest.forEach { (product, price) ->
        println("$product,$price")
    }
}

// Solution
fun sortProducts(data: Map<String, Double>): List<Pair<String, Double>> {
    return data.toList().sortedBy { it.second }
}