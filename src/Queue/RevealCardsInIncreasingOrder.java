package Queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class RevealCardsInIncreasingOrder {
    public static void main(String[] args) {

    }
    public int[] Reorder(int deck[])
    {
        int ans[]= new int[deck.length];
        Arrays.sort(deck);
        Deque<Integer> deque=new ArrayDeque<>();
        for (int i=0;i<deck.length;i++)  //we store indexes
        {
            deque.add(i);
        }
        //we observe that elements on indexes 0,2,4,6...... are in sorted way
        for(int card:deck)
        {
            ans[deque.pollFirst()]=card;
            if(!deque.isEmpty())
            {
                deque.add(deque.pollFirst());
            }
        }
        return ans;
    }
}
