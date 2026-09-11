class Leetcode543 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static int diameter = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }

    static int height(TreeNode node) {

        if (node == null) {
            return 0;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        // Longest path passing through current node
        int currentDiameter = leftHeight + rightHeight;

        diameter = Math.max(diameter, currentDiameter);

        // Return height of current node
        return Math.max(leftHeight, rightHeight) + 1;
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

        System.out.println("Diameter = " + diameterOfBinaryTree(root));
    }
}