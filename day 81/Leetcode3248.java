import java.util.*;

public class Leetcode3248 {

    public static int finalPositionOfSnake(int n, List<String> commands) {

        int row = 0;
        int col = 0;

        for (String command : commands) {

            if (command.equals("UP")) {
                row--;
            } 
            else if (command.equals("RIGHT")) {
                col++;
            } 
            else if (command.equals("DOWN")) {
                row++;
            } 
            else if (command.equals("LEFT")) {
                col--;
            }
        }

        return row * n + col;
    }

    public static void main(String[] args) {

        int n = 2;

        List<String> commands = Arrays.asList(
                "RIGHT",
                "DOWN"
        );

        int result = finalPositionOfSnake(n, commands);

        System.out.println("Final position: " + result);
    }
}