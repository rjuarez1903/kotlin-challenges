/*
Max from ITMaster wants to know how many new students have attended
ITMaster's weekly event this year.

He has an array of first-time attendees for each month of the year.
Help him find the total number of attendees! Your function should
take in an array and return a number representing the total number
of new attendees.

Example input: [1,2,3]
Example output: 6
 */

val studentCount = listOf(50, 53, 61, 67, 60, 70, 78, 80, 80, 81, 90, 110)

fun main() {
    println(sumArray(studentCount));
    println(sumArrayNoReduce(studentCount))
}

// Solution 1
fun sumArray(list: List<Int>): Int {
    return list.reduce { acc, num ->
        acc + num
    }
}

// Solution 2
fun sumArrayNoReduce(list: List<Int>): Int {
    var sum = 0
    for (number in list) {
        sum += number
    }
    return sum
}