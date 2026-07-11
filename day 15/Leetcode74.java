/*You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity. */

public class Leetcode74 {
    public boolean searchMatrix(int[][] matrix, int target) {

        // // Brute Force Approach
        // int rows = matrix.length , cols = matrix[0].length;
        // for(int r=0; r<rows; r++){
        //     for(int c=0; c<cols; c++){
        //         if(matrix[r][c] == target) return true;
        //     }
        // }
        // return false;

        // Binary search Approach
        int rows = matrix.length , cols = matrix[0].length;
        for(int r=0; r<rows; r++){
            int left = 0, right = cols-1;
            while(left<=right){
                int mid = (left+ right) / 2;
                if(matrix[r][mid] == target) return true;
                else if(matrix[r][mid] < target) left = mid+1;
                else right = mid-1;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        Leetcode74 solution = new Leetcode74();

        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        int target = 113;
        System.out.println(solution.searchMatrix(matrix, target));
    }
}
