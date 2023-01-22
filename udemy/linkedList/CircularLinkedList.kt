/*
-Create Circular Singly Linked List
Time Complexity O(1)
Space Complexity O(1)

-Insertion Circular Singly Linked List
Time Complexity O(n)
Space Complexity O(1)

-Traversal in Circular Singly Linked List
Time Complexity O(n)
Space Complexity O(1)

-Search node in Circular Singly Linked List
Time Complexity O(n)
Space Complexity O(1)

-Delete node in Circular Singly Linked List
Time Complexity O(n)
Space Complexity O(1)

-Delete all Circular Singly Linked List
Time Complexity O(1)
Space Complexity O(1)
 */


class Node {
    var value = 0
    var next: Node? = null
}

class CircularSinglyLinkedList {
    var head: Node? = null
    var tail: Node? = null
    var size = 0

    fun createCircularSinglyLinkedList(nodeValue: Int): Node? {
        head = Node()
        val node = Node()
        node.value = nodeValue
        node.next = node
        head = node
        tail = node
        size = 1
        return head

    }

    fun insertInCircularLinkedList(nodeValue: Int, location: Int) {
        val node = Node()
        node.value = nodeValue
        if (head == null) {
            createCircularSinglyLinkedList(nodeValue)
            return
        } else if (location == 0) {
            node.next = head
            head = node
            tail.next = head
        } else if (location >= size) {
            tail.next = node
            tail = node
            tail.next = head
        } else {
            var tempNode = head
            var index = 0
            while (index < location - 1) {
                tempNode = tempNode!!.next
                index++
            }
            node.next = tempNode!!.next
            tempNode.next = node
        }
        size++
    }

    fun traversalCSLL() {
        if (head != null) {
            var tempNode = head
            for (i in 0 until size) {
                println(tempNode.value)
                if (i != size - 1) {
                    println("->")
                }
                tempNode = tempNode.next
            }
        } else {
            println("CSLL is not exist!")
        }
    }

    fun searchNodeCSLL(nodeValue: Int): Boolean {
        if (head != null) {
            var tempNode = head
            for (i in 0 until size) {
                if (tempNode.value == nodeValue) {
                    println("Found node at lcoation "+i)
                    return true
                }
                tempNode = tempNode.next
            }
        }
        println("Node not found")
        return false
    }

    fun deleteNodeCSLL(location: Int) {
        if (head == null) {
            println("The CSLL is not exist")
            return
        } else if (location == 0) {
            head = head.next
            tail.next = head
            size--
            if (size == 0) {
                tail = null
                head.next = null
                head = null
            }
        } else if (location >= size) {
            var tempNode = head
            for (i in 0 until size-1) {
                tempNode = tempNode.next
            }
            if (tempNode == head) {
                head.next = null
                tail = head = null
                size--
                return
            }
            tempNode.next = head
            tail = tempNode
            size--
        } else {
            var tempNode = head
            for (i in 0 until location-1) {
                tempNode = tempNode.next
            }
            tempNode.next = tempNode.next.next
            size--
        }
    }

    fun deleteCSLL() {
        if (head == null) {
            println("CSLL is not exist")
        } else {
            head = null
            tail.next = null
            tail = null
            println("CSLL has been deleted!")
        }
    }
}

fun circularSinglyLinkedListExamples() {
    val cSLL = CircularSinglyLinkedList()
    cSLL.createCircularSinglyLinkedList(5)
    println(cSLL.head!!.value)

}

























