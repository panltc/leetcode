class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for (int i = queue.size() - 1; i >= 0; i--) {
                root = queue.poll();
                list.add(root.val);
                for (Node child : root.children) {
                    queue.offer(child);
                }
            }
            res.add(list);
        }
        return res;
    }
}
