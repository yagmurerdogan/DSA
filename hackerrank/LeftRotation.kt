fun rotateLeft(d: Int, arr: Array<Int>): Array<Int> {
    val array = IntArray(arr.size)
    for (i in arr.indices) {
        array[i] = arr[(i + d) % arr.size]
    }
    return array.toTypedArray()
}