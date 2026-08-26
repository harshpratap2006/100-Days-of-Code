import java.util.LinkedList;
import java.util.Queue;

public class Interleave {
    public static void rearrangeQueue(Queue<Integer> q) {
        Queue<Integer> q1 = new LinkedList<>();

        int size = q.size();

        // Move first half into q1
        for (int i = 0; i < size / 2; i++) {
            q1.add(q.remove());
        }

        // Interleave elements
        while (!q1.isEmpty()) {
            q.add(q1.remove());
            q.add(q.remove());
        }
    }

    public static void main(String[] args) {

        Queue<Integer> q = new LinkedList<>();

        // Add elements
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);

        System.out.println("Original Queue: " + q);

        rearrangeQueue(q);

        System.out.println("Rearranged Queue: " + q);
    }
}
