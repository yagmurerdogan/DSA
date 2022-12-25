fun birthdayCakeCandles(candles: Array<Int>): Int {
    var max = candles[0]
    var countOfMax = 0
    for(candle in candles) {
        if(candle == max) {
            countOfMax += 1
        }
        if(candle > max){
            max = candle
            countOfMax = 1
        }
    }
    return countOfMax
}