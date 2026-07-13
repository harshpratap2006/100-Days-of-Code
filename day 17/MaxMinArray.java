/*
Problem: Write a program to find the maximum and minimum values present in a given array of integers.

Input:
- First line: integer n
- Second line: n integers

Output:
- Print the maximum and minimum elements

Example:
Input:
6
3 5 1 9 2 8

Output:
Max: 9
Min: 1
 */

import java.util.Scanner;

public class MaxMinArray {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read the size of the array
        int n = sc.nextInt();

        // Create the array
        int[] arr = new int[n];

        // Read array elements
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Assume first element is both maximum and minimum
        int max = arr[0];
        int min = arr[0];

        // Find maximum and minimum
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }

            if (arr[i] < min) {
                min = arr[i];
            }
        }

        // Print the result
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);

        sc.close();
    }
}