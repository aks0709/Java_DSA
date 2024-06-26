package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class TimeNeededToBuyTickets
{
    public static void main(String[] args)
    {
        int arr[]={5,1,1,1};
        int ans=TimeNeeded(arr,0);
        System.out.println(ans);

    }
    static int TimeNeeded(int tickets[],int k)
    {        Queue<Integer> q = new LinkedList<>();
        for ( int i = 0; i < tickets.length; i++)  //we add index instead of element so that we access the tickets array later on
        {
            q.add(i);
        }
        int count = 0;
        while(!q.isEmpty()){
            ++count;
            int front = q.poll();
            if(tickets[front] >= 1){
                tickets[front] -= 1;
            }
            if(k == front && tickets[front] == 0){
                break;
            }
            if(k != front && tickets[front] == 0){
                continue;
            }
            q.add(front);
        }
        return count;
    }
}
