package Tree;

import java.util.Stack;

public class FlattenBTToLL
{
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public static void main(String[] args) {

    }

    //approach1
    TreeNode prev=null;
    public void flatten(TreeNode root) {
        if(root==null)
            return;
        flatten(root.right);
        flatten(root.left);

        root.right=prev;
        root.left=null;
        prev=root;
    }

    //approach 2 stack approach

    public void flatten2(TreeNode root)
    {
        Stack<TreeNode> stack=new Stack<>();

        stack.push(root);
        while (!stack.isEmpty())
        {
            TreeNode curr=stack.pop();
            if(curr.right!=null)
                stack.push(curr.right);
            if(curr.left!=null)
                stack.push(curr.left);

            if(!stack.isEmpty())
            {
                curr.right=stack.peek();
                curr.left=null;
            }
        }
    }

    //approach 3 Morris Traversal O(1) S.C
    public void flatten3(TreeNode root)
    {
        TreeNode curr=root;

        while (curr!=null)
        {
            if(curr.left!=null)
            {
                TreeNode prev=curr.left;
                while (prev!=null)
                {
                    prev=prev.right;
                }
                prev.right=curr.right;
                curr.right=curr.left;
            }
            curr=curr.right;
        }
    }

}
