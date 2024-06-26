package Tree;

public class LowestCommonAncestor
{
    public static void main(String[] args) {

    }
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||root==p||root==q)
        {
            return root;  //we are returning root ,also for condition root==null
        }

        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);

        //result
        //if from one side we are getting null and other side we are getting root then consider root

        if(left==null)
        {
            return right;
        }
        else if(right==null)
        {
            return left;
        }
        else{
            return root;//when both left and right not equal to null
        }
    }
}
