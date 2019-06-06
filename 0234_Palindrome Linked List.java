class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        ListNode dummy = new ListNode(0);
        while (slow != null) {
            ListNode tmp = slow.next;
            slow.next = dummy.next;
            dummy.next = slow;
            slow = tmp;
        }
        ListNode cur = dummy.next;
        while (cur != null) {
            if (cur.val != head.val) {
                return false;
            }
            cur = cur.next;
            head = head.next;
        }
        return true;
    }
}
