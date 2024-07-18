package Tree.Revison;
import Tree.BinaryTree;

import java.util.*;
public class TreeTraversals {
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
  //PREORDER
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        preorder(root,ans);
        return ans;
    }
    static void preorder(TreeNode root,List<Integer> ans){
        if(root==null)
            return;

        ans.add(root.val);
        preorder(root.left,ans);
        preorder(root.right,ans);
    }

    //Iteratively
    public static void preorderIterative(TreeNode root){
        if(root==null) return;
        //first we insert right then left so that evaluation order according to LIFO is left then right
        Stack<TreeNode> st=new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode temp=st.pop();
            System.out.println(temp.val);
            if(temp.right!=null)
                st.push(temp.right);
            if(temp.left!=null)
                st.push(temp.left);
        }
    }

    //Inorder Traversal
    //left--->root--->right


    //Level Order Traversal
    public List<List<Integer>> levelOrder(TreeNode root) {

        Queue<TreeNode> q=new LinkedList();
        q.add(root);
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null) return ans;
        while(!q.isEmpty()){
            int len=q.size();
            List<Integer> li=new ArrayList<>();
            while(len-- > 0){
                TreeNode temp=q.poll();
                li.add(temp.val);
                if(temp.left!=null)
                    q.add(temp.left);

                if(temp.right!=null)
                    q.add(temp.right);
            }
            ans.add(li);
        }
        return ans;
    }


}
