fun makeGood(s: String): String {
    if(s.length==1)
        return s

    val stringBuilder = StringBuilder()
    for(char in s){
        val size = stringBuilder.length
        if(size>0 && stringBuilder[size-1].equals(char,true) &&
            ((stringBuilder[size-1].isLowerCase() && char.isUpperCase())||(stringBuilder[size-1].isUpperCase() && char.isLowerCase()))){
            stringBuilder.deleteCharAt(size-1)
        } else {
            stringBuilder.append(char)
        }
    }
    return stringBuilder.toString()
}