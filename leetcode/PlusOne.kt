fun plusOne(digits: IntArray): IntArray {
    for(i in digits.size - 1 downTo 0) {
        digits[i]+=1
        if(digits[i]<=9) return digits
        digits[i]=0
    }

    var arr = IntArray(digits.size +1)
    arr[0] = 1
    return arr
}