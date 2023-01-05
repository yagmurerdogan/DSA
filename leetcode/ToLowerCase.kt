class Solution {
    fun toLowerCase(s: String): String {

        val chs = s.toCharArray()

        for(idx in chs.indices){
            if(chs[idx] in 'A'..'Z'){
                chs[idx] = chs[idx] + ('a' - 'A')
            }
        }

        return String(chs)

        /*
          var lowerCase = ""
        for (char in s) {
            var ascii = char.toInt()
            if (ascii >= 65 && ascii <= 90) // capital letters
                lowerCase += (char + 32)    // lowercase counterpart
            else
                lowerCase += char
        }
        return lowerCase
         */

    }
}