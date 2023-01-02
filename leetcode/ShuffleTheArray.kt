class Solution {
    fun shuffle(nums: IntArray, n: Int): IntArray {
        var start = 0
        // we know that the size of the return should be
        var result = IntArray(nums.size)

        //we do not need to go through the whole loop only to the middle
        for (i in 0 until n){
            // first value in our return array is going to be our value in our iniatial array
            result[start] = nums[i]
            // our second value in our retuen array is going to be next value after middle point
            result[start+1] = nums[n+i]
            // moving our pointer two steps ahead and so and so on
            start+=2

        }
        return result
    }
}

class Solution {
    fun shuffle(nums: IntArray, n: Int): IntArray {
        val suffle = IntArray(2*n)
        for(i in 0..n-1) {
            suffle[2*i] = nums[i]
            suffle[2*i+1] = nums[n+i]
        }
        return suffle
    }
}