package PP.Day9;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GenerateBinary
{
    class solve{

        //Function to generate binary numbers from 1 to N using a queue.
         ArrayList<String> generate(int N)
        {
            // Your code here
            int count=1;
            Queue<String> q=new LinkedList<>();
            q.add("1");
            ArrayList<String> res=new ArrayList<>();
            while(!q.isEmpty()&&count<=N){
                String temp=q.remove();
                res.add(temp);
                String str1=temp+"0";
                String str2=temp+"1";
                q.add(str1);
                q.add(str2);
                count++;
            }
            return res;
        }

    }

}
