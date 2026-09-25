class SearchInBst{
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

    public static Boolean search(Node root, int key){
        if(root == null){
            return false;
        }

        if(root.data == key){
            return true;
        }

        if(key < root.data){
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(7);
        root.left.left = new Node(2);
        root.left.right = new Node(4);

        /*
                5
               / \
              3   7
             / \
            2   4
        */

        int key = 4;
        if(search(root, key)){
            System.out.println(key + " is present in the BST.");
        } else {
            System.out.println(key + " is not present in the BST.");
        }

    }
}