// Approach 1
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            /*
             * 存在环的情况下，fast和slow第一次相遇时：fast走了slow + nb的距离（b是环的长度），且fast走的距离是slow的两倍，则slow走了nb的距离
             * 从起点出发，一个指针只要走a + nb（a是起点到入环第一个点的距离）的距离就可以到达入环的第一个点，因此s再走a的距离就可以到达这个点
             * 相遇后，让fast从起点出发，每次都和slow同步移动一个节点的距离，两者再相遇的点，就是入环的第一个点
             */
            if (fast == slow) {
                fast = head;

                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                
                return fast;
            }
        }

        return null;
    }
}

// Approach 2
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // set数据结构可以保证节点的唯一性
        Set<ListNode> set = new HashSet<>();

        // 对于遍历到的每一个节点，都将其加入set。如果一个节点不能加入set，说明该元素就是入环的第一个节点
        while (head != null) {
            if (!set.add(head)) {
                return head;
            }
            head = head.next;
        }

        return null;
    }
}
