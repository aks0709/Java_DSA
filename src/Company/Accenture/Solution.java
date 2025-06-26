package Company.Accenture;

import java.util.*;

public class Solution {
    static void groupAnagrams(String[] fileNames, int n) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word : fileNames) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);

            map.putIfAbsent(sortedWord, new ArrayList<>());
            map.get(sortedWord).add(word);
        }

        // Sorting the groups lexicographically by their first element
        List<List<String>> result = new ArrayList<>(map.values());
        result.sort(Comparator.comparing(group -> group.get(0)));

        for (List<String> group : result) {
            System.out.println(String.join(" ", group));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        String[] fileNames = sc.nextLine().split(" ");

        groupAnagrams(fileNames, n);
    }
}

