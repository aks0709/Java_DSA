package Queue;

import java.util.LinkedList;
import java.util.*;

public class GenerateBinaryNumber1toN
{
    public static String[] generateBinary(int n)
    {
        String[] result=new String[n];
        Queue<String> q=new LinkedList<>();
        //we need to generate binary number from 1 to n
        //so our first element is 1 in  binary
        q.add("1");

        //logic is binary no. are generated in a way like
        /*
        * 1=1
        * 10=2 ="1"+"0"
        * 11=3 ="1"+"1"
        * so on observation we see 2,3 are obtained on appending 0 and 1 on 1
        * 100=4 "10"+"0"
        * 101=5 "10"+"1"
        * 110=6 "11"+"0"
        * 111=7 "11"+"1"
        * on observation we see 4,5 are obtained on appending 0 and 1 in "10" i.e, is 2
        * on observation we see 6,7 are obtained on appending 0 and 1 in "11" i.e, is 3
        * we know Queue is FIFO Data structure
        * sequential order is maintained by using queue
        * i=0
        * res[i]=1 initially
        *  n1=res[i]+"0"=10
        * n2=res[i]+"1"=11
        * n1,n2 is pushed in queue
        * now on increment of i
        * res[i]=10
        * now we generate binary numbers using 10 and push sequentially in queue
        * then again on increasing i we get res[i]=11
        * then we generate binary numbers using 11 and push sequentially in queue*/
        for (int i=0;i<n;i++)
        {
            result[i]=q.remove();
            String n1=result[i]+"0";
            String n2=result[i]+"1";
            q.add(n1);
            q.add(n2);
        }
        return result;
    }
    public static void main(String[] args)
    {
        System.out.println(Arrays.toString(generateBinary(10)));

    }
}
