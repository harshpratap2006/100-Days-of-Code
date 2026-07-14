/*
Problem: Given an array of integers, rotate the array to the right by k positions.

Input:
- First line: integer n
- Second line: n integers
- Third line: integer k

Output:
- Print the rotated array

Example:
Input:
5
1 2 3 4 5
2

Output:
4 5 1 2 3 
*/
import java.util.Scanner;
class RotateArray{
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

        // reverse whole array
        reverseArray(arr, 0, n-1);

        // reverse first half
        reverseArray(arr, 0, k-1);

        // reverse reamaining part
        reverseArray(arr, k, n-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // array input 
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // taking k as input
        int k = sc.nextInt();
        
        rotateArray(arr, k);
        sc.close();
    }
}