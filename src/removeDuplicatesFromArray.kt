/* Chef Mario's Recipe Book
Chef Mario was in the middle of writing his cookbook masterpiece
when he spilled coffee on his keyboard! Now all his recipes have repeat
ingredients.

Help save Chef Mario's cookbook by writing a function that takes in an array
and returns a new array with all the duplicates removed.

Example input: ["🌈 rainbow", "🦄 unicorn", "🍭 lollipops", "🦄 unicorn", "🍭 lollipops"];
Example output: ["🌈 rainbow", "🦄 unicorn", "🍭 lollipops"];
*/

val eggScrambleRecipe = arrayOf(
    "🥓 bacon",
    "🥓 bacon",
    "🍳 eggs",
    "🫑 green peppers",
    "🧀 cheese",
    "🌶️ hot sauce",
    "🥓 bacon",
    "🥦 broccoli",
    "🧀 cheese",
    "🥦 broccoli",
    "🌶️ hot sauce"
)

fun main() {
    val arrayWithNoDuplicates = removeDuplicatesFromArray(eggScrambleRecipe)
    arrayWithNoDuplicates.forEach { println(it) }
}

// Solution 1
fun removeDuplicatesFromArrayWithSet(array: Array<String>): Array<String> {
    return array.toSet().toTypedArray()
}

// Solution 2
fun removeDuplicatesFromArray(array: Array<String>): Array<String> {
    val uniqueElements = mutableListOf<String>()

    for (element in array) {
        if (!uniqueElements.contains(element)) {
            uniqueElements.add(element)
        }
    }

    return uniqueElements.toTypedArray()
}