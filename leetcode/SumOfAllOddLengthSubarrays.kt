fun sumOddLengthSubarrays(arr: IntArray): Int {
    var left = 0
    var ans = 0
    while (left < arr.size) {
        var currentSum = arr[left]
        val right = left + 1
        ans += arr[left]
        for (index in right until arr.size) {
            currentSum += arr[index]
            if ((index - left) % 2 == 0) {
                ans += currentSum
            }
        }
        left++
    }
    return ans
}