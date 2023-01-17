fun subtractProductAndSum(n: Int): Int {
    var sumResult = 0
    var timesResult = 1
    var n = n
    while(n > 0) {
        sumResult += n % 10
        timesResult *= n % 10
        n /= 10
    }
    return timesResult - sumResult
}