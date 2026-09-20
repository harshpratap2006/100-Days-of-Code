import java.util.*;

public class Leetcode286 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    static boolean getPath(TreeNode root, TreeNode n, ArrayList<TreeNode> path) {
        if (root == null) {
            return false;
        }

        path.add(root);

        if (root == n) {
            return true;
        }

        boolean leftFound = getPath(root.left, n, path);
        boolean rightFound = getPath(root.right, n, path);

        if (leftFound || rightFound) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }

    static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> path1 = new ArrayList<>();
        ArrayList<TreeNode> path2 = new ArrayList<>();

        getPath(root, p, path1);
        getPath(root, q, path2);

        // Find the first position where paths are different
        int i = 0;

        for (; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) != path2.get(i)) {
                break;
            }
        }

        // Last common node
        TreeNode lca = path1.get(i - 1);

        return lca;
    }

    public static void main(String[] args) {

        /*
                 1
                / \
               2   3
              / \
             4   5
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        TreeNode p = root.left.left;   // 4
        TreeNode q = root.left.right;  // 5

        TreeNode result = lowestCommonAncestor(root, p, q);

        System.out.println("Lowest Common Ancestor: " + result.val);
    }
}