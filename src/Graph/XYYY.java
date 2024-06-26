package Graph;

import java.util.Scanner;

public class XYYY
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T= sc.nextInt();
        for (int p=1;p<=T;p++)
        {
            int N= sc.nextInt();
            String str=sc.next();
            StringBuilder sb=new StringBuilder(str);
            int i=0;
            int count=0;
            while(i<sb.length()&&i+1<sb.length())
            {
                if(sb.length()==0)
                    break;
                if(sb.length()==1)
                    break;
                if((sb.length()==2&&(sb.charAt(i)==sb.charAt(i+1))))
                    break;

                if(sb.charAt(i)!=sb.charAt(i+1))
                {
                    sb.delete(i,(i+1)+1);
                    count++;
                    i=-1;
                }

                i++;
            }
            if(count%2==0)
                System.out.println("Ramos");
            else
                System.out.println("Zlatan");
        }
    }
}
