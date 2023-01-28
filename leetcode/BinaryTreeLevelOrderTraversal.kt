/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        // if there aren't any nodes the traversal is empty
        if (root == null) return emptyList()

        val result = mutableListOf<List<Int>>()
        // create the queue (starting with root)
        val queue = LinkedList<TreeNode>()
        queue.add(root)

        while (queue.isNotEmpty()) {
            result.add(queue.toList().map {it.`val`})
            for (i in queue.indices) {
                val cur = queue.pop()
                cur.left?.let {queue.add(it)}
                cur.right?.let { queue.add(it) }
            }
        }

        return result
    }
}