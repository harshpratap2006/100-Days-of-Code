import java.util.Scanner;

public class Leetcode7 {

    public static int reverse(int x) {
        int rev = 0;

        while (x != 0) {
            int digit = x % 10;
            x /= 10;

            // Check for overflow
            if (rev > Integer.MAX_VALUE / 10 || 
               (rev == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }

            // Check for underflow
            if (rev < Integer.MIN_VALUE / 10 || 
               (rev == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }

            rev = rev * 10 + digit;
        }

        return rev;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input integer
        int x = sc.nextInt();

        // Reverse integer
        int result = reverse(x);

        // Output
        System.out.println(result);

        sc.close();
    }
}