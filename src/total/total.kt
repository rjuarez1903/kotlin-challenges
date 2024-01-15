package total

import com.google.gson.Gson
import kotlin.math.pow

/*
Use reduce() to total the groceries.
Then find a method that will round the total to 2 decimal places.

Example output: 73.44
*/

data class Product(
    val item: String,
    val price: Double,
    val type: String,
    val onSale: Boolean
)

fun main() {
    val gson = Gson()
    val json = Product::class.java.getResourceAsStream("data.json")?.reader()?.readText()
    val shoppingCart = gson.fromJson(json, Array<Product>::class.java).toList()

    val totalPrice = total(shoppingCart)
    println(totalPrice)
}

// Solution
fun total(shoppingCart: List<Product>): Double {
    return shoppingCart.map { it.price }.reduce { acc, price ->
        acc + price
    }.roundTo(2)
}

// Extension function
fun Double.roundTo(decimalPlaces: Int): Double {
    val factor = 10.0.pow(decimalPlaces.toDouble())
    return Math.round(this * factor) / factor
}