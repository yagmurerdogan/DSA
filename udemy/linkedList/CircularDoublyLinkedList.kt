class DoublyNode {
    var value: Int = 0
    var next: DoublyNode? = null
    var prev: DoublyNode? = null
}

class CircularDoublyLinkedList {
    var head: DoublyNode? = null
    var tail: DoublyNode? = null
    var size = 0

    /*
    -Create CDLL
    Time Comp O(1)
    Space Comp O(1)
     */
    fun createCDLL(nodeValue: Int): DoublyNode {
        head = DoublyNode()
        var newNode = DoublyNode()
        newNode.value = nodeValue
        head = newNode
        tail = newNode
        newNode.next = newNode
        newNode.prev = newNode
        size = 1
        return head
    }

    /*
    -Insert Node CDLL
    Time Comp O(N)
    Space Comp O(1)
     */
    fun insertNodeCDLL(nodeValue: Int, location: Int) {
        var newNode = DoublyNode()
        newNode.value = nodeValue
        if (head == null) {
            createCDLL(nodeValue)
            return
        } else if (location == 0) {
            newNode.next = head
            newNode.prev = tail
            head.prev = newNode
            tail.next = newNode
            head = newNode
        } else if (location >= size) {
            newNode.next = head
            newNode.prev = tail
            head.prev = newNode
            tail.next = newNode
            tail = newNode
        } else {
            var tempNode = head
            var index = 0
            while (index < location - 1) {
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
    -Traverse CDLL
    Time Comp O(N)
    Space Comp O(1)
     */
    fun traverseCDLL() {
        if (head != null) {
            var tempNode = head
            for (i in 0 until size) {
                prinltn(tempNode.value)
                if (i != size - 1) {
                    println("->")
                }
                tempNode = tempNode.next
            }
        } else {
            println("The CDLL is nto exist")
        }
    }

    /*
    -Reverse Traverse CDLL
    Time Comp O(N)
    Space Comp O(1)
     */
    fun reverseTraverseCDLL() {
        if (head != null) {
            var tempNode = tail
            for (i in 0 until size) {
                prinltn(tempNode.value)
                if (i != size - 1) {
                    println("<-")
                }
                tempNode = tempNode.prev
            }
        } else {
            println("The CDLL is nto exist")
        }
    }


    /*
    -Search Node in CDLL
    Time Comp O(N)
    Space Comp O(1)
     */
    fun searchNodeCDLL(nodeValue: Int): Boolean {
        if (head != null) {
            var tempNode = head
            for (i in 0 until size) {
                if (tempNode.value == nodeValue) {
                    println("node is found at locatiion " + i)
                    return true
                }
                tempNode = tempNode.next
            }
        }
        println("Node Not Found")
        retrun false
    }

    /*
    -Delete Node in CDLL
    Time Comp O(N)
    Space Comp O(1)
     */
    fun deleteNodeCDLL(location: Int) {
        if (head == null) {
            println("CDLL is not exist")
            return
        } else if (location == 0) {
            if (size == 1) {
                head.prev = null
                head.next = null
                head = tail = null
                size--
                return
            } else {
                head = head.next
                head.prev = tail
                tail.next = head
                size--
            }
        } else if (location >= size) {
            if (size == 1) {
                head.prev = null
                head.next = null
                head = tail = null
                size--
                return
            } else {
                tail = tail.prev
                tail.next = head
                head.prev = tail
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
    -Delete all CDLL
    Time Comp O(N)
    Space Comp O(1)
     */
    fun deleteCDLL() {
        var tempNode = head
        for (i in 0 until size) {
            tempNode.prev = null
            tempNode = tempNode.next
        }
        head = null
        tail = null
        println("The CDLL has been deleted!")
    }
    
}