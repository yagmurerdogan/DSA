/*
Queue is a data structure that stores items in a First-In/First-Out manner (FIFO Method)
A new addition to this queue happens at the end of the queue
First person in the queue will be served first

---Why do we need?---
Utilize first comming data first, while others wait for their turn
FIFO Method

---Reallife Apps---
Point sale system of a restaurant
Printer queue
Call center phone systems

---Queue Operations---
- Create Queue
-Enqueue
-Dequeue
-Peek
-isEmpty
-isFull
-deleteQueue

---Implementation---
1- Array
-> Linear Queue
-> Circular Queue
2- Linked List
*/

class QueueArray(size: Int) {
    var arr: IntArray
    var topOfQueue: Int
    var beginningOfQueue: Int

    /*
    Creating a Queue
    -Time Complexity O(1)
    -Space Complexity O(n)
     */
    init {
        arr = IntArray(size)
        topOfQueue = -1
        beginningOfQueue = -1
        println("The Queue is successfully created with size of: $size")
    }

    /*
    isFull
    -Time Complexity O(1)
    -Space Complexity O(1)
    */
    fun isFull() : Boolean {
        return if (topOfQueue == arr.size -1) true else false
    }

    /*
    isEmpty
    -Time Complexity O(1)
    -Space Complexity O(1)
    */
    fun isEmpty() : Boolean {
        return if (beginningOfQueue == -1 || beginningOfQueue == arr.size) true else false
    }

    /*
    enQueue
    -Time Complexity O(1)
    -Space Complexity O(1)
    */
    fun enQueue(value: Int) {
        if (isFull()) {
            println("The queue is full")
        } else if(isEmpty()) {
            beginningOfQueue = 0
            topOfQueue++
            arr[topOfQueue] = value
            println("Succesfully inserted " + " in the quesue")
        } else {
            topOfQueue++
            arr[topOfQueue] = value
            println("Succesfully inserted " + " in the quesue")
        }
    }

    /*
    deQueue
    -Time Complexity O(1)
    -Space Complexity O(1)
    */
    fun deQueue() : Int {
        if (isEmpty()) {
            println("The Queue is empty!")
            return -1
        } else {
            var result = arr[beginningOfQueue]
            beginningOfQueue++
            if (beginningOfQueue > topOfQueue) {
                beginningOfQueue = topOfQueue = -1
            }
            return result
        }
    }

    /*
    peek
    -Time Complexity O(1)
    -Space Complexity O(1)
    */
    fun peek() : Int {
        if (!isEmpty()) {
            return arr[beginningOfQueue]
        } else {
            println("The Queue is empty!")
            return -1
        }
    }

    /*
    deleteQueue
    -Time Complexity O(1)
    -Space Complexity O(1)
    */
    fun deleteQueue() {
        arr = null
        println("The Queue is successfully deleted!")
    }
}

fun queueExamples() {
    val queueArray = QueueArray(5)
    println(queueArray.isFull())
    println(queueArray.isEmpty())
    queueArray.enQueue(1)
    queueArray.enQueue(2)
    queueArray.enQueue(3)
}

class CircularQueueArray(size: Int) {
    var arr: IntArray
    var topOfQueue: Int
    var beginningOfQueue: Int
    var size: Int

    /*
    Creating a  Circular Queue
    -Time Complexity O(1)
    -Space Complexity O(n)
     */
    init {
        arr = IntArray(size)
        this.size = size
        topOfQueue = -1
        beginningOfQueue = -1
        println("The Circular Queue is successfully created with size of: $size")
    }

    /*
    isEmpty
    -Time Complexity O(1)
    -Space Complexity O(1)
     */
    fun isEmpty() : Boolean {
        return if (topOfQueue == -1) true else false
    }

    /*
    isFull
    -Time Complexity O(1)
    -Space Complexity O(1)
     */
    fun isFull() : Boolean {
        if (topOfQueue+1 == beginningOfQueue) {
            return true
        } else if (beginningOfQueue == 0 && topOfQueue+1 ==size) {
            return true
        } else {
            return false
        }
    }

    /*
    enQueue
    -Time Complexity O(1)
    -Space Complexity O(1)
     */
    fun enQueue(value: Int) {
        if (isFull()) {
            println("the CQ is full")
        } else if (isEmpty()) {
            beginningOfQueue = 0
            topOfQueue++
            arr[topOfQueue] = value
            println("Successfully inserted " + value " in the queue")
        } else {
            if (topOfQueue+1 == size) {
                topOfQueue = 0
            } else {
                topOfQueue++
            }
            arr[topOfQueue] = value
            println("Successfully inserted " + value " in the queue")
        }
    }

    /*
    deQueue
    -Time Complexity O(1)
    -Space Complexity O(1)
     */
    fun deQueue() : Int {
        if (isEmpty()) {
            println("The CQ is Empty!")
            return -1
        } else {
            var result = arr[beginningOfQueue]
            arr[beginningOfQueue] = 0
            if (beginningOfQueue == topOfQueue)  {
                beginningOfQueue = topOfQueue = -1
            } else if (beginningOfQueue+1 == size) {
                beginningOfQueue =0
            } else {
                beginningOfQueue++
            }
            return result
        }
    }

    /*
    peek
    -Time Complexity O(1)
    -Space Complexity O(1)
     */
    fun peek() : Int {
        if (isEmpty()) {
            println("The CQ is Empty!")
            return -1
        } else {
            return arr[beginningOfQueue]
        }
    }

    /*
    deleteQueue
    -Time Complexity O(1)
    -Space Complexity O(1)
    */
    fun deleteQueue() {
        arr = null
        println("The Circular Queue is successfully deleted!")
    }
}

fun circularQueueExamples() {
    val queueArray = CircularQueueArray(5)
}


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
            for (i in 9 until size) {
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

class QueueLinkedList() {
    val linkedList: SinglyLinkedList

    /*
    Creating a Queue
    -Time Complexity O(1)
    -Space Complexity O(1)
     */
    init {
        linkedList = SinglyLinkedList()
        println("The Queue is successfully created")
    }

    /*
    isEmpty
    -Time Complexity O(1)
    -Space Complexity O(1)
     */
    fun isEmpty(): Boolean {
        return if (linkedList.head == null) true else false
    }

    /*
    enQueue
    -Time Complexity O(1)
    -Space Complexity O(1)
     */
    fun enQueue(value: Int) {
        linkedList.insertInLinkedList(value, linkedList.size)
        println("Successfully inserted" +value+" in the queue")
    }

    /*
    deQueue
    -Time Complexity O(1)
    -Space Complexity O(1)
     */
    fun deQueue() : Int {
        var value = -1
        if (isEmpty()) {
            println("Queue is empty!")
        } else {
            value = linkedList.head.value
            linkedList.deletionOfNode(0)
        }
        return value
    }

    /*
    peek
    -Time Complexity O(1)
    -Space Complexity O(1)
     */
    fun peek() : Int {
        if (isEmpty()) {
            println("The Queue is empty") {
                return -1
            } else {
                return linkedList.head.value
            }
        }
    }

    /*
    deleteQueue
    -Time Complexity O(1)
    -Space Complexity O(1)
     */
    fun deleteQueue() {
        linkedList.head = null
        linkedList.tail = null
        println("Queue is successfully deleted")
    }

}


/*
--- PROBLEMS ---
 */



























































