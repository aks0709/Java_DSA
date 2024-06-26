package Tree;

public class MinDepthOfBinaryTree
{
    public static void main(String[] args) {

    }
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
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;

        int l=minDepth(root.left);
        int r=minDepth(root.right);

        if(l==0)
            return 1+r;
        else if(r==0)
            return 1+l;

        else return 1+min(l,r);
    }

    public int min(int a ,int b)
    {
        if(a<=b)
            return a;
        else
            return b;
    }
}
