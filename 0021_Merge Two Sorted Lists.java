// Approach 1: iterative
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 新建一个头节点方便操作
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        
        // l1和l2分别遍历两个链表，当两个节点都不为空的时候才能进行比较操作
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        // 如果有链表没有遍历完，那么数值必然全部大于新链表，统一赋值给l1，并直接添加到新链表后面
        if (l2 != null) {
            l1 = l2;
        }
        curr.next = l1;

        return dummy.next;
    }
}

// Approach 2: recursive
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            // 如果l1的值小于l2的值，就将l1后续的链表和l2链表合并为有序链表，并接在l1后面，并返回以l1开头的新链表
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
