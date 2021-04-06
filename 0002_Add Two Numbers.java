class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int sum = 0;
        
        // 两个链表不一定等长，所以判断条件为或。同时，即使两个链表都遍历完毕，若存在一个进位，仍需进行操作。
        while (l1 != null || l2 != null || sum != 0) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            // sum取模操作可以得出单独的个位
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            // 若sum > 10，则说明存在进位，除以10后变为1，代表进位，会累加到下次运算中。若sum < 10，则说明没有进位，除以10后变为0，不影响下次运算
            sum /= 10;
        }

        return dummy.next;
    }
}
