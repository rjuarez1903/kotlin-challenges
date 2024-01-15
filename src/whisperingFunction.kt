/* Whispering function 
Write a function `whisper` that takes in a sentence 
and returns a new sentence in all lowercase letters with
"shh..." at the beginning. 

The function should also remove an exclamation point
at the end of the sentence, if there is one. 

Example 
input: "The KITTENS are SLEEPING!"
output: "shh... the kittens are sleeping"

Hint: endsWith and slice
*/

fun main() {
    println(whisper("PLEASE STOP SHOUTING."))
    println(whisper("MA'AM, this is a Wendy's!"))
}

// Solution
fun whisper(sentence: String): String {
    val prefix = "shh.."
    return if (sentence.endsWith("!")) {
        "$prefix ${sentence.slice(0..<sentence.indices.last).lowercase()}"
    } else {
        "$prefix ${sentence.lowercase()}"
    }
}