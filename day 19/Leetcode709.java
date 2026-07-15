/*
Given a string s, return the string after replacing every uppercase letter with the same lowercase letter.

Example 1:

Input: s = "Hello"
Output: "hello"
*/

import java.util.Scanner;

class Leetcode709 {

    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            sb.append(Character.toLowerCase(s.charAt(i)));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = sc.nextLine();

        Leetcode709 obj = new Leetcode709();

        System.out.println("Lowercase String: " + obj.toLowerCase(s));

        sc.close();
    }
}
