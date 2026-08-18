import java.util.HashMap;

class RomanToInt {

    public static int romanToInt(String s) {
        HashMap<Character, Integer> rMap = new HashMap<>();

        rMap.put('I', 1);
        rMap.put('V', 5);
        rMap.put('X', 10);
        rMap.put('L', 50);
        rMap.put('C', 100);
        rMap.put('D', 500);
        rMap.put('M', 1000);

        int sum = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            char cch = s.charAt(i);
            char nch = s.charAt(i + 1);

            if (rMap.get(cch) < rMap.get(nch)) {
                sum -= rMap.get(cch);
            } else {
                sum += rMap.get(cch);
            }
        }

        sum += rMap.get(s.charAt(s.length() - 1));

        return sum;
    }

    public static void main(String[] args) {

        String s = "MCMXCIV";

        int result = romanToInt(s);

        System.out.println("Roman: " + s);
        System.out.println("Integer: " + result);
    }
}