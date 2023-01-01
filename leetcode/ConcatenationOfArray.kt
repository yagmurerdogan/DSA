class Solution {
    fun getConcatenation(nums: IntArray): IntArray = Array<Int>(nums.size.times(2)){ i ->
        nums[i % nums.size]
    }.toIntArray()
}