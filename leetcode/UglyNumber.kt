class Solution {
    fun isUgly(n: Int): Boolean {

        return when {
            n == 0 -> false
            n == 1 -> true
            n%2 == 0 -> isUgly(n/2)
            n%3 == 0 -> isUgly(n/3)
            n%5 == 0 -> isUgly(n/5)
            else -> false
        }

    }
}

class Solution {
    fun isUgly(n: Int): Boolean {
        if (n <= 0) {
            return false
        }

        var s = n

        for (factor in intArrayOf(2, 3, 5)) {
            s = keepDividingWhenDivisible(s, factor)
        }

        return s == 1
    }

    private fun keepDividingWhenDivisible(dividend: Int, divisor: Int): Int {
        var dividend = dividend
        while (dividend % divisor == 0) {
            dividend /= divisor
        }
        return dividend
    }
}