class Solution {
    fun numJewelsInStones(jewels: String, stones: String): Int {

        var sum = 0
        jewels.forEach { jewel -> sum+= stones.count { it == jewel } }
        return sum

        /*
        Same solution

        var result = 0

        for (jewel in jewels) {
            result += stones.count { it == jewel }
        }

        return result
         */

    }
}