/* Alternating Caps 
 Write a function that takes in a string of letters
 and returns a sentence in which every other letter is capitalized.

Example input: "I'm so happy it's Monday"
Example output: "I'M So hApPy iT'S MoNdAy"
*/

fun main() {
    println(altCaps1("I'm so happy it's Monday"))
    println(altCaps2("When you visit Portland you have to go to VooDoo Donuts"))
}


// Solution 1
fun altCaps1(sentence: String): String {
    var sentenceOut = ""
    val sentenceList = sentence.split("")
    sentenceList.forEachIndexed { index, char ->
        sentenceOut += if (index % 2 != 0) char.uppercase() else char.lowercase()
    }
    return sentenceOut
}

// Solution 2
fun altCaps2(sentence: String): String {
    var capitalizeNext = true
    var sentenceOut = ""
    for (char in sentence) {
        sentenceOut += if (capitalizeNext) char.uppercase() else char.lowercase()
        capitalizeNext = !capitalizeNext
    }
    return sentenceOut
}