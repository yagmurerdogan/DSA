fun detectCapitalUse(word: String): Boolean {
    val c = word.filter { it.isUpperCase() }.count()
    return c == word.length || c == 0 || c == 1 && word[0].isUpperCase()
}

fun detectCapitalUse(word: String): Boolean {
    val n = word.length
    if (n == 1) {
        return true
    }

    // case 1: All capital
    if (Character.isUpperCase(word[0]) && Character.isUpperCase(word[1])) {
        for (i in 2 until n) {
            if (Character.isLowerCase(word[i])) {
                return false
            }
        }
        // case 2 and case 3
    } else {
        for (i in 1 until n) {
            if (Character.isUpperCase(word[i])) {
                return false
            }
        }
    }

    // if pass one of the cases
    return true
}