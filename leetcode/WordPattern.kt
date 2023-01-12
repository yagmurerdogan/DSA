fun wordPattern(pattern: String, s: String): Boolean {
    val words = s.split(" ")
    if (words.size != pattern.length) return false

    val matchers = mutableMapOf<Char, String>()
    for (i in pattern.indices) {
        if (matchers.getOrPut(pattern[i]) { words[i] } != words[i]) return false
    }

    if (matchers.values.toSet().size != matchers.size) return false

    return true
}

fun wordPattern(pattern: String, s: String): Boolean {
    val texts = s.split(" ")

    if (texts.size != pattern.length)
        return false

    val map = mutableMapOf<Char, String>()

    pattern.forEachIndexed { index, c ->
        val text = texts[index]

        when (map.containsKey(c)) {
            true -> {
                if (map[c] != text) return false
            }
            false -> {
                if (map.containsValue(text)) return false
                map[c] = text
            }
        }
    }

    return true
}