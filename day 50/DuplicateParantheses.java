import java.util.Stack;

class DuplicateParantheses{
    public static boolean hasDuplicateParentheses(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            //closing
            if (ch == ')') {
                int count = 0;
                while (s.peek() != '(') {
                    s.pop();
                    count++;
                }
                if (count < 1) {
                    return true;
                } else {
                    s.pop();
                }
            } else {// opening
                s.push(ch);
                }
        }
        return false;
    }
    public static void main(String[] args) {
        String str1 = "((a+b))";
        System.out.println(hasDuplicateParentheses(str1)); // true
        String str2 = "((a+b)+c)";
        System.out.println(hasDuplicateParentheses(str2)); // false
    }
}