class TreeDiameter{
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int height(TreeNode root){
        if(root == null) return 0;

        int lh = height(root.left);
        int rh = height(root.right);

        return Math.max(lh, rh) + 1;
    }

    public static int diameter(TreeNode root){
        if(root == null) return 0;

        int leftDiam = diameter(root.left);
        int leftHeight = height(root.left);

        int rightDiam = diameter(root.right);
        int rightHeight = height(root.right);

        int selfDiam = leftHeight + rightHeight + 1;

        return Math.max(selfDiam, Math.max(leftDiam, rightDiam));

    }

    public static void main(String[] args) {
        
        /*
                 1
                / \
               2   3
              / \
             4   5
            / \
           6   7
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.left.left.left = new TreeNode(6);
        root.left.left.right = new TreeNode(7);

        System.out.println("Diameter = " + diameter(root));
    }

}