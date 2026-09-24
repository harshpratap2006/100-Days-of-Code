class Bst{
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node insert(Node root, int data){
        if(root == null){
            return new Node(data);
        }

        if(data < root.data){
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }

        return root;
    }

    public static void inOrder(Node root){
        if(root == null){
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        int values[] = { 5,1,3,4,2,7};
        Node root = null;

        for(int value : values){
            root = insert(root, value);
        }

        System.out.println("In-order traversal:");
        inOrder(root);
    }
}