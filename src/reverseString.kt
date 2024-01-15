/* We Come in Peace!  
We've received what (we assume) is a message of peace and brotherhood from 
an alien planet. They almost got it right, but the messages are 
backward. Write functions to reverse the backward messages, so we can
read what they have to say! 
*/

const val title = ":htraE no od ot ffutS";
val messages = listOf(
    "maerc eci yrT",
    "rewoT leffiE tisiV",
    "noom eht ot snamuh etacoleR",
    "egrahc ni stac tuP",
)

fun main() {
    println(reverseStringWithWhileLoop(title));
    println(reverseStringsInArray(messages));
}

/* Step 1: Reverse a string
Write a function that takes in a string and returns the reverse 
of that string. An interviewer may want to check if you know your
string methods, or may want to know if you can reverse a string manually. 
Practice both ways! 

Example input: !htrae ot emocleW
Example output: Welcome to earth!
*/

// Solution 1
fun reverseString(sentence: String): String {
    val reversedSentence = sentence.reversed()
    return reversedSentence;
}

// Solution 2
fun reverseStringWithWhileLoop(sentence: String): String {
    var reverseString = ""
    var index = sentence.length - 1
    while (index > - 1) {
        reverseString += sentence[index]
        index -= 1
    }
    return reverseString
}

/*
Step 2: Now we'll reverse all strings in an array. Write a function that takes in
an array of strings and returns a new array with all strings reversed.

You can use reuse your reverseString() function, use string methods, or 
reverse the strings manually. 
*/

fun reverseStringsInArray(stringList: List<String>): List<String> {
    val stringListReversed = stringList.map {
        reverseString(it)
    }
    return stringListReversed;
}