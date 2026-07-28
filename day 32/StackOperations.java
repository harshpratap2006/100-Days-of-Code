import java.util.Scanner;
import java.util.Stack;

public class StackOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read number of elements to push
        int n = sc.nextInt();

        Stack<Integer> stack = new Stack<>();

        // Push elements into stack
        for (int i = 0; i < n; i++) {
            stack.push(sc.nextInt());
        }

        // Read number of pop operations
        int m = sc.nextInt();

        // Perform pop operations
        for (int i = 0; i < m; i++) {
            if (!stack.isEmpty()) {
                stack.pop();
            }
        }

        // Print remaining elements from top to bottom
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

        sc.close();
    }
}