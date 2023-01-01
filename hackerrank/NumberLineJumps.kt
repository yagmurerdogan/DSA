fun kangaroo(x1: Int, v1: Int, x2: Int, v2: Int): String {

    return when {
        x1 < x2 && v1 <= v2 -> "NO"
        (x2 - x1) % (v2-v1) == 0 -> "YES"
        else -> "NO"
    }


    /*
    if(x1 < x2 && v1 <= v2) return "NO"
    return if((x2 - x1) % (v2-v1) == 0) "YES" else "NO"
     */

}