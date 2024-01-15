package totalSavory

import com.google.gson.Gson

/*
Use reduce() and only reduce() to calculate and return
the total cost of only the savory
items in the shopping cart.

Expected output: 9.97
*/

data class Product(
    val item: String,
    val price: Double,
    val type: String,
    val onSale: Boolean
)

fun main() {
    val gson = Gson()
    val json = total.Product::class.java.getResourceAsStream("data.json")?.reader()?.readText()
    val shoppingCart = gson.fromJson(json, Array<Product>::class.java).toList()

    println(totalSavory(shoppingCart));
}

// Solution
fun totalSavory(shoppingCart: List<Product>): Double {
    return shoppingCart
        .filter { it.type == "savory" }
        .map { it.price }
        .reduce { acc, price -> acc + price }
}