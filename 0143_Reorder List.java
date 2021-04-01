class Solution {
    public void reorderList(ListNode head) {
        // 快慢指针用来确定链表的中间结点，加入一个头结点方便slow指针停留在中间点上，方便后续断链
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
        // 链表a需要断链，防止出现环
        slow.next = null;
        // 头结点重置，准备进行反转链表操作
        dummy.next = null;

        // 反转链表，让链表b形成顺序为n, n - 1, n - 2...的结构
        while (currB != null) {
            ListNode tmp = currB.next;
            currB.next = dummy.next;
            dummy.next = currB;
            currB = tmp;
        }

        currB = dummy.next;
        // 交替连接两个链表的结点
        while (currA != null && currB != null) {
            ListNode tmpA = currA.next;
            ListNode tmpB = currB.next;
            currA.next = currB;
            currB.next = tmpA;
            currA = tmpA;
            currB = tmpB;
        }
    }
}
