public class Leetcode572 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Checks whether two trees are exactly the same
    public static boolean isSameTree(TreeNode p, TreeNode q) {

        // Both nodes are null
        if (p == null && q == null) {
            return true;
        }

        // One is null and the other is not
        if (p == null || q == null) {
            return false;
        }

        // Values are different
        if (p.val != q.val) {
            return false;
        }

        // Check left and right subtrees
        return isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {

        // If root becomes null, no subtree can be found
        if (root == null) {
            return false;
        }

        // Check if subRoot starts from this node
        if (isSameTree(root, subRoot)) {
            return true;
        }

        // Search in left or right subtree
        return isSubtree(root.left, subRoot)
                || isSubtree(root.right, subRoot);
    }

    public static void main(String[] args) {

        // root:
        //
        //         3
        //        / \
        //       4   5
        //      / \
        //     1   2

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);

        // subRoot:
        //
        //       4
        //      / \
        //     1   2

        TreeNode subRoot = new TreeNode(4);
        subRoot.left = new TreeNode(1);
        subRoot.right = new TreeNode(2);

        boolean result = isSubtree(root, subRoot);

        System.out.println("Is subRoot a subtree? " + result);
    }
}