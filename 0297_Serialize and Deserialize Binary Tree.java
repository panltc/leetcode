/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#!";
        }
        String res = root.val + "!";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.left != null) {
                queue.offer(root.left);
                res += root.left.val + "!";
            } else {
                res += "#!";
            }
            if (root.right != null) {
                queue.offer(root.right);
                res += root.right.val + "!";
            } else {
                res += "#!";
            }
        }
        return res;
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split("!");
        int i = 0;
        TreeNode root = generate(vals[i++]);
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            node.left = generate(vals[i++]);
            node.right = generate(vals[i++]);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }
    
    public TreeNode generate(String val) {
        if (val.equals("#")) {
            return null;
        }
        return new TreeNode(Integer.valueOf(val));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
