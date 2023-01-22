/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var head = head
        if (head?.next == null) return null
        var slowPointer = head
        var fastPointer = head
        var count = 1
        while (fastPointer?.next != null) {
            fastPointer = fastPointer.next
            count++
            if (count > n && fastPointer?.next != null) {
                slowPointer = slowPointer?.next
            }
        }
        if (count == n) {
            head = slowPointer?.next
            return head
        }

        val nextToTargetNode = slowPointer?.next?.next
        slowPointer?.next = nextToTargetNode

        return head
    }
}