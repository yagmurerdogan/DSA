class Solution {
    fun maximumWealth(accounts: Array<IntArray>): Int {
        var max = Integer.MIN_VALUE
        accounts.forEach { bankAmount ->
            if (bankAmount.sum() > max)
                max = bankAmount.sum()
        }
        return max
    }

    //fun maximumWealth(accounts: Array<IntArray>) = accounts.maxOf { it.sum() }
    //fun maximumWealth(accounts: Array<IntArray>) = accounts.map { it.sum() }.max()

}