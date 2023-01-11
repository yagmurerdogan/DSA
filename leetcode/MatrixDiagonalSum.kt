fun diagonalSum(mat: Array<IntArray>): Int {
    val n = mat.size
    val midPosition = n / 2 // the middle
    var sum = 0

    if (n % 2 != 0) { // get rid of the duplicate middle in odd length grids
        sum -= mat[midPosition][midPosition]
    }

    for (i in mat.indices) {
        sum += mat[i][i] // primary diagonal
    }
    for (j in mat.indices) {
        sum += mat[j][n - j - 1] // secondary diagonal
    }

    return sum // done
}