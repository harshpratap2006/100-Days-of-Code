public class Leetcode2129 {

    public String capitalizeTitle(String title) {
        String[] words = title.split(" ");
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            if (word.length() <= 2) {
                ans.append(word.toLowerCase());
            } else {
                ans.append(Character.toUpperCase(word.charAt(0)));
                ans.append(word.substring(1).toLowerCase());
            }

            if (i != words.length - 1) {
                ans.append(" ");
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        Leetcode2129 obj = new Leetcode2129();

        String title1 = "capiTalIze tHe titLe";
        String title2 = "First leTTeR of EACH Word";
        String title3 = "i lOve leetcode";

        System.out.println(obj.capitalizeTitle(title1));
        System.out.println(obj.capitalizeTitle(title2));
        System.out.println(obj.capitalizeTitle(title3));
    }
}