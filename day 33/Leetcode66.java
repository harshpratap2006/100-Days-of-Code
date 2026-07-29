import java.util.Scanner;

public class Leetcode66 {

    public static int[] plusOne(int[] digits) {

        // Traverse from the last digit
        for (int i = digits.length - 1; i >= 0; i--) {

            // If digit is less than 9, increment and return
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            // If digit is 9, make it 0 and continue
            digits[i] = 0;
        }

        // If all digits are 9, create a new array
        int[] result = new int[digits.length + 1];
        result[0] = 1;

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of digits
        int n = sc.nextInt();

        int[] digits = new int[n];

        // Input digits
        for (int i = 0; i < n; i++) {
            digits[i] = sc.nextInt();
        }

        // Call function
        int[] answer = plusOne(digits);

        // Print result
        System.out.print("[");
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i]);
            if (i != answer.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        sc.close();
    }
}
