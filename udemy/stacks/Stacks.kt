/*
Stack is a data structure that stores items in a Last-In/First-Out manner (LIFO Method)

--- Stack Operations ---
-Create Stack
-Push (insert)
-Pop (remove)
-Peek (return last item but dont remove it)
-isEmpty (return boolean)
-isFull (return boolean, make sense with arrays, not linked lists)
-deleteStack (all elements will be deleted)


--- Stack Creation ---
-> With arrays
- Easy to implement
- Fixed size

-> With Linked List
- Variable size
- Implementation is not easy

--- When to use/avoid Stack ---

-> Use
-LIFO Functionality
-The chance of data corruption is minimum

-> Avoid
-Random access is not possible

 */


class Stack(size: Int) {
    var arr: IntArray?
    var topOfStack: Int

    /*creation
    time comp -> O(1)
    space comp -> O(n)
     */
    init {
        arr = IntArray(size)
        topOfStack = -1
        println("The stack is created with size of  -> $size")
    }

    /* isEmpty()
    time comp -> O(1)
    space comp -> O(1)
    */
    fun isEmpty(): Boolean {
        return if (topOfStack == -1) {
            println("The stack is empty!")
            true
        } else false
    }

    /* isFull()
    time comp -> O(1)
    space comp -> O(1)
 */
    fun isFull(): Boolean {
        return if (topOfStack == arr!!.size - 1) {
            println("the stack is full")
            true
        } else false
    }

    /* push()
        time comp -> O(1)
        space comp -> O(1)
    */
    fun push(value: Int) {
        if (isFull()) {
            println("The stack is full!")
        } else {
            arr!![topOfStack + 1] = value
            topOfStack++
            println("The value is successfully inserted")
        }
    }

    /* pop()
        time comp -> O(1)
        space comp -> O(1)
    */
    fun pop(): Int {
        return if (isEmpty()) {
            println("The stack is empty")
            -1
        } else {
            val topStack = arr!![topOfStack]
            topOfStack--
            topStack
        }
    }

    /* peek()
        time comp -> O(1)
        space comp -> O(1)
    */
    fun peek(): Int {
        return if (isEmpty()) {
            println("The stack is empty!")
            -1
        } else {
            arr!![topOfStack]
        }
    }

    /* deleteStack()
        time comp -> O(1)
        space comp -> O(1)
    */
    fun deleteStack() {
        arr = null
        println("The stack is succesfully deleted!")
    }
}

fun stackExamples() {
    val newStack = Stack(4)
    newStack.isEmpty()
    newStack.push(1)
    newStack.push(2)
    newStack.pop()
    newStack.peek()

}


/*
------- Stack with Linked Lists -------
 */

class Node {
    var value = 0
    var next: Node? = null
}

class SinglyLinkedList {
    var head: Node? = null
    var tail: Node? = null
    var size = 0

    fun createSinglyLinkedList(nodeValue: Int): Node? {
        head = Node()
        val node = Node()
        node.next = null
        node.value = nodeValue
        head = node
        tail = node
        size = 1
        return head
    }

    fun insertInLinkedList(nodeValue: Int, location: Int) {
        val node = Node()
        node.value = nodeValue
        if (head == null) {
            createSinglyLinkedList(nodeValue)
            return
        } else if (location == 0) {
            node.next = head
            head = node
        } else if (location >= size) {
            node.next = null
            tail!!.next = node
            tail = node
        } else {
            var tempNode = head
            var index = 0
            while (index < location - 1) {
                tempNode = tempNode!!.next
                index++
            }
            val nextNode = tempNode!!.next
            tempNode.next = node
            node.next = nextNode
        }
        size++
    }

    fun traverseSinglyLinkedList() {
        if (head == null) {
            println("SLL does not exist")
        } else {
            var tempNode = head
            for (i in 0 until size) {
                println(tempNode!!.value)
                if (i != size - 1) {
                    println("->")
                }
                tempNode = tempNode.next
            }
        }
        println("\n")
    }

    fun searchNode(nodeValue: Int): Boolean {
        if (head != null) {
            var tempNode = head
            for (i in 0 until size) {
                if (tempNode!!.value == nodeValue) {
                    println("Found the node at location $i\n")
                    return true
                }
                tempNode = tempNode.next
            }
        }
        println("Node not found")
        return false
    }

