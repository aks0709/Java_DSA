package Stack;

import java.util.Stack;

//https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
public class RemoveAdjacentDuplicatesInString
{
    public static void main(String[] args)
    {
        String str="azxxzy";
        System.out.println(removeDuplicates(str));
        System.out.println(removeDuplicates2(str));

    }
    static StringBuilder removeDuplicates(String s)
    {
        Stack<Character> stack=new Stack<>();
        StringBuilder res=new StringBuilder();

        for(char ch: s.toCharArray())
        {
            if (stack.isEmpty())
            {
                stack.push(ch);
            }
            else {
                char top=stack.peek();
                if(ch==top)
                {
                    stack.pop();
                }
                else
                {
                    stack.push(ch);
                }
            }
        }
        while (!stack.isEmpty())
        {
            res.append(stack.peek());
            stack.pop();
        }
        StringBuilder res2=res.reverse();

        return res2;
    }
    static String removeDuplicates2(String s)
    {
        Stack<Character> stack=new Stack<>();
        String res="";

        for(char ch: s.toCharArray())
        {
            if (stack.isEmpty())
            {
                stack.push(ch);
            }
            else {
                char top=stack.peek();
                if(ch==top)
                {
                    stack.pop();
                }
                else
                {
                    stack.push(ch);
                }
            }
        }
        while (!stack.isEmpty())
        {
            res=res+stack.peek();
            stack.pop();
        }
        char arr[]=res.toCharArray();
        String res2="";
        for (int i=res.length()-1;i>=0;i--)
        {
            res2=res2+arr[i];
        }
        return res2;
    }

}
