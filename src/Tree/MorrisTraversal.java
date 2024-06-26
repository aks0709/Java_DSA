package Tree;

import java.util.LinkedList;
import java.util.List;

public class MorrisTraversal
{
    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    public static void main(String[] args) {

    }
    //main purpose of morris traversal is it O(1) space complexity
    public static List<Integer> InOrderMorrisTraversal(TreeNode root)
    {
        List<Integer> ans=new LinkedList<>();
        TreeNode curr=root;

        //inorder traversal is lRr
        if(curr.left==null)   //if left is null it means you currently standing at root
        {
            ans.add(curr.data); //so add tha root value
            curr=curr.right;  //and go to right
        }
        else  //it means left exsist
        {
            TreeNode prev=curr.left;
            //we go left and traverse to the right most node
            //concept of threaded binary tree
            while (prev.right!=null&&prev.right!=curr)
            {
                prev=prev.right;
            }

            if(prev.right==null)
            {
                prev.right=curr; //if prev.right==null then make a thread from rightmost node of subtree to root
                curr=curr.left;  //then move curr to its next
            }
            else  //it means prev.right==curr
            {
                prev.right=null;  //since thread already exsist so remove the thread
                ans.add(curr.data); //it means you already traversed left now you are at root
                curr=curr.right;  //now move to its right
            }
        }
        return ans;


    }
}
