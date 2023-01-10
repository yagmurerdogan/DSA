//array elements sum -> n(n+1)/2
fun missingNumber(nums: IntArray): Int {
    var sum1 = 0
    var sum2 = 0
    for (i in nums) {
        sum1 += i
    }
    sum2 = nums.size * (nums.size + 1) / 2
    return sum2 - sum1
}