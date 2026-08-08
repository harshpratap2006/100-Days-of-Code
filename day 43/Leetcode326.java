import java.util.Scanner;

public class Leetcode326 {

    public static boolean isPowerOfThree(int n) {

        // Powers of three must be positive
        if (n <= 0) {
            return false;
        }

        // Keep dividing by 3
        while (n % 3 == 0) {
            n = n / 3;
        }

        // If we reach 1, n was a power of 3
        return n == 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        int n = sc.nextInt();

        // Check whether n is a power of 3
        boolean result = isPowerOfThree(n);

        // Output
        System.out.println(result);

        sc.close();
    }
}