// Approach 1
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        
        // 快指针跑得快，所以只需要考虑快指针的边界条件
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            // 如果快慢指针相遇了，说明肯定存在环
            if (fast == slow) {
                return true;
            }
        }
        
        return false;
    }
}

// Approach 2
public class Solution {
    public boolean hasCycle(ListNode head) {
        // set数据结构可以保证节点的唯一性
        Set<ListNode> set = new HashSet<>();

        while (head != null) {
            // 对于遍历到的每一个节点，都将其加入set。如果一个节点不能加入set，说明早就遍历过该元素了，从而证明链表中存在环
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }

        return false;
    }
}
