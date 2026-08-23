import java.util.*;

public class AddTwoInteger {

    public static int getSum(int a, int b) {
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }

        return a;
    }

    public static void main(String[] args) {
        int a = 5;
        int b = 7;

        int result = getSum(a, b);

        System.out.println("Sum = " + result);
    }
}