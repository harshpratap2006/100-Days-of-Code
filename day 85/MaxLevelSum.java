import java.util.*;

public class MaxLevelSum {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    static int maxLevelSum(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int maxSum = Integer.MIN_VALUE;
        int level = 0;
        int maxLevel = 0;

        while (!q.isEmpty()) {

            int size = q.size();
            int sum = 0;
            level++;

            for (int i = 0; i < size; i++) {

                TreeNode currNode = q.remove();

                sum += currNode.val;

                if (currNode.left != null) {
                    q.add(currNode.left);
                }

                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }

            if (sum > maxSum) {
                maxSum = sum;
                maxLevel = level;
            }
        }

        return maxLevel;
    }

    public static void main(String[] args) {

        /*
                 1
                / \
               7   0
              / \
             7  -8
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(7);
        root.right = new TreeNode(0);

        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(-8);

        int result = maxLevelSum(root);

        System.out.println("Level with maximum sum: " + result);
    }
}