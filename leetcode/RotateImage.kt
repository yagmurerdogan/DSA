fun rotate(matrix: Array<IntArray>): Unit {
    if (matrix.isEmpty() || matrix.size != matrix[0].size) return
    val n = matrix.size
    for (layer in 0 until n / 2) {
        val last = n - 1 - layer
        for (i in layer until last) {
            val offset = i - layer
            val top = matrix[layer][i]
            matrix[layer][i] = matrix[last - offset][layer]
            matrix[last - offset][layer] = matrix[last][last - offset]
            matrix[last][last - offset] = matrix[i][last]
            matrix[i][last] = top
        }
    }
}