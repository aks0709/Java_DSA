package Company.Accenture;

import Hashing.HashSets;

import java.util.HashSet;

public class StringDeletion {
    public static void main(String[] args) {
        String s1 = "AABBCCDD";
        String s2 = "ABE";
        HashSet<Character> set = new HashSet<>();

        // Add characters from s2 to the set
        for (Character ch : s2.toCharArray()) {
            set.add(ch);
        }

        StringBuilder res = new StringBuilder();

        // Construct the result string by skipping characters present in the set
        for (Character ch : s1.toCharArray()) {
            if (!set.contains(ch)) {
                res.append(ch);
            }
        }

        System.out.println(res.toString()); // Output should be "CCDD"
    }

}
