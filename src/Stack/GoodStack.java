//https://leetcode.com/problems/make-the-string-great/submissions/832921841/
package Stack;
import java.util.*;
public class GoodStack
{
    public static void main(String[] args)
    {

    }
    public String makeGood(String s)
    {
        Stack<Character> stack=new Stack<>();
        StringBuilder res=new StringBuilder();
        for(char ch:s.toCharArray())
        {
            if(!stack.isEmpty()&&Math.abs(stack.peek()-ch)==32)
                stack.pop();
            else
                stack.push(ch);
        }
        for(char ch:stack)
        {
            res.append(ch);
        }
        return res.toString();

    }
}
