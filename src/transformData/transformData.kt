package transformData

import com.google.gson.Gson
import java.text.SimpleDateFormat
import java.util.*

/* Totally Private Data Farm

Good news, renown advertising firm Evil Corp. wants to purchase our
private user data!

We'd never do this in real life of course, but just for practice
let's pretend we're unethical web hackers and transform the data
in the way Evil Corp. has requested. They're quite particular and
just want an array of users with a full-name and human-readable
birthday.

Write a function that maps through the current data and returns
a new an array of objects with only two properties:
fullName and birthday. Each result in your
array should look like this when you're done:

{
    fullName: "Levent Busser",
    birthday: "Fri Aug 20 1971"
}

*/

fun main() {
    val gson = Gson()
    val json = User::class.java.getResourceAsStream("data.json")?.reader()?.readText()
    val userData = gson.fromJson(json, Array<User>::class.java).toList()

    val transformedData = transformData(userData)
    transformedData.forEach { println(it) }
}

// Solution
data class Name(val title: String, val first: String, val last: String)
data class Dob(val date: String, val age: Int)

data class User(val name: Name, val dob: Dob)

fun transformData(data: List<User>): List<Map<String, String>> {
    val transformedData = mutableListOf<Map<String, String>>()

    for (user in data) {
        val fullName = "${user.name.first} ${user.name.last}"
        val formattedBirthday = formatDate(user.dob.date)
        val transformedUser = mapOf("fullName" to fullName, "birthday" to formattedBirthday)
        transformedData.add(transformedUser)
    }

    return transformedData
}


fun formatDate(birthday: String): String {
    val inputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.US)
    val outputFormat = SimpleDateFormat("EEE MMM dd yyyy", Locale.US)
    val date = inputFormat.parse(birthday)
    return outputFormat.format(date)
}