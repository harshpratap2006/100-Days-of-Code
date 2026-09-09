import java.util.*;

public class Leetcode3871 {

    public static long countCommas(long n) {
        long ans = 0;
        long start = 1000;
        long commas = 1;

        while (start <= n) {
            ans += n - start + 1;
            start *= 1000;
            commas++;
        }

        return ans;
    }

    public static void main(String[] args) {

        long n = 1002;

        long result = countCommas(n);

        System.out.println("Total commas: " + result);
    }
}