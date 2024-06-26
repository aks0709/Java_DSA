package Stack;

import java.util.Stack;

public class IterateStack
{
    public static void main(String[] args)
    {
        Stack<Character> stack=new Stack<>();
        Stack<Integer> stack2=new Stack<>();
        stack.push('a');
        stack.push('y');
        stack.push('u');
        stack.push('s');
        stack.push('h');
        StringBuilder str=new StringBuilder();
        for(char ch:stack)
        {
            str.append(ch);
        }
        while(!stack.isEmpty())
        {
            System.out.print(stack.peek()+" ");
            stack.pop();
        }
        System.out.println("\n"+str);
        stack2.push(5);
        stack2.push(34);
        stack2.push(54);
        stack2.push(23);
        stack2.push(67);

        StringBuilder str2=new StringBuilder();
        for(Integer i:stack2)  //Integer or int both are valid here
        {
            str2.append(i);
        }
        while(!stack2.isEmpty())
        {
            System.out.print(stack2.peek()+" ");
            stack2.pop();
        }

        System.out.println("\n"+str2);


    }

}
