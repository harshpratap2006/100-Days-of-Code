public class Leetcode2029 {
    public static boolean stoneGameIX(int[] stones) {
        int[] count = new int[3];

        for (int stone : stones) {
            count[stone % 3]++;
        }

        if (count[0] % 2 == 0) {
            return count[1] > 0 && count[2] > 0;
        }

        return Math.abs(count[1] - count[2]) > 2;
    }

    public static void main(String[] args) {
        int[] stones1 = {2, 1};
        System.out.println(stoneGameIX(stones1)); // true

        int[] stones2 = {2};
        System.out.println(stoneGameIX(stones2)); // false

        int[] stones3 = {5, 1, 2, 4, 3};
        System.out.println(stoneGameIX(stones3)); // false
    }
}