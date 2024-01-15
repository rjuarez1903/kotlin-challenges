/* Panic function 
Write a PANIC! function. The function should take in a sentence and return the same
sentence in all caps with an exclamation point (!) at the end. Use Kotlin's
built-in string methods.

If the string is a phrase or sentence, add a 😱 emoji in between each word. 

Example input: "Hello"
Example output: "HELLO!"

Example input: "I'm almost out of coffee"
Example output: "I'M 😱 ALMOST 😱 OUT 😱 OF 😱 COFFEE!"
*/


// Test your function

fun main() {
    println(panic("Hello"))
    println(panic("I'm almost out of coffee"))
    println(panic("winter is coming"))
}


// Solution
fun panic(sentence: String): String {
    val sentenceList = sentence.split(" ")
    return if (sentenceList.size > 2) {
        sentenceList.joinToString(separator = "\uD83D\uDE31").uppercase() + "!"

    } else {
        "$sentence!"
    }
}