class Solution {
    fun interpret(command: String): String {
        val sb = StringBuilder()
        for(i in command.indices) {

            when(command[i]) {
                'G' -> sb.append("G")
                ')' -> sb.append(if(command[i-1] == '(') "o" else "al")
            }
        }
        return sb.toString()
    }
}