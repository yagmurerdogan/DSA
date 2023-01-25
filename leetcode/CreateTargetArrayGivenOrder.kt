fun createTargetArray(nums: IntArray, index: IntArray): IntArray {
    val ans = mutableListOf<Int>()
    for (i in nums.indices) {
        ans.add(index[i], nums[i])
    }
    return ans.toIntArray()
}