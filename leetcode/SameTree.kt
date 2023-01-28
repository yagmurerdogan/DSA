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
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        return p.isEqual(q)
    }

    fun TreeNode?.isEqual(second: TreeNode?): Boolean {
        if (this == null) { return second == null }
        val children = left.isEqual(second?.left) && right.isEqual(second?.right)
        return `val` == second?.`val` && children
    }
}

class Solution {

    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean = when {
        p == null && q == null -> true
        p != null && q != null -> p.`val` == q.`val` && isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
        else -> false
    }
}