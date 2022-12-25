fun timeConversion(s: String): String {
    //11:00:02AM
    var hour = s.take(2).toInt()
    val amPm = s.takeLast(2)
    val middle = s.substring(2..7)

    if(hour == 12 && amPm == "AM") {
        hour = 0
    }

    if(hour < 12 && amPm == "PM") {
        hour += 12
    }

    val hourString = hour.toString().padStart(2,'0')

    return hourString + middle
}