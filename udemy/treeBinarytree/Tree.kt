/*
A Tree is nonlinear ds with hierarchical relationships between its elements
without having any cycle, it is basically reversed from a real life tree

Properties
Represent hierarchical data
Each node has two components: Data and a link to its sub category
Base category and sub categories under it

Why Tree?
-Quicker and Easier access to the data
-Store hierarchical data, like folder structure, organization structure, xml/html data
-Binary Search Tree, AVL, Red Black Tree, Trie

Terminology
Root: Top node without parent
Edge: A link between parent and child
Leaf: A Node which does not have children
Sibling: Children of same parent
Ancestor: parent, grandparent, great grandparent of a node
Depth of node: A length of the path from root to node
Height of node: A length of the path from the node to the deepest node
Depth of tree: Depth of root node
Height of tree: Height of root node
 */

class TreeNode(data: String) {
    private var data: String? = data
    private var children = ArrayList<TreeNode>()

    fun addChild(node: TreeNode) {
        this.children.add(node)
    }

    fun print(level: Int): String {
        var ret = ""
        ret = " ".repeat(level) + data + "\n"
        for (node: TreeNode in this.children) {
            ret += node.print(level + 1)
        }
        return ret
    }
}

fun treeFuns() {
    var drinks = TreeNode("Drinks")
    var hot = TreeNode("Hot")
    var cold = TreeNode("Cold")
    var tea = TreeNode("Tea")
    var coffee = TreeNode("Coffee")
    var wine = TreeNode("Wine")
    var beer = TreeNode("Beer")
    drinks.addChild(hot)
    drinks.addChild(cold)
    hot.addChild(tea)
    hot.addChild(coffee)
    cold.addChild(wine)
    cold.addChild(beer)
    println(drinks.print(0))
}

/*
Binary Tree
Binary trees are the data structures in which each node has at most two children,
often referred to as the left and right children

Binary tree is a family of data structure(BST, Heap tree, AVL, Red black trees, Syntax tree)

Why Binary Tree?
Binary trees are a prerequisite for mode advanced trees like BST, AVL, Red black trees
Huffman  coding problem, heap priority problem and expression parsing problems can
be solved efficiently using binary trees

Tyoes of Binary Tree
-Full Binary Tree
Each node has 2 children

-Perfect Binary Tree
All non leaf nodes have 2 children

-Complete Binary Tree
All levels are completely filled except to last level

-Balanced Binary Tree
Each leaf is not more than a ceratin distance from the root node than any other

Binary Tree Implementation
-Linked List
-Array (skip first cell, 1 -> root, left child cell[2x], right child cell[2x+1]


Binary Tree using Linked List
-Creation of Tree
-Insertion of a node
-Deletion of a node
-Search for a value
-Traverse all nodes
-Deletion of tree
 */

class BinaryNode {
    var value: String = ""
    var left: BinaryNode? = null
    var right: BinaryNode? = null
    var height: Int = 0
}

class BinaryTreeLL {
    var root: BinaryNode? = null

    /*
    Binary Tree Traversal
    -> Depth First Search
    - Preorder traversal
    - Inorder traversal
    - Post order traversal

    -> Breadth First Search
    - Level order traversal

    ---Pre Order Traversal---
    Root Node -> Left Subtree -> Right Subtree
    Time Comp O(N)
    Space Comp O(N)
     */

    fun preOrder(node: BinaryNode) {
        if (node == null) {
            return
        }
        println(node.value + " ")
        node.left?.let { preOrder(it) }
        node.right?.let { preOrder(it) }
    }

    /*    ---InOrder Traversal---
    Left Subtree -> Root Node ->  Right Subtree
    Time Comp O(N)
    Space Comp O(N)
     */
    fun inOrder(node: BinaryNode?) {
        if (node == null) return
        inOrder(node.left)
        println(node.value + " ")
        inOrder(node.right)
    }

