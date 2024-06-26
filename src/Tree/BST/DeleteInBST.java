package Tree.BST;

public class DeleteInBST
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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)   return root;

        if(root.val==key)  return helper(root);

        TreeNode dummy=root; //to track the root of the tree

        while(root!=null)
        {
            if(root.val>key)
            {
                if(root.left!=null&&root.left.val==key)
                {
                    root.left=helper(root.left);
                    break;
                }
                else
                    root=root.left;
            }
            else
            {

                if(root.right!=null&&root.right.val==key)
                {
                    root.right=helper(root.right);
                    break;
                }
                else
                    root=root.right;

            }
        }
        return dummy;
    }
    public TreeNode helper(TreeNode root)
    {
        if(root.left==null)
            return root.right;

        else if(root.right==null)
            return root.left;
        else{

            TreeNode rightchild=root.right;
            TreeNode lastRight=findlastRight(root.left);
            lastRight.right=rightchild;
            return root.left;
        }
    }

    public TreeNode findlastRight(TreeNode root)
    {
        if(root.right==null)
            return root;

        return findlastRight(root.right);
    }
}
