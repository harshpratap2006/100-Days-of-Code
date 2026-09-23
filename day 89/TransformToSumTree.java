class TransformToSumTree {
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    public static int toSumTree(Node root){
        if (root == null) {
            return 0;
        }

        int leftChild = toSumTree(root.left);
        int rightChild = toSumTree(root.right);

        int data = root.data;

        int newLeft = root.left == null ? 0 : root.left.data;
        int newRight = root.right == null ? 0 : root.right.data;

        root.data = newLeft + leftChild + newRight + rightChild;

        return data;

    }

    public static void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void main(String[] args) {
        /*
                 1
                / \
               2   3
              / \ / \
             4  5 6  7
        */

        // output sould be
        /*
                 27
                / \
               9   13
              / \ / \
             0  0 0  0
         */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("Pre-order traversal before transformation:");
        preOrder(root);

        toSumTree(root);

        System.out.println("\nPre-order traversal after transformation:");
        preOrder(root);
    }
}
