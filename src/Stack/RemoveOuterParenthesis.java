package Stack;
//https://leetcode.com/problems/remove-outermost-parentheses/submissions/832673997/
import java.util.Stack;
public class RemoveOuterParenthesis
{
    public static void main(String[] args)
    {
        String str="((()))";
        System.out.println(removeOuterParentheses(str));
        System.out.println(removeOuterParentheses2(str));

    }
    static String removeOuterParentheses(String s)
    {
        Stack<Character> stack=new Stack<>();
        String res="";
        for(char ch: s.toCharArray())
        {
            if(ch=='('&&stack.isEmpty())//it means '(' it is outer bracket
            {
                stack.push(ch);
            }
            else
            {
                if(ch=='('&&!stack.isEmpty())   //it means it is not an outer bracket it is inner bracket
                {
                    stack.push(ch);
                    res=res+ch;
                }

                else
                {
                    if(ch==')'&&stack.size()>1)  //if stack size>1 it means there are multiple elements in stack
                    {
                        res=res+ch;
                        stack.pop(); //pop the element'(' after one succesfull '()' bracket in string res

                    }
                    else
                    {
                        if(ch==')'&&stack.size()==1)
                        {
                            stack.pop(); //it means it is an outer element pop it out
                        }
                    }

                }
            }

        }
        return res;

    }
    static StringBuilder removeOuterParentheses2(String s) //using string builder
    {
        Stack<Character> stack=new Stack<>();
        StringBuilder res=new StringBuilder();
        for(char ch: s.toCharArray())
        {
            if(ch=='('&&stack.isEmpty())//it means '(' it is outer bracket
            {
                stack.push(ch);
            }
            else
            {
                if(ch=='('&&!stack.isEmpty())   //it means it is not an outer bracket it is inner bracket
                {
                    stack.push(ch);
                    res.append(ch);
                }

                else
                {
                    if(ch==')'&&stack.size()>1)  //if stack size>1 it means there are multiple elements in stack
                    {
                        res.append(ch);
                        stack.pop(); //pop the element'(' after one succesfull '()' bracket in string res

                    }
                    else
                    {
                        if(ch==')'&&stack.size()==1)
                        {
                            stack.pop(); //it means it is an outer element pop it out
                        }
                    }

                }
            }

        }
        return res;

    }

}
