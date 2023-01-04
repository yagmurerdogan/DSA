class Solution {
    fun restoreString(s: String, indices: IntArray): String {
        val array = CharArray(s.length)
        indices.forEachIndexed { i, num -> array[num] = s[i] }
        return String(array)


        /*
                var outputString = CharArray(s.length)
                s.forEachIndexed { index, c ->
                outputString[indices[index]] = c
                }
                return String(outputString)
         */
        
    }
}