package preRequisites.slidingWindow_TwoPointers;

import java.util.Arrays;

public class PlayersTrainerMatchingLeetcode {
    class Solution {
        public int matchPlayersAndTrainers(int[] players, int[] trainers) {
            Arrays.sort(players);
            Arrays.sort(trainers);
            int i=players.length-1;
            int j=trainers.length-1;
            int count=0;
            while(i>=0 && j>=0){
                if(players[i]<=trainers[j]){
                    j--;
                    count++;
                }
                i--;
            }
            return count;
        }
    }
}
