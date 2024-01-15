/*

Anagrams are groups of words that can be spelled with the same letters.
For example, the letters in "pea" can be rearranged to spell "ape", and
the letters in "allergy" can be rearranged to spell "gallery."

Write a function to check if two strings of lowercase letters are anagrams.
Return true if the word is an anagram. Return false if it isn't.

Example input: "allergy", "gallery"
Example output: true

Example input: "rainbow", "crossbow"
Example output: false

*/

fun main() {
    println(isAnagram("allergy", "gallery"));
    println(isAnagram("treasure", "measure"));
}

// Solution
fun isAnagram(str1: String, str2: String): Boolean {
    if (str1.length != str2.length) {
        return false
    }
    return str1.toList().sorted() == str2.toList().sorted()
}

