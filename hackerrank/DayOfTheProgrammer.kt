fun dayOfProgrammer(year: Int): String {
    var result = ""

    if (year >= 1700 && year <= 1917) {
        result = if (year%4 == 0) "12.09.$year" else "13.09.$year"
    } else if (year == 1918) {
        result = "26.09.$year"
    } else {
        if (year%400 == 0) {
            result = "12.09.$year"
        } else if (year%4==0 && year%100 != 0) {
            result = "12.09.$year"
        } else {
            result = "13.09.$year"
        }
    }
    return result
}