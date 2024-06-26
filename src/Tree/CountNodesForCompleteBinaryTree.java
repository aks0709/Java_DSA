package Tree;

public class CountNodesForCompleteBinaryTree
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

  //brute force
    //T.C=O(logN)
  public int countNodes(TreeNode root) {
      if(root==null)
          return 0;

      int l=countNodes(root.left);
      int r=countNodes(root.right);

      return 1+l+r;
  }

  //optimised T.C=O(logN^2))
    public int countNodes2(TreeNode root)
    {
        if(root==null)
            return 0;

        int lh=getLeftHeight(root);
        int rh=getRightHeight(root);

        if(lh==rh)  return ((2<<(lh))-1);
        else return 1+countNodes2(root.left)+countNodes2(root.right);



    }

    public int getLeftHeight(TreeNode root)
    {
        int count=0;
        while(root.left!=null)
        {
            count++;
            root=root.left;
        }
        return count;
    }

    public int getRightHeight(TreeNode root)
    {
        int count=0;
        while(root.right!=null)
        {
            count++;
            root=root.right;
        }
        return count;
    }
}
