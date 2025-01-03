package preRequisites.slidingWindow_TwoPointers;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacter {
    /*
    Given a string s, find the length of the longest
substring
 without repeating characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.


Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
    */
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int l=0;
            int r=0;
            int maxLength=0;
            HashMap<Character,Integer> map=new HashMap<Character,Integer>();
            while(r<s.length()){
                if(map.containsKey(s.charAt(r))){
                    if(map.get(s.charAt(r))>=l){
                        l=map.get(s.charAt(r))+1;
                    }
                }
                maxLength=Math.max(maxLength,r-l+1);
                map.put(s.charAt(r),r);
                r=r+1;
            }
            return maxLength;
        }
    }
}
