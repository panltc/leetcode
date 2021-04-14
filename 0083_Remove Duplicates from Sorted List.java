// Approach 1: iterative
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;

        while (curr != null && curr.next != null) {
            // 如果当前结点的值和下一个结点的值相同，将当前结点连接到下一个结点的下一个结点即可，否则，跳过当前结点
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        return head;
    }
}

// Approach 2: recursive
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // 如果当前结点为空，或者当前结点为最后一个结点，直接返回该结点
        if (head == null || head.next == null) {
            return head;
        }
        // 递归调用该函数，参数为当前结点的下一个结点，并赋值给当前结点的next
        head.next = deleteDuplicates(head.next);

        /* 如果当前结点的值和下一个结点的值相同，那么就跳过当前结点，返回下一个结点，否则返回当前结点
         * 其实当前结点是连接着下一个结点开始的后续链表的，只是这里不返回以当前结点为开头的链表而已
         */
        return head.val == head.next.val ? head.next : head;
    }
}
