import java.util.*;

public class Leetcode344 {

    public void reverseString(char[] s) {
        Stack<Character> stack = new Stack<>();

        // Push all characters onto the stack
        for (char ch : s) {
            stack.push(ch);
        }

        // Pop characters back into the array
        int i = 0;
        while (!stack.isEmpty()) {
            s[i] = stack.pop();
            i++;
        }
    }

    public static void main(String[] args) {
        Leetcode344 obj = new Leetcode344();

        char[] arr = {'h', 'e', 'l', 'l', 'o'};

        System.out.println("Before Reverse:");
        System.out.println(Arrays.toString(arr));

        obj.reverseString(arr);

        System.out.println("After Reverse:");
        System.out.println(Arrays.toString(arr));

        // Print as a string
        System.out.println(new String(arr));
    }
}