//shorter version
class Solution {
    fun buildArray(nums: IntArray): IntArray = IntArray(nums.size).apply {
        for (i in nums.indices) {
            this[i] = nums[nums[i]]
        }
    }
}

/*

class Solution {
    fun buildArray(nums: IntArray): IntArray {
        val array = IntArray(nums.size)
        for (i in nums.indices) {
            array[i] = nums[nums[i]]
        }
        return array
    }
}
 */