    fun deletionOfNode(location: Int) {
        if (head == null) {
            println("The SLL does not exist")
            return
        } else if (location == 0) {
            head = head!!.next
            size--
            if (size == 0) {
                tail = null
            }
        } else if (location >= size) {
            var tempNode = head
            for (i in 0 until size - 1) {
                tempNode = tempNode!!.next
            }
            if (tempNode == head) {
                head = null
                tail = head
                size--
                return
            }
            tempNode!!.next = null
            tail = tempNode
            size--
        } else {
            var tempNode = head
            for (i in 0 until location - 1) {
                tempNode = tempNode!!.next
            }
            tempNode!!.next = tempNode.next!!.next
            size--
        }
    }

    fun deleteSLL() {
        head = null
        tail = null
        println("The SLL deleted successfully")
    }

}

class StackWithLinked {
    private var linkedList = SinglyLinkedList()

    init {
        println("The stack is created")
    }

    /* push()
        time comp -> O(1)
        space comp -> O(1)
    */
    fun push(value: Int) {
        linkedList.insertInLinkedList(value, 0)
        println("Inserted " + value + "in the Stack")
    }

    /* isEmpty()
        time comp -> O(1)
        space comp -> O(1)
    */
    fun isEmpty(): Boolean {
        return if (linkedList.head == null) true else false
    }

    /* pop()
        time comp -> O(1)
        space comp -> O(1)
    */
    fun pop(): Int {
        var result = -1
        if (isEmpty()) {
            println("The Stack is Empty!")
        } else {
            result = linkedList.head.value
            linkedList.deletionOfNode(0)
        }
        return result
    }

    /* peek()
        time comp -> O(1)
        space comp -> O(1)
    */
    fun peek(): Int {
        return if (isEmpty()) {
            -1
        } else {
            linkedList.head.value
        }
    }

    /* deleteStack()
        time comp -> O(1)
        space comp -> O(1)
    */
    fun deleteStack() {
        linkedList.head = null
        println("The Stack is deleted!")
    }


}

fun stackExamples() {
    val newStackWithLinked = StackWithLinked()
    newStackWithLinked.push(1)
    newStackWithLinked.push(2)
    newStackWithLinked.push(3)
    newStackWithLinked.pop()
    println(newStackWithLinked.isEmpty())
    newStackWithLinked.peek()
    newStackWithLinked.deleteStack()

}

/*
--- PROBLEMS ---
 */

// 1- Describe how you could use a single Array to implement three stacks

/*
Stack 1 -> [0],[1],[2]  -> [0, n/3)
Stack 2 -> [3],[4],[5]  -> [n/3, 2n/3)
Stack 3 -> [6],[7],[8]  -> [2n/3, n)
 */

class ThreeInOne(stackSize: Int) {
    private val numberOfStacks = 3
    private var stackCapacity = stackSize
    private var values = intArrayOf(stackSize * numberOfStacks)
    private var sizes = intArrayOf(numberOfStacks)

    // isFull
    private fun isFull(stackNum: Int): Boolean {
        return sizes[stackNum] == stackCapacity
    }

    // isEmpty
    private fun isEmpty(stackNum: Int): Boolean {
        return sizes[stackNum] == 0
    }

    // indexOfTop - this is helper method for push, pop and peek methods
    private fun indexOfTop(stackNum: Int): Int {
        val offset = stackNum * stackCapacity
        val size = sizes[stackNum]
        return offset + size - 1
    }

    // push
    fun push(stackNum: Int, value: Int) {
        if (isFull(stackNum)) {
            println("The Stack is Full")
        } else {
            sizes[stackNum]++
            values[indexOfTop(stackNum)] = value
        }
    }

    // pop
    fun pop(stackNum: Int): Int {
        return if (isEmpty(stackNum)) {
            println("The Stack is Full")
            -1
        } else {
            val topIndex = indexOfTop(stackNum)
            val value = values[topIndex]
            values[topIndex] = 0
            sizes[stackNum]--
            value
        }
    }

    // peek
    fun peek(stackNum: Int): Int {
        return if (isEmpty(stackNum)) {
            println("The Stack is Full")
            -1
        } else {
            values[indexOfTop(stackNum)]
        }
    }
}

/*
2- Stack Minimum
How would you design a stack which,
in addition to push and pop, has a function min which returns the minimum element?
Push, pop and min should all operate in O(1).
 */