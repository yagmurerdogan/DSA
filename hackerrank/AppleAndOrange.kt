fun countApplesAndOranges(s: Int, t: Int, a: Int, b: Int, apples: Array<Int>, oranges: Array<Int>): Unit {
    println(apples.count{ a + it in s..t})
    println(oranges.count{ b + it in s..t})
}