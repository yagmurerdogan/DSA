class Solution {
    fun defangIPaddr(address: String): String {
            val builder = StringBuilder()
            address.forEach{ ch->
            if(ch == '.')
            builder.append("[.]")
            else
            builder.append(ch)
        }
        return builder.toString()
    }
}