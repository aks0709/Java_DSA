package LinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TejasBIRO
{
    public static int printIndex(int [] Q,int N,int X){
        int x=0;

        //
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<N;i++)
            list.add(Q[i]);

        int index=0;
        while(list.size()>1){
            index=(index+(X-1))%list.size();
            list.remove(index);
        }
        int E=list.get(0);
        for(int i=0;i<N;i++)
        {
            if(Q[i]==E)
                x=i;
        }
        //

        return x;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N= sc.nextInt();
        int[] Q=new int[N];
        for(int i=0;i<N;i++){
            Q[i]=sc.nextInt();
        }
        int x=sc.nextInt();
        System.out.println(printIndex(Q,N,x));
    }
}