    /*    ---postOrder Traversal---
    Left Subtree -> Right Node ->  Root Subtree
    Time Comp O(N)
    Space Comp O(N)
     */
    fun postOrder(node: BinaryNode?) {
        if (node == null) return
        postOrder(node.left)
        postOrder(node.right)
        println(node.value + " ")
    }

    /*    ---levelOrder Traversal---
    Time Comp O(N)
    Space Comp O(N)
     */
    fun levelOrder() {
        val queue: Queue<BinaryNode> = LinkedList<BinaryNode>()
        queue.add(root)
        while (!queue.isEmpty()) {
            val presentNode = queue.remove()
            print(presentNode.value + " ")
            if (presentNode.left != null) {
                queue.add(presentNode.left)
            }
            if (presentNode.right != null) {
                queue.add(presentNode.right)
            }
        }
    }

    /*    ---search---
    Time Comp O(N)
    Space Comp O(N)
     */
    fun search(value: String) {
        val queue: Queue<BinaryNode> = LinkedList<BinaryNode>()
        queue.add(root)
        while (!queue.isEmpty()) {
            val presentNode = queue.remove()
            if (presentNode.value == value) {
                println("The value " + value + " is found in Tree")
                return
            } else {
                if (presentNode.left != null) {
                    queue.add(presentNode.left)
                }
                if (presentNode.right != null) {
                    queue.add(presentNode.right)
                }
            }
        }
        println("The value " + value + " is not found in Tree")
    }

    /*    ---insert---
    Time Comp O(N)
    Space Comp O(N)
     */
    fun insert(value: String) {
        val newNode: BinaryNode = BinaryNode()
        newNode.value = value
        if (root == null) {
            root = newNode
            println("Inserted new node at root")
            return
        }
        var queue: Queue<BinaryNode> = LinkedList<BinaryNode>()
        queue.add(root)
        while (!queue.isEmpty()) {
            val presentNdode: BinaryNode = queue.remove()
            if (presentNdode.left == null) {
                presentNdode.left = newNode
                println("Inserted success")
                break
            } else if (presentNdode.right == null) {
                presentNdode.right = newNode
                println("Inserted success")
                break
            } else {
                queue.add(presentNdode.left)
                queue.add(presentNdode.right)
            }
        }
    }

    /*    ---delete given node---
    Time Comp O(N)
    Space Comp O(N)
     */

    fun getDeepestNode(): BinaryNode {
        val queue: Queue<BinaryNode> = LinkedList<BinaryNode>()
        queue.add(root)
        var presentNdode: BinaryNode? = null
        while (!queue.isEmpty()) {
            presentNdode = queue.remove()
            if (presentNdode.left != null) {
                queue.add(presentNdode.left)
            }
            if (presentNdode.right != null) {
                queue.add(presentNdode.right)
            }
        }
        return presentNdode!!
    }

    fun deleteDeepestNode() {
        val queue: Queue<BinaryNode> = LinkedList<BinaryNode>()
        queue.add(root)
        var previousNode: BinaryNode? = null
        var presentNode: BinaryNode? = null
        while (!queue.isEmpty()) {
            previousNode = presentNode
            presentNode = queue.remove()

            if (presentNode.left == null) {
                previousNode.right = null
                return
            } else if(presentNode.right == null) {
                presentNode.left = null
                return
            }
            queue.add(presentNode.left)
            queue.add(presentNode.right)
        }
    }

    fun deleteGivenNode(value: String) {
        val queue: Queue<BinaryNode> = LinkedList<BinaryNode>()
        queue.add(root)
        while (!queue.isEmpty()) {
            var presentNode: BinaryNode = queue.remove()
            if (presentNode.value == value) {
                presentNode.value = getDeepestNode().value
                deleteDeepestNode()
                println("The node is deleted")
                return
            }  else {
                if (presentNode.left != null) queue.add(presentNode.left)
                if (presentNode.right != null) queue.add(presentNode.right)
            }
        }
        println("The node does not exist in this BT")
    }

    /*    ---delete all bt---
    Time Comp O(1)
    Space Comp O(1)
     */
    fun deleteAllBinaryTree() {
        root = null
        println("BT has been deleted!")
    }


}

