package Tree.BST;

public class ValidateBST
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
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root,long minVal,long maxVal)
    {
        if(root==null) return true;  //it means we reached the last node successfully
        if(root.val>=maxVal||root.val<=minVal) return false;  //inmai se ek bhi condition fail ho gayi it means BST valid nahi hai
        return (isValidBST(root.left,minVal,root.val)&&isValidBST(root.right,root.val,maxVal));
    }
}
