package preRequisites.slidingWindow_TwoPointers;
import java.util.HashMap;
import java.util.Map;
public class minimumWindowSubstring {

    class Solution {
        public String minWindow(String s, String t) {
            if (s == null || s.length() == 0 || t == null || t.length() == 0) return "";

            int l = 0, r = 0, minLen = Integer.MAX_VALUE, start = 0;
            HashMap<Character, Integer> map = new HashMap<>();
            for (char ch : t.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }

            int count = 0; // Number of characters matched in t

            while (r < s.length()) {
                char ch = s.charAt(r);
                if (map.containsKey(ch)) {
                    map.put(ch, map.get(ch) - 1);
                    if (map.get(ch) >= 0) { // Count only valid characters
                        count++;
                    }
                }

                while (count == t.length()) {
                    if (r - l + 1 < minLen) {
                        minLen = r - l + 1;
                        start = l;
                    }
                    char leftChar = s.charAt(l);
                    if (map.containsKey(leftChar)) {
                        map.put(leftChar, map.get(leftChar) + 1);
                        if (map.get(leftChar) > 0) { // Means it's a necessary character
                            count--;
                        }
                    }
                    l++;
                }
                r++;
            }

            return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
        }
    }
}
