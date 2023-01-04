class Solution {
    fun kidsWithCandies(candies: IntArray, extraCandies: Int): List<Boolean> {

        var booleanList: MutableList<Boolean> = mutableListOf()

        candies.forEach{ candy ->
            if(candy + extraCandies >= candies.max()!!) booleanList.add(true) else booleanList.add(false)
        }
        return booleanList
    }
}