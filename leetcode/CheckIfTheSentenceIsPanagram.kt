fun checkIfPangram(sentence: String): Boolean {
    // Empty set 'seen'.
    val seen: MutableSet<Char> = HashSet()

    // Iterate over 'sentence' add every letter to 'seen'.
    for (currChar in sentence.toCharArray()) seen.add(currChar)

    // If the size of 'seen' is 26, then 'sentence' is a pangram.
    return seen.size == 26
}
fun checkIfPangram(sentence: String): Boolean {
    var dictionary = HashSet<Char>()
    var count = 0
    for (i in 0..sentence.length - 1) {
        if (!dictionary.contains(sentence.get(i))) {
            dictionary.add(sentence.get(i))
            count++
        }
    }
    return if (count == 26) true else return false
}