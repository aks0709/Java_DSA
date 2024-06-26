package Stack;

import java.util.Stack;

public class ReddundantBrackets
{
    public static void main(String[] args)
    {
        String str="(a+b-(c/d))";
        if (isReddundantBrackets(str))
            System.out.println("yes");
        else
            System.out.println("no");

    }
    static boolean isReddundantBrackets(String str)
    {
        Stack<Character> stack=new Stack<>();
        for (char ch:str.toCharArray()) {
            if (ch == '(' || ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                stack.push(ch);
            } else
            {
                if (ch == ')')
                {
                    boolean isReddundant=true;
                    while (stack.peek()!='(') {
                        if (stack.peek() == '+' || stack.peek() == '-' || stack.peek() == '*' || stack.peek() == '/') {
                            isReddundant=false;
                        }
                        stack.pop();
                    }
                    if (isReddundant==true)
                        return true;
                    stack.pop();
                }
            }
        }
        return false;
    }
}
