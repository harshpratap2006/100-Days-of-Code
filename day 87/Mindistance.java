class Mindistance {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static Node lca(Node root, Node p, Node q) {

        if (root == null || root == p || root == q) {
            return root;
        }

        Node leftLca = lca(root.left, p, q);
        Node rightLca = lca(root.right, p, q);

        if (leftLca == null) {
            return rightLca;
        } else if (rightLca == null) {
            return leftLca;
        } else {
            return root;
        }
    }

    static int findDistance(Node root, Node target) {

        if (root == null) {
            return -1;
        }

        if (root == target) {
            return 0;
        }

        int leftDistance = findDistance(root.left, target);

        if (leftDistance != -1) {
            return leftDistance + 1;
        }

        int rightDistance = findDistance(root.right, target);

        if (rightDistance != -1) {
            return rightDistance + 1;
        }

        return -1;
    }

    static int minDistance(Node root, Node p, Node q) {

        Node lcaNode = lca(root, p, q);

        int distanceP = findDistance(lcaNode, p);
        int distanceQ = findDistance(lcaNode, q);

        return distanceP + distanceQ;
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

        Node p = root.left.left;   // 4
        Node q = root.right;  // 3

        int distance = minDistance(root, p, q);

        System.out.println(
            "Minimum distance between " + p.data +
            " and " + q.data + " is: " + distance
        );
    }
}