class Solution {
    fun findCenter(edges: Array<IntArray>): Int {
        val n = edges.size + 1
        val indegrees = IntArray(n + 1) { 0 }

        edges.forEach { (source, destination) ->
            indegrees[source]++
            indegrees[destination]++
        }

        for (i in 1..n) {
            if (indegrees[i] == n - 1) {
                return i
            }
        }

        return -1
    }
}