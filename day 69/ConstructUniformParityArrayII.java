public class ConstructUniformParityArrayII {

    public static boolean canConstruct(int[] nums1) {

        int minOdd = Integer.MAX_VALUE;

        // Find the smallest odd number
        for (int num : nums1) {
            if (num % 2 != 0) {
                minOdd = Math.min(minOdd, num);
            }
        }

        // If there is no odd number,
        // all numbers are already even
        if (minOdd == Integer.MAX_VALUE) {
            return true;
        }

        // Every even number must be greater than
        // the smallest odd number
        for (int num : nums1) {
            if (num % 2 == 0 && num <= minOdd) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 4, 7};

        System.out.println(canConstruct(nums1));
    }
}