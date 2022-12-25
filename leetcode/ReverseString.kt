class Solution {
    fun reverseString(chars: CharArray): Unit {

        var i = 0
        var j = chars.size - 1
        while (i < j) {
            val temp = chars[i]
            chars[i++] = chars[j]
            chars[j--] = temp
        }
    }
}