package Stack;

import java.util.Stack;

public class MinBracketReversal
{
    public static void main(String[] args)
    {

        String str="{}}{";
        System.out.println(NoOfBracketReversal(str));

    }
    static int NoOfBracketReversal(String str)
    {
        if (str.length()%2==1)//no of open braces should be equal to no of even braces ,if str is of odd length then it is not possible
        {
            return -1;
        }
        Stack<Character> stack=new Stack<>();
        for(char ch:str.toCharArray())
        {
            if (ch=='{')
            {
                stack.push(ch);
            }
            else //ch is closed brace
            {
                if(!stack.isEmpty()&&stack.peek()=='{')
                {
                    stack.pop();//pop the valid part
                }
                else
                {
                    stack.push(ch);
                }

            }
        }
        //now we have invalid part of string in a stack valid part is already removed

        int a=0;//count for no of open brace
        int b=0;//count for no of close brace
        /*
        Types of Invalid String
        1. {{{{{{.....  a=some number,b=0
        2. }}}}}}.....  a=0,b=some number
        in both 1 and 2 nd case no of braces should be even
        3.(i)
        }}}{{{  a=odd,b==odd
        3.(ii)
        }}}}{{{{  a=even,b=evem

        as odd+odd=even
        even+even=even
        no space for odd length string

        on dry run you notice you get answer by a+1/2  + b+1/2
        */
        while (!stack.isEmpty())
        {
            if (stack.peek()=='{')
                a++;
            else
                b++;

            stack.pop();
        }
        int ans=(a+1)/2+(b+1)/2;
                return ans;

    }
}
