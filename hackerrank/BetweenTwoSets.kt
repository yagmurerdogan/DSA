fun getTotalX(a: Array<Int>, b: Array<Int>): Int {
    val start = a.max()!!
    val end = b.min()!!

    return (start..end).count { num ->
        a.all { num % it == 0 } && b.all { it % num == 0}

        /*
        num should be divisible by all elements in a AND
        all elements of b should be divisible by num
        */

    }
}