import java.util.Arrays;

class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int[] answer = new int[2];

        while (left < right) {
            if ((numbers[left] + numbers[right]) == target) {
                answer[0] = left + 1;
                answer[1] = right + 1;
                break;
            } 
            else if ((numbers[left] + numbers[right]) > target) {
                right--;
            } 
            else {
                left++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        TwoSumII obj = new TwoSumII();

        int[] numbers = {2, 7, 11, 15};
        int target = 9;

        int[] result = obj.twoSum(numbers, target);

        System.out.println("Indices: " + Arrays.toString(result));
    }
}