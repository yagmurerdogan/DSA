/*
Linked List vs Array
- elements of linked list are independent objects
- variable size-the size of a linked list is not predefined
- random access- accessing an element is very efficient in arrays

Types of Linked List
- Singly Linked List
- Circular Singly Linked List
- Doubly Linked List
- Circular Doubly Linked List


Creation of Singly Linked List
Time Complexity O(1)
Space Complexity O(1)

* head always points to the first node
* tail always points to the last node

- Create Head and Tail, initialize with null
- Create a blank Node and assign a value to it and reference to null
- Link Head and Tail with these Node


Insert of Singly Linked List
Time Complexity O(n)
Space Complexity O(1)

Traverse of Singly Linked List
Time Complexity O(n)
Space Complexity O(1)

Search Node in Singly Linked List
Time Complexity O(n)
Space Complexity O(1)

Delete Node in Singly Linked List
Time Complexity O(n)
Space Complexity O(1)

Delete Singly Linked List
Time Complexity O(1)
Space Complexity O(1)
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
        System.out.println("The SLL deleted successfully")
    }



}

fun singlyLinkedListExamples() {
    val sLL = SinglyLinkedList()
    sLL.createSinglyLinkedList(5)
    println(sLL.head!!.value)
    sLL.insertInLinkedList(6,1)
    sLL.insertInLinkedList(7,3)
    sLL.insertInLinkedList(8,4)
    sLL.insertInLinkedList(9,0)
    sLL.traverseSinglyLinkedList()
    sLL.deletionOfNode(3)
    sLL.traverseSinglyLinkedList()
}