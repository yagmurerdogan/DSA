class Solution {
    fun mostWordsFound(sentences: Array<String>): Int {
        var maxWord = 0
        sentences.forEach{ sentence ->
            if(sentence.count{it == ' '} + 1 > maxWord)
                maxWord = sentence.count{it == ' '} + 1
        }
        return maxWord
    }
}