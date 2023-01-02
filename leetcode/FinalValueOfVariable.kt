class Solution {
    fun finalValueAfterOperations(operations: Array<String>): Int {
        var ans = 0

        for(operation in operations) {

            if(operation == "++X" || operation == "X++") ans++ else ans--

            }

        return ans
    }
}