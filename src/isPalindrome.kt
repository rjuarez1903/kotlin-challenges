/*
Palindromes are words that are the same forward or backward. For example,
the words "noon" and "kayak" are a palindromes.

Write a function to check if a lowercased string of letters is a palindrome.
If the word is palindrome, return true. If it isn't, return false.

Example input: "motorbike"
Example output: false

Example input: "rotator"
Example output: true
*/

// Test your function

fun main() {
    println(isPalindrome("abba"));
    println(isPalindrome("civic"));
    println(isPalindrome("octopus"));
    println(isPalindrome("pumpkins"));
    println(isPalindrome("madam"));
}

// Solution 1
fun isPalindrome(str: String): Boolean {
//    val reversedString = str.reversed()
    var reversedString = ""
    var index = str.length - 1
    while (index > -1) {
        reversedString += str[index]
        index -= 1
    }
    return str == reversedString
}

// Solution 2
fun isPalindromeWithWhile(str: String): Boolean {
    val reversedString = str.reversed()
    return str == reversedString
}