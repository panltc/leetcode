class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        // 奇数个结点，slow指针会停留在正中间。偶数个结点，slow会停留在链表a的尾部
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 链表a从head开始，链表b从slow下一个结点开始
        ListNode currA = head;
        ListNode currB = slow.next;
        slow.next = null;
        // 头结点重置，准备进行反转链表操作
        dummy.next = null;

        // 反转b链表
        while (currB != null) {
            ListNode tmp = currB.next;
            currB.next = dummy.next;
            dummy.next = currB;
            currB = tmp;
        }

        currB = dummy.next;
        while (currA != null && currB != null) {
            if (currA.val != currB.val) {
                return false;
            }
            currA = currA.next;
            currB = currB.next;
        }

        return true;
    }
}
