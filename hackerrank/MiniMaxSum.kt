fun miniMaxSum(arr: Array<Int>): Unit {
    val min = arr.min()!!
    val max = arr.max()!!
    val sum = arr.map { it.toLong() }.sum()

    println("${sum-max} ${sum-min}")

}