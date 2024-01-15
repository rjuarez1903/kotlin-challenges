/* Totally Not Another FizzBuzz

Facebook CEO Mark Zuckerberg wants you to write a program to grant special bonuses to all his employees based on their employee ID numbers!

Facebook has 100 employees and their employee ID numbers range from 1 to 100. If the employee's ID number is:

Divisible by 3 - Vacation!
Divisible by 5 - $100,000 bonus!
Divisible by both 3 and 5 - JACKPOT! 1 Million and a Yacht!
Not divisible by 3 or 5 - :(

Write a program to loop through all the ID numbers and print their prize.
Your function's output should look something like this:

1 - :(
2 - :(
3 - Vacation!
4 - :(
5 - $100,000 bonus!

Hint: Remaind
 */

// Test your function

fun main() {
    awardBonuses()

}

// Solution
fun awardBonuses() {
    for (i in 1..100) {
        when {
            i % 15 == 0 -> println("$i - JACKPOT! 1 Million and a Yacht!")
            i % 5 == 0 -> println("$i - $100,000 bonus!")
            i % 3 == 0 -> println("$i - Vacation!")
            else -> println("$i - :(")
        }
    }
}