fun binaryTreeFuns() {
    var binaryTree = BinaryTreeLL()
    var N1 = BinaryNode()
    N1.value = "N1"
    var N2 = BinaryNode()
    N2.value = "N2"
    var N3 = BinaryNode()
    N3.value = "N3"
    var N4 = BinaryNode()
    N4.value = "N4"
    var N5 = BinaryNode()
    N5.value = "N5"
    var N6 = BinaryNode()
    N6.value = "N6"
    var N7 = BinaryNode()
    N7.value = "N7"
    var N8 = BinaryNode()
    N8.value = "N8"
    var N9 = BinaryNode()
    N9.value = "N9"

    N1.left = N2
    N1.right = N3
    N2.left = N4
    N2.right = N5
    N3.left = N6
    N3.right = N7
    N4.left = N8
    N4.right = N9
    binaryTree.root = N1

    binaryTree.preOrder(binaryTree.root!!)
}

/*
--- Binary tree using Array ---

- creation of tree
- insertion of a node
- deletion of a node
- search for a value
- traverse all nodes
- deletion of tree

 */

class BTArray() {
    var arr: Array<String?>? = null
    var lastUsedIndex = 0

    /*
    Create bt with array
    time comp O(1)
    space comp O(N)
     */
    fun createBTArray(size: Int) {
        arr = arrayOfNulls(size + 1)
        println("Blank tree of size $size has been created")
    }

    /*
    isfull
    time comp O(1)
    space comp O(1)
     */
    fun isFull(): Boolean {
        return arr!!.size - 1 == lastUsedIndex
    }

    /*
    insert
    time comp O(1)
    space comp O(1)
     */
    fun insert(value: String) {
        if (!isFull()) {
            arr!![lastUsedIndex + 1] = value
            lastUsedIndex++
            println("The value of $value has been inserted")
        } else {
            println("The BT is full")
        }
    }

    /*
    Binary Tree(Array) Traversal
    -> Depth First Search
    - Preorder traversal (root - left - right)
    - Inorder traversal (left - root - right)
    - Post order traversal  (left - right - root)

    -> Breadth First Search
    - Level order traversal
     */

    /*
    preorder
    time comp O(N)
    space comp O(N)
     */
    fun preorder(index: Int) {
        if (index > lastUsedIndex) {
            return
        }
        print(arr!![index] + "")
        preorder(index*2)
        preorder(index*2+1)
    }

    /*
    inorder
    time comp O(N)
    space comp O(N)
     */
    fun inorder(index: Int) {
        if (index > lastUsedIndex) {
            return
        }
        inorder(index*2)
        print(arr!![index] + "")
        inorder(index*2+1)
    }

    /*
    postorder
    time comp O(N)
    space comp O(N)
     */
    fun postorder(index: Int) {
        if (index > lastUsedIndex) {
            return
        }
        postorder(index*2)
        postorder(index*2+1)
        print(arr!![index] + "")
    }

    /*
    levelorder
    time comp O(N)
    space comp O(1)
     */
    fun levelorder() {
        for (i in 1..lastUsedIndex) {
            println(arr!![i]+ " ")
        }
    }

    /*
    search
    time comp O(N)
    space comp O(1)
     */
    fun search(value: String) : Int {
        for (i in 1..lastUsedIndex) {
            if (arr!![i] == value) {
                println("$value exists at location $i")
                return i
            }
        }
        println("The value does not exist in BT")
        return -1
    }

    /*
    delete node
    time comp O(N)
    space comp O(1)
     */
    fun deletenode(value: String) {
        var location = search(value)
        if (location == -1) {
            return
        } else {
            arr!![location] = arr!![lastUsedIndex]
            lastUsedIndex--
            println("The node has been deleted")
        }
    }

    /*
    delete bt
    time comp O(1)
    space comp O(1)
     */
    fun deletebt()  {
        try {
            arr = null
            println("The bt has been deleted")
        } catch (e: Exception) {
            println("There was an error deleting the tree")
        }
    }

}