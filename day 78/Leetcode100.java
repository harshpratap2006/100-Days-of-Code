public class Leetcode100 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {

        // Both trees are empty at this position
        if (p == null && q == null) {
            return true;
        }

        // One is empty and the other is not
        if (p == null || q == null) {
            return false;
        }

        // Values are different
        if (p.val != q.val) {
            return false;
        }

        // Check both left and right subtrees
        return isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {

        // Tree p
        //       1
        //      / \
        //     2   3

        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);

        // Tree q
        //       1
        //      / \
        //     2   3

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);

        boolean result = isSameTree(p, q);

        System.out.println("Are the trees same? " + result);
    }
}