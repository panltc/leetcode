// Approach 1: iterative
class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node begin = root;
        while (begin.left != null) {
            Node cur = begin;
            while (cur != null) {
                cur.left.next = cur.right;
                if (cur.next != null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            begin = begin.left;
        }
        return root;
    }
}

// Approach 2: recursive
class Solution {
    public Node connect(Node root) {
        if (root == null || root.left == null) {
            return root;
        }
        root.left.next = root.right;
        if (root.next != null) {
            root.right.next = root.next.left;
        }
        root.left = connect(root.left);
        root.right = connect(root.right);
        return root;
    }
}
