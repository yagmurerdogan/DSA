fun checkTree(root: TreeNode?): Boolean =
    (root?.`val` ?: 0) == (root?.right?.`val` ?: 0) + (root?.left?.`val` ?: 0)