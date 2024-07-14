package preRequisites.slidingWindow_TwoPointers;

public class NumberOfSubstringContainingALL3Character {
    class Solution {
        public int numberOfSubstrings(String s) {
            int l = 0;
            int count = 0;
            int[] freq = new int[3]; // To count occurrences of 'a', 'b', 'c'
            int n = s.length();

            for (int r = 0; r < n; r++) {
                freq[s.charAt(r) - 'a']++; // Increment count of current character in the window

                // Try to shrink the window from the left until it's no longer valid
                while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                    count += n - r; // All substrings ending at `r` and starting from `l` are valid
                    freq[s.charAt(l) - 'a']--; // Remove character at `l` from the window
                    l++; // Move left pointer to the right
                }
            }

            return count;
        }
    }

    //optimised O(N)
    class Solution2 {
        public int numberOfSubstrings(String s) {
            char arr[]=s.toCharArray();
            int ia=-1,ib=-1,ic=-1;
            int r=0;
            int count=0;
            while(r<s.length()){
                if(arr[r]=='a')
                    ia=r;
                else if(arr[r]=='b')
                    ib=r;
                else if(arr[r]=='c')
                    ic=r;

                if(ia!=-1 && ib!=-1 && ic!=-1){
                    int min=Math.min(ia,Math.min(ib,ic));
                    count+=min+1;
                }
                r++;
            }
            return count;
        }
    }
}
