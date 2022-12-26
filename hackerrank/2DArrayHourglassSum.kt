/*
row -
column |
 */

fun hourglassSum(arr: Array<Array<Int>>): Int {
    val rows = arr.size
    val columns = arr[0].size
    var maxHourglassSum = -63 //max min value 7 x (-9) = -63
    for (i in 0 until rows - 2) {
        for (j in 0 until columns - 2) {
            val currentHourglassSum = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] +
                    arr[i + 1][j + 1] + arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2]
            maxHourglassSum = max(maxHourglassSum, currentHourglassSum) // import kotlin.math.max return max value
        }
    }
    return maxHourglassSum

}