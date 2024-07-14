package preRequisites.slidingWindow_TwoPointers;

import java.util.HashMap;
import java.util.Map;

public class MaxFruitsInBasket {
    //Better O(2N) solution  remove the while loop by if to make it optimise O(N)
    class Solution {
        public int totalFruit(int[] fruits) {
            Map<Integer,Integer> map=new HashMap<>();
            int l=0;
            int r=0;
            int maxLen=0;
            while(r<fruits.length){
                if(map.containsKey(fruits[r]))
                    map.put(fruits[r],map.get(fruits[r])+1);
                else
                    map.put(fruits[r],1);

                if(map.size()<=2){
                    maxLen=Math.max(maxLen,r-l+1); //update max Length only if valid window
                }
                else{
                    //if size of bucket(map) exceeds 2 we adjust it by shrinking the window
                    while(map.size()!=2){
                        map.put(fruits[l],map.get(fruits[l]-1));
                        if(map.get(fruits[l])==0)
                            map.remove(fruits[l]);
                        l++;
                    }
                }
                r++;
            }
            return maxLen;
        }
    }
}
