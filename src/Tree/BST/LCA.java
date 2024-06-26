package Tree.BST;

public class LCA
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
        if(root==null)  return null;

        int curr=root.val;

        if(p.val<curr&&q.val<curr)
            return lowestCommonAncestor(root.left,p,q);

        if(p.val>curr&&q.val>curr)
            return lowestCommonAncestor(root.right,p,q);

        return root;
    }

}
