fun minDeletionSize(strs: Array<String>): Int {
    val m = strs.size
    val n = strs[0].length
    var result = 0

    for (col in 0..n-1) {
        for (row in 1..m-1) {
            if (strs[row][col] < strs[row-1][col]) {
                result++
                break
            }
        }
    }

    return result
}