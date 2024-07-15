package preRequisites.slidingWindow_TwoPointers;

public class LongestRepeatingCharacterReplacement {
    //O(N+N)*26
    class Solution {
        public int characterReplacement(String s, int k) {
            int l=0,r=0,maxLen=0,maxFreq=0;
            int HashArr[]=new int[26];  //only26 english letters
            while(r<s.length()){
                HashArr[s.charAt(r)-'A']++; //count occurence of each character
                maxFreq=Math.max(maxFreq,HashArr[s.charAt(r)-'A']);

                //no of switching req=currLen-maxFreq
                //for eg AAABC maxfreq=3 i.e A so we have to change B,C to A
                //5-3=2 two operation required
                //handle the case when we no of changing operation exceed k
                while((r-l+1)-maxFreq>k)  //this inner while loop goes overall N,no individual N
                {
                    HashArr[s.charAt(l)-'A']--; maxFreq=0;
                    for(int i=0;i<25;i++) maxFreq=Math.max(maxFreq,HashArr[i]);
                    l++;
                }
                //if everyhing under control just simply update maxlength
                if((r-l+1)-maxFreq<=k)
                    maxLen=Math.max(maxLen,r-l+1);

                r++;
            }
            return maxLen;
        }
    }

    //O(N) solution
    class Solution2 {
        public int characterReplacement(String s, int k) {
            int l=0,r=0,maxLen=0,maxFreq=0;
            int HashArr[]=new int[26];  //only26 english letters
            while(r<s.length()){
                HashArr[s.charAt(r)-'A']++; //count occurence of each character
                maxFreq=Math.max(maxFreq,HashArr[s.charAt(r)-'A']);

 //handle the case when we no of changing operation exceed k
                //optimize using if instead of while
                if((r-l+1)-maxFreq>k){
                    HashArr[s.charAt(l)-'A']--; maxFreq=0;
                    //for(int i=0;i<25;i++) maxFreq=Math.max(maxFreq,HashArr[i]);  //there is no need to update maxFreq everytime
                    l++;
                }

                //if everyhing under control just simply update maxlength
                if((r-l+1)-maxFreq<=k)
                    maxLen=Math.max(maxLen,r-l+1);

                r++;
            }
            return maxLen;
        }
    }
}
