class DoublyNode {
    var value: Int = 0
    var next: DoublyNode? = null
    var prev: DoublyNode? = null
}

class DoublyLinkedList {
    var head: DoublyNode? = null
    var tail: DoublyNode? = null
    var size: Int = 0

    /*
    -Create DLL
    Time Comp O(1)
    Space Comp O(1)
     */
    fun createDLL(nodeValue: Int): DoublyNode {
        head = DoublyNode()
        var newNode = DoublyNode()
        newNode.value = nodeValue
        newNode.next = null
        newNode.prev = null
        head = newNode
        tail = newNode
        size = 1
        return head
    }

    /*
    -Insert DLL
    Time Comp O(N)
    Space Comp O(1)
     */
    fun insertDLL(nodeValue: Int, location: Int) {
        var newNode = DoublyNode()
        newNode.value = nodeValue
        if (head == null) {
            createDLL(nodeValue)
            return
        } else if (location == 0) {
            newNode.next = head
            newNode.prev = null
            head.prev = newNode
            head = newNode
        } else if (location >= size) {
            newNode.next = null
            tail.next = newNode
            newNode.prev = tail
            tail = newNode
        } else {
            var tempNode : DoublyNode = head
            var index = 0
            while (index < location-1) {
                tempNode = tempNode.next
                index++
            }
            newNode.prev = tempNode
            newNode.next = tempNode.next
            tempNode.next = newNode
            newNode.next.prev = newNode
        }
        size++
    }

    /*
    -Traversal DLL
    Time Comp O(N)
    Space Comp O(1)
    */
    fun traversalDLL() {
        if (head != null) {
            var tempNode = head
            for (i in 0 until size) {
                println(tempNode.value)
                if (i != size-1) {
                    println("->")
                }
                tempNode = tempNode.next
            }
        } else {
            println("The DLL is not exist!")
        }
    }

    /*
     -Reverse Traversal DLL
     Time Comp O(N)
     Space Comp O(1)
     */
    fun reverseTraversalDLL() {
        if (head != null) {
            var tempNode = tail
            for (i in 0 until size) {
                println(tempNode.value)
                if (i != size-1) {
                    println("<-")
                }
                tempNode = tempNode.prev
            }
        } else {
            println("The DLL is not exist!")
        }
    }

    /*
     -Search Node in DLL
     Time Comp O(N)
     Space Comp O(1)
     */
    fun searchNode(nodeValue: Int) : Boolean {
        if (head != null) {
            var tempNode = head
            for (i in 0 until size) {
                if (tempNode.value == nodeValue) {
                    println("Node is found at location " +i)
                    return true
                }
                tempNode = tempNode.next
            }
        }
        println("Node not found")
        return false
    }

    /*
     -Delete Node in DLL
     Time Comp O(N)
     Space Comp O(1)
     */
    fun deleteNodeDLL(location: Int) {
        if (head == null) {
            println("DLL is not exist")
            return
        } else if (location == 0) {
            if (size == 1) {
                head = null
                tail = null
                size--
                return
            } else {
                head = head.next
                head.prev = null
                size--
            }
        } else if (location >= size) {
            var tempNode = tail.prev
            if (size == 1) {
                head = null
                tail = null
                size--
                return
            } else {
                tempNode.next = null
                tail = tempNode
                size--
            }
        } else {
            var tempNode = head
            for (i in 0 until location - 1) {
                tempNode = tempNode.next
            }
            tempNode.next = tempNode.next.next
            tempNode.next.prev = tempNode
            size--
        }
    }

    /*
     -Delete DLL
     Time Comp O(N)
     Space Comp O(1)
     */
    fun deleteDLL() {
        var tempNode = head
        for(i in 0 until size) {
            tempNode.prev = null
            tempNode = tempNode.next
        }
        head = null
        tail = null
        println("DLL has been deleted")
    }
}