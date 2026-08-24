import java.util.*;
public class FirstNonRepeatingLetter {
    // Method 1: Using Frequency Array
    public static int firstUniqCharUsingArray(String s) {

        int[] freq = new int[26];

        // Count frequency
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        // Find first character with frequency 1
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }


    // Method 2: Using Frequency Array + Queue
    public static int firstUniqCharUsingQueue(String s) {

        int[] freq = new int[26];
        Queue<Integer> q = new LinkedList<>();

        // Count frequency and store indices
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            freq[ch - 'a']++;
            q.add(i);
        }

        // Remove indices whose characters are repeated
        while (!q.isEmpty() && freq[s.charAt(q.peek()) - 'a'] > 1) {
            q.remove();
        }

        if (q.isEmpty()) {
            return -1;
        }

        return q.peek();
    }


    // Main function
    public static void main(String[] args) {

        String s = "leetcode";

        System.out.println("Using Frequency Array: "
                + firstUniqCharUsingArray(s));

        System.out.println("Using Frequency Array + Queue: "
                + firstUniqCharUsingQueue(s));
    }
}
