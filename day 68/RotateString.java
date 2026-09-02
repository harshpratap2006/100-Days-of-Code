public class RotateString {

    public static boolean rotateString(String s, String goal) {

        if (s.length() != goal.length()) {
            return false;
        }

        String temp = s + s;

        return temp.contains(goal);
    }

    public static void main(String[] args) {

        String s = "abcde";
        String goal = "cdeab";

        boolean result = rotateString(s, goal);

        System.out.println(result);
    }
}