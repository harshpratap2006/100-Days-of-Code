public class Leetcode189 {

    public static void reverseArray(int[] arr, int start, int end){
        
        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void rotateArray(int[] arr, int k){
        int n = arr.length;
        k = k % n; // Handle cases where k is larger than the array length
        if (arr == null || arr.length == 0) {
            return;
        }
        reverseArray(arr, 0, n-1);

        reverseArray(arr, 0, k-1);

        reverseArray(arr, k, n-1); 
        
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
            
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        rotateArray(arr,1);
    }
}
