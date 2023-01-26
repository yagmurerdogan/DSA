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
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var list1 = l1
        var list2 = l2
        val head = ListNode(0)
        var result: ListNode? = head
        var carry = 0
        while (list1 != null || list2 != null || carry > 0) {
            val x1 = list1?.`val` ?: 0
            val x2 = list2?.`val` ?: 0
            val sum = (x1 + x2 + carry) % 10
            carry = (x1 + x2 + carry) / 10
            result?.next = ListNode(sum)
            result = result?.next
            if (list1 != null) list1 = list1.next
            if (list2 != null) list2 = list2.next
        }
        return head.next
    }
}