fun diagonalDifference(a: Array<Array<Int>>): Int {
    //1. Calculate d1
    //2. Calculate d2
    //3. Calculate and return |d1-d2|

    val n = a.size
    var d1 = 0
    var d2 = 0

    for(i in 0 until n){
        d1 += a[i][i]
        d2 += a[i][(n-i)-1]
    }

    return abs(d1-d2)

}
