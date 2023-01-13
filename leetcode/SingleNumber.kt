fun singleNumber(nums: IntArray): Int {
    val set = HashSet<Int>()
    for (i in nums.indices) {
        for (j in i+1 until nums.size) {
            if (nums[i] == nums[j]) {
                set.add(nums[i])
            }
        }
        if(!set.contains(nums[i])){
            return nums[i]
        }
    }
    return nums[0]
}