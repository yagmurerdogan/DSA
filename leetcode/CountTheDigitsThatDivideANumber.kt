fun countDigits(num: Int): Int {
    var tmp = num
    var count = 0
    while (tmp > 0) {
        val value = tmp % 10
        if (value != 0 && num % value == 0) count++
        tmp /= 10
    }
    return count
}