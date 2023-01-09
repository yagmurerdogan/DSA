/*
Array can store data of specified type
Elements of an array are located in a contiguous
Each element of an array has a unique index
The size of an array is predefined and can not be modified

Types of arrays
-> one dimensional (access element directly one index arr[4] )
-> multi dimensional ( ex. Two dimensional -> row - column |  arr[0,4] )

 */

//Without array
fun avg() {
    val console = Scanner(System.`in`)
    println("How many day's temperatures?")
    val numDays = console.nextInt()
    var sum = 0
    for (i in 1..numDays) {
        println("Day$i's high temp: ")
        val next = console.nextInt()
        sum += next
    }
    val average = (sum / numDays).toDouble()
    println()
    println("Average temp = $average")
}

//With array
