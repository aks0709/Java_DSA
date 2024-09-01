package Company.Accenture;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacter {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0;  // Corrected variable name

        while (r < s.length()) {
            char currentChar = s.charAt(r);

            // Check if the current character is in the map and its index is within the current window
            if (map.containsKey(currentChar) && map.get(currentChar) >= l) {
                l = map.get(currentChar) + 1;  // Update the left pointer to skip the repeating character
            }

            // Update the map with the current character's latest index
            map.put(currentChar, r);

            // Calculate the maximum length
            maxLength = Math.max(maxLength, r - l + 1);

            // Move the right pointer to the next character
            r++;
        }

        return maxLength;
    }
}
