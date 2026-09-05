import java.util.LinkedList;
import java.util.Queue;

public class Tree {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static void levelOrder(Node root) {

        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();

        // Add root to queue
        queue.add(root);

        while (!queue.isEmpty()) {

            // Remove front node
            Node current = queue.poll();

            // Print current node
            System.out.print(current.data + " ");

            // Add left child
            if (current.left != null) {
                queue.add(current.left);
            }

            // Add right child
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    public static void main(String[] args) {

        Node root = new Node(10);

        root.left = new Node(20);
        root.right = new Node(30);

        root.left.left = new Node(40);
        root.left.right = new Node(50);

        root.right.left = new Node(60);

        root.right.right = new Node(70);

        levelOrder(root);
    }
}