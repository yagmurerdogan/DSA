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
    fun deleteDuplicates(head: ListNode?): ListNode? {
        var prev: ListNode? = null
        var curr: ListNode? = head

        while(curr != null) {
            if(prev?.`val` == curr.`val`) {
                prev.next = curr.next
                curr = prev.next
            } else {
                val temp = curr.next
                prev = curr
                curr = temp
            }
        }
        return head
    }
}