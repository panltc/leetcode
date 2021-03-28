// Approach 1
class Solution {
    // map存储一个节点和它对应的父节点，key是子节点，value是父节点
    private Map<TreeNode, TreeNode> map = new HashMap<>();
    // set存储遍历过的元素
    private Set<TreeNode> set = new HashSet<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        // p节点通过map中存储的父子节点关系不断上溯，并将已经遍历过的节点存入set
        while (p != null) {
            set.add(p);
            p = map.get(p);
        }
        // q节点也通过map中存储的父子节点关系不断上溯，如果set中已经包含了当前的q，说明当前的q就是p和q的最近公共祖先
        while (q != null) {
            if (set.contains(q)) {
                return q;
            }
            q = map.get(q);
        }

        return null;
    }

    // dfs会深度遍历二叉树，如果一个节点它左右子树不空，就将这个子节点和该父节点存入map中
    private void dfs(TreeNode root) {
        if (root.left != null) {
            map.put(root.left, root);
            dfs(root.left);
        }
        if (root.right != null) {
            map.put(root.right, root);
            dfs(root.right);
        }
    }
}

// Approach 2
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        // 如果root等于任意一个节点，那么root就是该节点的最近祖先，直接返回root
        if (root == p || root == q) {
            return root;
        }
        /*
         * 如果root不等于任意一个节点，说明p或者q在左子树或右子树中，递归查找左子树和右子树
         * 因为必然存在两个节点的公共祖先，所以不在左子树中，就在右子树中。如果没有再左子树中找到，则返回右子树，反之亦然
         * 如果左右子树递归结果均不为空，说明p和q正好是两个左右子树的根节点，那么当前根节点就是最近公共祖先
         */
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        return root;
    }
}
