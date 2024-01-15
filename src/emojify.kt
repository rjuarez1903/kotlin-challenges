/*  Emojify!

Popular services like Slack and Github allow for emoji shortscodes, meaning
they will detect when a word in a sentence begins and ends with a colon (:)
and automatically replace that word with an emoji.

These shortcodes allow users to add an emoji to their messages by typing a
code rather than searching for an emoji from a list.

For example, typing :smile: will replace that text with 😊

*/

val emojis = mapOf(
    "smile" to "😊",
    "angry" to "😠",
    "party" to "🎉",
    "heart" to "💜",
    "cat" to "🐱",
    "dog" to "🐕"
)

fun main() {
    println(emojifyWord(":heart:"))
    println(emojifyWord(":flower:"))
    println(emojifyWord("elephant"))

    println(emojifyPhrase("I :heart: my :cat:"))
    println(emojifyPhrase("I :heart: my :elephant:"))
}

/* 1. Write a function that checks if a lowercase word starts and
ends with a colon. If it does, remove the colons and
look up the word in the emoji object. If the word is in the
emojis object, return the corresponding emoji.
If it isn't, return the original word.

Example input: ":party:"
Example output: 🎉

Example input: ":flower:"
Example output: "flower"

Example input: "elephant"
Example output: "elephant"
*/

fun emojifyWord(word: String): String {
    var wordOut = word
    if (word.startsWith(":") && word.endsWith(":")) {
        val wordWithNoColons = word.substring(1, word.length - 1)
        wordOut = emojis[word.substring(1, word.length - 1)] ?: wordWithNoColons
    }
    return wordOut
}

/* 2. Write a function to find any emoji shortcodes in a phrase.
Your function should map over each word in the phrase, emojify any word
that begins and ends with a colon, then return the emojified phrase.
Feel free to use your emojify function from the previous exercise!

Example input: "I :heart: my :cat:"
Example output: "I 💜 my 🐱"

Example input: "I :heart: my elephant"
Example output: "I 💜 my elephant"
*/

fun emojifyPhrase(phrase: String): String {
    val stringList = phrase.split(" ")
    val phraseOut = stringList.map {
        emojifyWord(it) + ""
    }
    return phraseOut.joinToString(" ")
}