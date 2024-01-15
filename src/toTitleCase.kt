/* toTitleCase
Write a function that will capitalize every word in a sentence.

Example Input: "everything, everywhere, all at once"
Example Output: "Everything, Everywhere, All At Once"
*/

/*
First, write a function that takes in one word and
capitalizes the first letter of that word.

Example Input: "kotlin"
Example Output: "Kotlin"

Hint: Trying using slice() and .upperCase()
*/

fun capitalizeWord(word: String): String {
    return word.first().uppercase() + word.slice(1..word.indices.last)
}

/*
Now write a function that capitalizes every word in a sentence.
How can you reuse the function you just wrote?
*/


// Test your functions

fun main() {
    println(capitalizeWord("pumpkin"))
    println(toTitleCase("pumpkin pranced purposefully across the pond"))
}


// Solution
fun toTitleCase(sentence: String): String {
    val sentenceList = sentence.split(" ")
    val sentenceOut = mutableListOf(capitalizeWord(sentenceList[0]))

    for (i in 1..<sentenceList.size) {
        sentenceOut.add(capitalizeWord(sentenceList[i]))
    }

    return sentenceOut.joinToString(separator = " ")
}