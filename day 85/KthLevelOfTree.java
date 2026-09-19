import java.util.*;

class KthLevelOfTree {
    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    // Iterative approach to find the nodes at the kth level of a binary tree
    public static List<Integer> kthLevel(Node root, int level){
        int lvl = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        List<Integer> list = new ArrayList<>();

        while(!q.isEmpty()){
            int size = q.size();
            lvl++;

            for (int i = 0; i < size; i++) {

                Node currNode = q.remove();
                if(lvl == level){
                    list.add(currNode.val);
                }

                if (currNode.left != null) {
                    q.add(currNode.left);
                }

                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
        return list;
    }

    // Recursive approach to find the nodes at the kth level of a binary tree
    public static void kthLevelRecursive(Node root, int level, int k){
        if(root == null){
            return;
        }

        if(level == k){
            System.out.print(root.val + " ");
            return;
        }

        kthLevelRecursive(root.left, level + 1, k);
        kthLevelRecursive(root.right, level + 1, k);
    }

    public static void main(String[] args) {
        
        /*
                 1
                / \
               2   3
              / \
             4   5
        */

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        int level = 2;
        List<Integer> result = kthLevel(root, level);
        System.out.println("Nodes at level " + level + ": " + result);

        System.out.print("Nodes at level " + level + " (recursive): ");
        kthLevelRecursive(root, 1, level);
    }

}