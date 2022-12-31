fun breakingRecords(scores: Array<Int>): Array<Int> {
    var min = scores[0]
    var minCount = 0
    var max = scores[0]
    var maxCount = 0

    for(score in scores) {
        if(score < min ) {
            min = score
            minCount++
        }
        if(score > max) {
            max = score
            maxCount++
        }
    }

    return arrayOf(maxCount,minCount)
}