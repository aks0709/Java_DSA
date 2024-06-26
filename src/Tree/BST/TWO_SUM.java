package Tree.BST;
import java.util.*;
public class TWO_SUM
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

    class BSTIterator {
        Stack<TreeNode> stack=new Stack<TreeNode>();
        boolean reverse=true;
        public BSTIterator(TreeNode root,boolean isReverse) {
            reverse=isReverse;
            pushALL(root);
        }

        public int next() {
            TreeNode curr=stack.pop();
            if(reverse==false)
                pushALL(curr.right);
            else
                pushALL(curr.left);

            return curr.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
        public void pushALL(TreeNode node){
            while(node!=null){
                stack.push(node);
                if(reverse==false)
                    node=node.left;
                else
                    node=node.right;
            }
        }
    }
    class Solution {
        public boolean findTarget(TreeNode root, int k) {
            if(root==null) return false;
            BSTIterator l=new BSTIterator(root,false);
            BSTIterator r=new BSTIterator(root,true);
            int i=l.next();
            int j=r.next();
            while(i<j)
            {
                if(i+j==k) return true;

                if(i+j<k) i=l.next();
                else
                    j=r.next();
            }
            return false;
        }
    }
}
