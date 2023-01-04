class Solution {
    fun smallerNumbersThanCurrent(nums: IntArray): IntArray {

        val result = IntArray(nums.size)

        nums.forEachIndexed{i, num ->

            var count = 0

            for(j in nums.indices) {
                if(i!=j && num > nums[j]) count++
            }
            result[i] = count
        }
        return result

        /*
         return nums.map { value -> 
        nums.filter { num -> num < value}.size
        }.toIntArray()
         */

    }
}