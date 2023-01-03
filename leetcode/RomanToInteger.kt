class Solution {
    fun romanToInt(s: String): Int {

        var count = 0

        s.forEachIndexed { index, element ->
            var nextChar = '_'
            if (index + 1 > s.length - 1) nextChar = '_' else nextChar = s[index + 1]
            when (element) {
                'I' -> if(nextChar == 'V' || nextChar == 'X') count -= 1 else count += 1
                'V' -> count += 5
                'X' -> if (nextChar == 'L' || nextChar == 'C') count -= 10 else count += 10
                'L' -> count += 50
                'C' -> if (nextChar == 'D' || nextChar == 'M') count -= 100 else count += 100
                'D' -> count += 500
                'M' -> count += 1000
                else -> count += 0
            }
        }
        return count

    }
}