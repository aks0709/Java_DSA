package Tree.BST;

import java.util.Stack;

public class BSTiterator
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
    Stack<TreeNode> stack=new Stack<TreeNode>();
    public BSTiterator(TreeNode root) {
        pushALL(root);
    }

    public int next() {
        TreeNode curr=stack.pop();
        pushALL(curr.right);
        return curr.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
    public void pushALL(TreeNode node){
        while(node!=null){
            stack.push(node);
            node=node.left;
        }
    }
}
