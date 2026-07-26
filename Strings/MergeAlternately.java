package Strings;

public class MergeAlternately {
    public static void main(String[] args) {
        System.out.println(mergeAlternately("abc", "pqr"));
    }

    public static String mergeAlternately(String word1, String word2) {
        int i = 0;
        StringBuilder s = new StringBuilder();

        while (i < word1.length() && i < word2.length()) {
            System.out.println(s);
            s.append(word1.charAt(i));
            s.append(word2.charAt(i));
            i++;
        }

        if (i < word1.length()) {
            s.append(s.substring(i, word1.length()));
        }

        if (i < word2.length()) {
            s.append(s.substring(i, word2.length()));
        }

        System.out.println(s);
        return s.toString();
    }
}
