fun minimumSum(num: Int): Int {
    val dig = IntArray(4) { 0 }
    var cur = 0
    var num = num
    while (num > 0) {
        dig[cur++] = num % 10
        num /= 10
    }
    Arrays.sort(dig)
    return (dig[0] * 10 + dig[2]) + (dig[1] * 10 + dig[3])
}