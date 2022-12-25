fun plusMinus(arr: Array<Int>): Unit {
    var positives = 0
    var negatives = 0
    var zeros = 0
    val n = arr.size.toDouble()

    for(element in arr) {
        if(element < 0) negatives+=1
        if(element > 0) positives+=1
        if(element == 0) zeros+=1
    }

    println(String.format("%.6f", positives/n))
    println(String.format("%.6f", negatives/n))
    println(String.format("%.6f", zeros/n))
}