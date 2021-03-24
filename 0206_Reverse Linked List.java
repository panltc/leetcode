// Approach 1: iterative
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode curr = head;

        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = dummy.next;
            dummy.next = curr;
            curr = tmp;
        }

        return dummy.next;
    }
}

// Approach 2: recursive
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode res = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        
        return res;
    }
}
