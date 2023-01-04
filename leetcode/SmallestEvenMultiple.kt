class Solution {
    fun smallestEvenMultiple(n: Int): Int {
        var arr = (n..2*n).filter{ number->
            (number % 2 == 0) && (number % n == 0)
        }

        return arr.min()!!

    }
}