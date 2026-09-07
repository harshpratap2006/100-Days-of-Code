class CountNodes {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }

    public static int countNodes(Node root ){
        if(root == null) return 0;

        int leftNodeCount = countNodes(root.left);
        int rightNodeCount = countNodes(root.right);

        return leftNodeCount+rightNodeCount+1;
    }

    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(countNodes(root));

    }
}