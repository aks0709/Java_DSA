package Stack;

import java.util.Stack;

public class ReverseStack
{
    public static void main(String[] args)
    {
        Stack<Integer> s=new Stack<>();
        Stack<Character> s1=new Stack<>();
        Stack<Character> rs=new Stack<>();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);
        reverse(s);
        while (!s.isEmpty())
        {
            System.out.println(s.peek());
            s.pop();
        }
/*
        s1.push('H');
        s1.push('F');
        s1.push('V');
        s1.push('X');
        s1.push('E');
        s1.push('A');
        s1.push('Z');
        Stack<Character> ans=reverseStack(s1,rs);
        while (!ans.isEmpty())
        {
            System.out.println(s.peek());
            s.pop();
        }

 */

    }
    //our approach is to reverse a stack using recursion
    //breaking problem into smaller problem that is for example we have stack of 3 elements
    //so first we reverse make it simpler by reverse 2 elements stack
    //in a same way we reverse a stack of single element
    //in a same way we reverse a stack of no element
    //then we push data at the bottom using pushAtbottom method
    public static void reverse(Stack<Integer> s)
    {
        if (s.isEmpty())
            return;

        int top=s.pop();  //pop first element and reverse remaining stack
        reverse(s);
        pushAtBottom(s,top);
    }

    public static void pushAtBottom(Stack<Integer> s,int data)
    {
        if (s.isEmpty())
        {
            s.push(data);
            return;
        }

        int top=s.pop();
        pushAtBottom(s,data);
        s.push(top);
    }

    //method 2 using another stack
   /* public static Stack<Character> reverseStack(Stack<Character> s,Stack<Character> rs)
    {
     while (!s.isEmpty())
     {
         char top=s.pop();
         rs.push(top);
     }
     return rs;
    }
    */
}
